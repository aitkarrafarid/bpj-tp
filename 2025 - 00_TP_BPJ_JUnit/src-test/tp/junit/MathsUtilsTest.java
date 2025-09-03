package tp.junit;
// Fichier : "MathsUtilsTest.java"


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
    * Cas d'exception : tester la division par z�ro.
    */
   @Test(expected = DivisionByZeroException.class)
   public void dividedBy_CE() {
      MathsUtils.dividedBy(10, 0);
   }
}
