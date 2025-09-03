package demo.test_first;

public class MathsUtils {

   public static double diviserPar (int a, int b) {
//		throw new UnsupportedOperationException("M�thode non impl�ment�e pour l'instant");
      double result;

      if (b == 0) {
         throw new IllegalArgumentException("Division par z�ro impossible");
      }
      else {
         result = a / b;
      }

      return result;
   }

}
