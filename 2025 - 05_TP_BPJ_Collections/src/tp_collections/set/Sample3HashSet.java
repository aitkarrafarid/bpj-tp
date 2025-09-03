/**
 * 
 */
package tp_collections.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

/**
 * 1°) Ecrire une méthode qui crée une liste de 1 million d’entiers (de 1 à 1 000 000). Ajouter 100 fois le nombre 1. Constater la taille de la liste. On utilisera  ici un HashSet
 * 2°) créer une classe appelée MonInteger0 contenant un attribut de type Integer
 */
public class Sample3HashSet {

   /**
    * Ecrire une méthode qui crée une liste de 1 million d’entiers (de 1 à 1 000 000). Ajouter 100 fois le nombre 1. constater la taille de la liste. On utilisera un ArralyList (et bien sur des Integer c’est à dire une classe java pour les entiers et non un type primitif).
    */
   private static Set<Integer> etape1() {
      Set<Integer> setInteger = new HashSet<Integer>();
      // Ajouter 1 million d’entiers
      for (int i = 0; i < 1000000; i++) {
         setInteger.add(new Integer(i));
      }

      // Ajouter 100 fois le nombre 1
      for (int i = 0; i < 100; i++) {
         // Rq : on met la même valeur
         setInteger.add(new Integer(1));
      }

      System.out.println(
         "Ajout de 1 million de \"i\" et 100 \"1\" : listMyType.size() = "
            + setInteger.size());
      Assert.assertEquals(1000000, setInteger.size());
      // Conclusion :
      // Dans un HashSet, on NE PEUT PAS mettre des doublons

      return setInteger;
   }

   /**
    * Détruire 5000 fois l’élément de rang 100. Vérifier la taille de la liste. Afficher la durée d’exécution et la mémoire utilisée (voir Runtime.getRuntime()
    */
   private static void etape2() {
      long start;
      long end;
      long startMem = Runtime.getRuntime().freeMemory();

      Set<Integer> setInteger = etape1();
      System.out.println("-------------------------------");

      start = System.currentTimeMillis();
      // Détruire 5000 fois l’élément de valeur '100'
      for (int i = 0; i < 5000; i++) {
         setInteger.remove(new Integer(100));
      }
      end = System.currentTimeMillis();
      long endMem = Runtime.getRuntime().freeMemory();
      System.out.println(
         "Suppression de 500 éléments de valeur '100' : setInteger.size() = "
            + setInteger.size());
      System.out.println(
         "   Temps en ms        : "
            + (end
               - start));
      System.out.println(
         "   Occupation mémoire : "
            + (startMem
               - endMem));
      // Conclusion :
      // ... Temps en ms        : 0
      // Le HashSet est très rapide pour la suppression !
   }

   public static void main(String[] args) {
      etape2();
   }
}
