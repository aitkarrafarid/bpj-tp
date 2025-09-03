package tp_cyclomatique;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainExe {
   private static final int TAILLE_LISTE = 1000000;

   public static void main(String[] args) {
      List<Integer> listeEntier = new ArrayList<Integer>();
      Date debut;
      // List<Integer> listeEntier = new LinkedList<Integer>();
      System.out.println(
         "------Debut-------"
            + listeEntier.getClass());
      for (int i = 0; i < TAILLE_LISTE; i++) {
         listeEntier.add(i);
      }
      for (int i = 0; i < 100; i++) {
         listeEntier.add(1);
      }
      System.out.println(
         "taille de la liste d entiers suite creation ="
            + listeEntier.size());
      System.out.println(memoireUtilisee());
      debut = new Date();
      for (int i = 0; i < 5000; i++) {
         listeEntier.remove(100);
      }
      System.out.println(
         "taille de la liste d entiers suite destruction="
            + listeEntier.size());
      long duree =
         new Date().getTime()
            - debut.getTime();
      if (duree < 1000) {
         System.out.println("duree negligeable");
      }
      else {
         System.out.println(
            "duree="
               + duree
               + " ms");
      }
   }

   private static String memoireUtilisee() {
      return "Mémoire utilisée : " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
   }

}
