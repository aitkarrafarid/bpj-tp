package demo.exception;

public class DividedException
//   extends RuntimeException {
      extends Exception {

   public DividedException(String message, Throwable cause) {
      super(message, cause);
   }

}
