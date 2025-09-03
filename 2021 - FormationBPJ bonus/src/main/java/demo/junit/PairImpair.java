package demo.junit;

import java.util.ArrayList;
import java.util.List;

public class PairImpair {

   private List<Integer> mesEntiers = new ArrayList<Integer>();

   public PairImpair(List<Integer> mesEentiers) {
      super();
      this.mesEntiers = mesEentiers;
   }

   public int donneNbEntiersPairs () {
      int retour = 0;
      for (int i : mesEntiers) {
         if (i % 2 == 0) {
            retour++;
         }
      }
      return retour;
   }

   public int donneNbEntiersImpairs () {

      int retour = 0;
      for (int i : mesEntiers) {
         if (i % 2 == 1) {
            retour++;
         }
      }
      return retour;
   }

}
