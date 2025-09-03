package demo2composition.domaine;

import org.junit.Assert;
import org.junit.Test;

public class TrajetTest {

   @Test
   public void test() {
      Trajet[] tabTrajet = {
         new Trajet("depart1", "arrivee1", 120, new ModeAvion()),
         new Trajet("depart2", "arrivee2", 120, new ModeTrain()),
      };

      // Avion
      Assert.assertEquals(12000, tabTrajet[0].getCout());
      // Train
      Assert.assertEquals(1200, tabTrajet[1].getCout());
   }

}
