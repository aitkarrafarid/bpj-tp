package demo.exception;

public class MathsUtils {

   /**
    * Permet de diviser 2 nombres.
    * @param a Le nombre divisé.
    * @param b Le diviseur.
    * @return Le résultat de la division.
    * @throws DividedException 
    */
   public static double dividedBy (int a, int b) throws DividedException {
      double result;

      if (b == 0) {
         try {
            result = a / b;
         }
         catch (Exception err) {
            throw new DividedException("La division de " + a + " par zéro est impossible !", err);
         }
      }
      else {
         result = a / b;
      }
      return result;
   }

}
