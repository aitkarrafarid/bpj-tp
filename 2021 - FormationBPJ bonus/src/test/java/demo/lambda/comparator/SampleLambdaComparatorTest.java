package demo.lambda.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import demo.lambda.comparator.data.Personne;
import socle.cours.IllustrationCoursAbstract;

// Pour réaliser un trie sur des POJO qui n’implémente pas « Comparable » ou dont la comparaison est différente à celle de l’implémentation du « compareTo() », il faut utiliser un « Comparator », et de préférence avec lambda expression plutôt qu’en classe anonyme, car dans tous les cas, on peut :
//                                    Avec Lambda           Sans Lambda 
// - En cas d’erreur c’est parlant    +++                   +++
// - Le code est lisible              +++                   +++
// - On peut utiliser le debugger     Oui                   Oui
public class SampleLambdaComparatorTest extends SampleLambdaAbstract {

   public SampleLambdaComparatorTest() {
      super(SampleLambdaComparatorTest.class.getName());
   }

   @Test
   public void avecLambda () {
      // Given
      List<Personne> list = initData_listPersonne();
      startChrono("alternative");
      for (int i = 0; i < NB_ITER; i++) {
         list.sort( (e1, e2) -> {
            String npe = null;
            npe.toString();
            final String nom1 = e1.getNom();
            final String nom2 = e2.getNom();
            int result = nom1.compareTo(nom2);
            return result;
         });

      }
//         afficher(listElementBareme);
      stopChrono();
   }

   @Test
   public void sansLambda () {
      // Given
      List<Personne> list = initData_listPersonne();
      startChrono("aPrivilegier");
      for (int i = 0; i < NB_ITER; i++) {
         // Définir le Comparator
         Comparator<Personne> compElem = new Comparator<Personne>() {
            @Override
            public int compare (final Personne e1, final Personne e2) {
               String npe = null;
               npe.toString();
               final String nom1 = e1.getNom();
               final String nom2 = e2.getNom();
               int result = nom1.compareTo(nom2);
               return result;
            }
         };
         // Lancer le trie
         list.sort(compElem);
      }
//         afficher(listElementBareme);
      stopChrono();
   }

}
