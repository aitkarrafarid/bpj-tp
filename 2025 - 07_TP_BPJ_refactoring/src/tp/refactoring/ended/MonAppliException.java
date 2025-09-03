package tp.refactoring.ended;

import java.io.IOException;

public class MonAppliException extends Exception {

   public MonAppliException(String message, Exception err) {
      super(message, err);
   }

   private static final long serialVersionUID = 1L;

}
