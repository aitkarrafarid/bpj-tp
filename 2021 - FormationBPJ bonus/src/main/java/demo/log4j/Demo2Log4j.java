package demo.log4j;

import org.apache.log4j.Logger;

public class Demo2Log4j {

   // TODO Cf. paramétrage "log4j.logger.demo.log4j.Demo2Log4" dans "src\main\ressources\log4j.properties"
   private static final Logger logger = Logger.getLogger(Demo2Log4j.class);
//   private static final Logger logger = Logger.getLogger(Demo1Log4j.class);

   public static void main (String[] args) {
      messageDeLog();
   }

   /**
    * @param args
    */
   public static void messageDeLog () {
      logger.trace("message de type trace");
   }
}
