package demo.exception;

public class MonappliException extends Exception {

   private static final long serialVersionUID = 6550618134907853900L;

   /**
    * Constructeur simple.
    * 
    * @param message
    *            message lié a cette exception
    */
   public MonappliException(String message) {
      super(message);
   }

   /**
    * Constructeur permettant le chainage des exceptions.
    * 
    * @param message
    *            message lié à cette exception
    * @param e
    *            exception ayant déclenché cette exception
    */
   public MonappliException(String message, Throwable e) {
      super(message, e);
   }
}
