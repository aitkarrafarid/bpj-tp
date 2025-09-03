// Fichier "MathsUtils.java"
package tp.junit;

public class MathsUtils {
   /**
    * Permet de faire une division euclidienne : nb1 / nb2.
    * @param nb1 
    * @param nb2
    * @return Le résultat de la division.
    */
   public static double dividedBy (double nb1, double nb2) {
//		// TODO Méthode à implémenter : dividedBy
//		throw new UnsupportedOperationException("Méthode non implémenter !");
      if (nb2 == 0) {
         throw new DivisionByZeroException();
      }
      else {
         return nb1 / nb2;
      }
   }
}
