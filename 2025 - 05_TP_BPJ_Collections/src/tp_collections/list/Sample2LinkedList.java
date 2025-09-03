/**
 * 
 */
package tp_collections.list;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

/**
 * 3°) Répéter les étapes précédentes avec un LinkedList et constater les différences de comportement.
 */
public class Sample2LinkedList {

   /**
    * Ecrire une méthode qui crée une liste de 1 million d’entiers (de 1 à 1 000 000). Ajouter 100 fois le nombre 1. constater la taille de la liste. On utilisera un ArralyList (et bien sur des Integer c’est à dire une classe java pour les entiers et non un type primitif).
    */
   private static List<Integer> etape1() {
      List<Integer> listInteger = new LinkedList<Integer>();
      // Ajouter 1 million d’entiers
      for (int i = 0; i < 1000000; i++) {
         listInteger.add(i);
      }

      // Ajouter 100 fois le nombre 1
      for (int i = 0; i < 100; i++) {
         // Rq : on met la même valeur
         listInteger.add(1);
      }

      System.out.println(
         "Ajout de 1 million de \"i\" et 100 \"1\" : listMyType.size() = "
            + listInteger.size());
      Assert.assertTrue(listInteger.size() == 1000100);
      // Conclusion :
      // Dans un LinkedList, on peut mettre des doublons

      return listInteger;
   }

   /**
    * Détruire 5000 fois l’élément de rang 100. Vérifier la taille de la liste. Afficher la durée d’exécution et la mémoire utilisée (voir Runtime.getRuntime()
    */
   private static void etape2() {
      long start;
      long end;
      long startMem = Runtime.getRuntime().freeMemory();

      System.out.println("-------------------------------");
      List<Integer> listInteger = etape1();

      start = System.currentTimeMillis();
      // Détruire 5000 fois l’élément de rang 100
      for (int i = 0; i < 5000; i++) {
         listInteger.remove(100);
      }
      end = System.currentTimeMillis();
      long endMem = Runtime.getRuntime().freeMemory();
      System.out.println(
         "Suppression de 500 éléments : listMyType.size() = "
            + listInteger.size());
      System.out.println(
         "   Temps en ms        : "
            + (end
               - start));
      System.out.println(
         "   Occupation mémoire : "
            + (startMem
               - endMem));
      // Conclusion :
      // ... Temps en ms        : 16
      // Le LinkedList va plus vite que l'ArrayList pour la suppression
   }

   public static void main(String[] args) {
      etape2();
   }
}
