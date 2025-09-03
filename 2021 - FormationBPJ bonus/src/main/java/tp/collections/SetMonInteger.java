// Fichier : "SetMonInteger.java"
package tp.collections;

import java.util.HashSet;
import java.util.Set;

public class SetMonInteger {
   private static final int TAILLE_LISTE = 1000000;

   public static void main (String[] args) {
      Set<MonInteger> listeEntier = new HashSet<MonInteger>();
      // List<Integer> listeEntier = new LinkedList<Integer>();
      System.out.println("------Debut-------" + listeEntier.getClass());
      for (int i = 0; i < TAILLE_LISTE; i++) {
         listeEntier.add(new MonInteger(i));
      }
      for (int i = 0; i < 100; i++) {
         listeEntier.add(new MonInteger(1));
      }
      System.out.println("taille de la liste d entiers suite creation ="
            + listeEntier.size());
   }

}