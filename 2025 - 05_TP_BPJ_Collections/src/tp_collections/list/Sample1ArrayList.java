/**
 * 
 */
package tp_collections.list;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * 1�) Ecrire une m�thode qui cr�e une liste de 1 million d�entiers (de 1 � 1 000 000). Ajouter 100 fois le nombre 1. constater la taille de la liste. On utilisera un ArralyList (et bien sur des Integer c�est � dire une classe java pour les entiers et non un type primitif).
 * 2�) D�truire 5000 fois l��l�ment de rang 100. V�rifier la taille de la liste. Afficher la dur�e d�ex�cution et la m�moire utilis�e (voir Runtime.getRuntime()
 */
public class Sample1ArrayList {

   /**
    * Ecrire une m�thode qui cr�e une liste de 1 million d�entiers (de 1 � 1 000 000). Ajouter 100 fois le nombre 1. constater la taille de la liste. On utilisera un ArralyList (et bien sur des Integer c�est � dire une classe java pour les entiers et non un type primitif).
    */
   private static List<Integer> etape1() {
      List<Integer> listInteger = new ArrayList<Integer>();
      // Ajouter 1 million d�entiers
      for (int i = 0; i < 1000000; i++) {
         listInteger.add(i);
      }

      // Ajouter 100 fois le nombre 1
      for (int i = 0; i < 100; i++) {
         // Rq : on met la m�me valeur
         listInteger.add(1);
      }

      System.out.println(
         "Etape 1 : listInteger.size() = "
            + listInteger.size());
      Assert.assertTrue(listInteger.size() == 1000100);
      // Conclusion :
      // Dans un ArrayList, on peut mettre des doublons

      return listInteger;
   }

   /**
    * D�truire 5000 fois l��l�ment de rang 100. V�rifier la taille de la liste. Afficher la dur�e d�ex�cution et la m�moire utilis�e (voir Runtime.getRuntime()
    */
   private static void etape2() {
      long start;
      long end;
      long startMem = Runtime.getRuntime().freeMemory();

      List<Integer> listInteger = etape1();
      System.out.println("-------------------------------");

      start = System.currentTimeMillis();
      // D�truire 5000 fois l��l�ment de rang 100
      for (int i = 0; i < 5000; i++) {
         listInteger.remove(100);
      }
      end = System.currentTimeMillis();
      long endMem = Runtime.getRuntime().freeMemory();
      System.out.println("Etape2");
      System.out.println(
         "   Temps en ms        : "
            + (end
               - start));
      System.out.println(
         "   Occupation m�moire : "
            + (startMem
               - endMem));
      // Conclusion :
      // ... Temps en ms        : 7020
      // L'ArrayList prend du temps pour la suppression !
   }

   public static void main(String[] args) {
      etape2();
   }
}
