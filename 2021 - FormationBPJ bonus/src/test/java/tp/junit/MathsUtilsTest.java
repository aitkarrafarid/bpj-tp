// Fichier : "MathsUtilsTest.java"
package tp.junit;

import org.junit.Assert;
import org.junit.Test;

public class MathsUtilsTest {

   /**
    * Cas nominal d'une division euclidienne.
    */
   @Test
   public void dividedBy_CN() {
      double actual = MathsUtils.dividedBy(10d, 5d);
      Assert.assertTrue(actual == 2);
   }

   /**
    * Cas d'exception : tester la division par zéro.
    */
   @Test(expected = DivisionByZeroException.class)
   public void dividedBy_CE() {
      MathsUtils.dividedBy(10, 0);
   }
}
