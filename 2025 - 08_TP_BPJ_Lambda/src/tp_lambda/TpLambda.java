package tp_lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import socle.cours.performance.Chrono;
import tp_lambda.comparator.data.Personne;

public class TpLambda {
   private Chrono _Chrono;
   private final int NB_ITER = 900;

   public TpLambda() {
      _Chrono = Chrono.newInstance("tp_lambda", System.out, false);
   }

   private List<Personne> initData_listPersonne () {
      return initData_listPersonne(1);
   }
   private List<Personne> initData_listPersonne (int nbIterations) {
      List<Personne> vReturn = new ArrayList<>();
      int i = 1;
      for (int j = 0; j < nbIterations ; j++) {
         vReturn.add(new Personne(i++, "ZOLA" + j));
         vReturn.add(new Personne(i++, "ALBERT" + j));
         vReturn.add(new Personne(i++, "DUPONT" + j));
         vReturn.add(new Personne(i++, "BONO" + j));
         vReturn.add(new Personne(i++, "AZERTY" + j));
      }
//      vReturn.add(new Personne(i++, null)); // Pour provoquer un NPE
      return vReturn;
   }

   private void startChrono (String chronoName) {
      System.out.println("");
      System.out.println("DEBUT " + chronoName);
      _Chrono.start();
   }

   private void stopChrono (String chronoName) {
      _Chrono.stop();
      System.out.println("FIN " + chronoName);
   }

   public static void main (String[] args) {
      TpLambda instance = new TpLambda();
      // TODO : Appeler les questions 
      // Q0
      instance.q0_sansLambda();
      instance.q0_avecLambda();
      
      // Q1
//      instance.q1_sansLambda();
//      instance.q1_avecLambda();
//      instance.q1_sansLambda_CE();
//      instance.q1_avecLambda_CE();

      // Q2
//      instance.q2_sansLambda();
//      instance.q2_avecLambda();
//    // Q2 CE
//    instance.q2_avecLambda_CE();
//    instance.q2_sansLambda_CE();

//      // Q3
//      instance.q3_avecLambda();
//      instance.q3_sansLambda();
   }

   /*
    * Q0 : Utilisation Lambda dans l'esprit Python qui plait à minima pour des usages IA ou manipulation Data. 
    */
   public void q0_avecLambda () {
      List<Personne> list = initData_listPersonne(1000000);
      startChrono("q1_avecLambda");
      // Transformer en minuscules et filtrer les noms commençant par 'A'
//      List<String> listFiltered = list.parallelStream()
      List<String> listFiltered = list.stream()
            .map(personne -> personne.getNom().toLowerCase()) // Transformer en minuscules
            .filter(nomMinuscule -> nomMinuscule.startsWith("a")) // Filtrer les noms commençant par 'a'
            .collect(Collectors.toList()); // Collecter les résultats dans une liste
      stopChrono("q1_avecLambda");
//      System.out.println(listFiltered);
   }
   public void q0_sansLambda () {
      List<Personne> list = initData_listPersonne(1000000);
      startChrono("q0_sansLambda");
      List<String> listFiltered = new ArrayList<>();
      // Transformer en minuscules et filtrer les noms commençant par 'A'
      for (Personne personne : list) {
         String nomMinuscule = personne.getNom().toLowerCase();
         if (nomMinuscule.startsWith("a")) {
            listFiltered.add(nomMinuscule);
         }
      }
      stopChrono("q0_sansLambda");
//      System.out.println(listFiltered);
   }
   
   /*
    * Q1 : Faire un Comparateur avec et sans Lamda. 
    */
   public void q1_avecLambda () {
      List<Personne> list = initData_listPersonne();
      startChrono("q1_avecLambda");
      // TODO : Ajouter la boucle
      for (int i = 0; i < NB_ITER; i++) {
         list.sort( (e1, e2) -> {
            final String nom1 = e1.getNom();
            final String nom2 = e2.getNom();
            int result = nom1.compareTo(nom2);
            return result;
         });
      }

      stopChrono("q1_avecLambda");
   }

