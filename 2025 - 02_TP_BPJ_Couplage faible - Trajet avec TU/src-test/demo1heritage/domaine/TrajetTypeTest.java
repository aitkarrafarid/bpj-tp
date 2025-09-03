package demo1heritage.domaine;

import org.junit.Assert;
import org.junit.Test;

public class TrajetTypeTest {

   @Test
   public void test() {
      TrajetType[] tabTrajet = {
         new TrajetAvion("depart1", "arrivee1", 120),
         new TrajetTrain("depart2", "arrivee2", 120),
      };
      
      // Avion
      Assert.assertEquals(12000, tabTrajet[0].calculCout());
      // Train
      Assert.assertEquals(1200, tabTrajet[1].calculCout());
   }

}
