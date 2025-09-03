// Fichier : "ListInteger.java"
package tp.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class ListInteger {
   private static final int TAILLE_LISTE = 1000000;

   public static void main (String[] args) {
      List<Integer> listeEntier = new ArrayList<Integer>();
      Date debut;
      // List<Integer> listeEntier = new LinkedList<Integer>();
      System.out.println("------Debut-------" + listeEntier.getClass());
      for (int i = 0; i < TAILLE_LISTE; i++) {
         listeEntier.add(i);
      }
      for (int i = 0; i < 100; i++) {
         listeEntier.add(1);
      }
      System.out.println("taille de la liste d entiers suite creation ="
            + listeEntier.size());
      System.out.println(memoireUtilisee());
      debut = new Date();
      for (int i = 0; i < 5000; i++) {
         listeEntier.remove(100);
      }
      System.out.println("taille de la liste d entiers suite destruction="
            + listeEntier.size());
      System.out.println("duree=" + (new Date().getTime() - debut.getTime())
            + " ms");
   }

   static public String memoireUtilisee () {
      return " memoire utilisee = "
            + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
                  .freeMemory()) / (1024l)
            + " Ko";
   }
}