   public void q1_avecLambda_CE () {
      List<Personne> list = initData_listPersonne();
      startChrono("q1_q1_avecLambda_CE");
      list.sort( (e1, e2) -> {
         final String nom1 = null;
         final String nom2 = e2.getNom();
         int result = nom1.compareTo(nom2);
         return result;
      });

      stopChrono("q1_q1_avecLambda_CE");
   }

   public void q1_sansLambda () {
      List<Personne> list = initData_listPersonne();
      startChrono("q1_sansLambda");
      // TODO : Ajouter la boucle
      for (int i = 0; i < NB_ITER; i++) {
         // Définir le Comparator
         Comparator<Personne> compElem = new Comparator<Personne>() {
            @Override
            public int compare (final Personne e1, final Personne e2) {
               final String nom1 = e1.getNom();
               final String nom2 = e2.getNom();
               int result = nom1.compareTo(nom2);
               return result;
            }
         };
         // Lancer le trie
         list.sort(compElem);
      }
      stopChrono("q1_sansLambda");
   }

   public void q1_sansLambda_CE () {
      List<Personne> list = initData_listPersonne();
      startChrono("q1_sansLambda_CE");
      // Définir le Comparator
      Comparator<Personne> compElem = new Comparator<Personne>() {
         @Override
         public int compare (final Personne e1, final Personne e2) {
            final String nom1 = null;
            final String nom2 = e2.getNom();
            int result = nom1.compareTo(nom2);
            return result;
         }
      };
      // Lancer le trie
      list.sort(compElem);
      stopChrono("q1_sansLambda_CE");
   }

   /*
    * Q2 : Faire un filtrage avec et sans Lamda. 
    */

   public void q2_avecLambda () {
      List<Personne> list = initData_listPersonne();
      final int id = 2;

      startChrono("q2_avecLambda");
//      for (int i = 0; i < NB_ITER; i++) {
      Personne result = list.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
//      }
      stopChrono("q2_avecLambda");
   }

   /**
    * Provoquer une erreur pour montrer la maintenabilité de la ST. 
    */
   public void q2_avecLambda_CE () {
      List<Personne> list = initData_listPersonne();
      // Ajouter le tuple pour provoquer l'erreur
      list.add(new Personne(null, null));
      final int id = 9999;

      startChrono("q2_avecLambda_CE");
      Personne result = list.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
      stopChrono("avecLambda_CE");
   }

   public void q2_sansLambda () {
      List<Personne> list = initData_listPersonne();
      final int id = 2;
      Personne result = null;

      startChrono("q2_sansLambda");
//      for (int i = 0; i < NB_ITER; i++) {
      // Parcourir la liste des entrepots
      for (Personne personne : list) {
         // SI on a trouvé l'élément
         if (personne.getId().equals(id)) {
            result = personne;
            break;
         }
      }
//      }
      stopChrono("q2_sansLambda");
   }

   /**
    * Test provoquant une erreur pour montrer la maintenabilité de la ST. 
    */
   public void q2_sansLambda_CE () {
      List<Personne> list = initData_listPersonne();
      // Ajouter le tuple pour provoquer l'erreur
      list.add(new Personne(null, null));
      final int id = 9999;
      Personne result = null;

      startChrono("q2_sansLambda_CE");
      // Parcourir la liste des entrepots
      for (Personne personne : list) {
         // SI on a trouvé l'élément
         if (personne.getId().equals(id)) {
            result = personne;
            break;
         }
      }
      stopChrono("q2_sansLambda_CE");
   }

   /*
    * Q3 : Lancer un thread avec et sans lambda.
    */
   public void q3_avecLambda () {
      startChrono("q3_avecLambda");
      Runnable thread = () -> {
         // Le traitement
         for (int cpt = 0; cpt <= 10; cpt++) {
            // RAS
         }
//            System.out.println("Le traitement du thread terminé");
      };
      new Thread(thread).start();
      stopChrono("q3_avecLambda");
   }

   public void q3_sansLambda () {
      startChrono("q3_sansLambda");
      Runnable thread = new Runnable() {
         @Override
         public void run () {
            // Le traitement
            for (int i = 0; i <= 10; i++) {
               // RAS
            }
//               System.out.println("Le traitement du thread terminé");
         }
      };
      new Thread(thread).start();
      stopChrono("q3_sansLambda");
   }

}
