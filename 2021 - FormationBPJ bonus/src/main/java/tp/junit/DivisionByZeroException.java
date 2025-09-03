// Fichier : "DivisionByZeroException.java"
package tp.junit;

public class DivisionByZeroException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   /**
    * Constructeur par défaut.
    */
   public DivisionByZeroException() {
      super("Division par zéro impossible !");
   }
}
