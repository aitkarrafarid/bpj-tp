package tp.junit;

public class MathsUtils {

   public static double dividedBy(double nb1, double nb2) {
      if (nb2 == 0) {
         throw new DivisionByZeroException();
      }
      return nb1/nb2;
   }

}
