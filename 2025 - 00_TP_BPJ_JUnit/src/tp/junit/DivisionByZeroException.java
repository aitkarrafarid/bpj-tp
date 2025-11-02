package tp.junit;

public class DivisionByZeroException extends RuntimeException {

   public DivisionByZeroException() {
      super("Division par zero impossible");
   }
}
