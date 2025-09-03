package demo.dim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoDimensionnement {
   
   private static final int NB_MAX = 20;

   public static void main (String[] args) {
      try {
         sans();
         avec();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static void avec () {
      List<String> list = new ArrayList<>(NB_MAX);
      for (int i = 0; i < NB_MAX; i++) {
         list.add("elem" + i);
      }
   }

   private static void sans () {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < NB_MAX; i++) {
         list.add("elem" + i);
      }      
   }
}
