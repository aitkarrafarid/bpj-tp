package demo.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Demo1Log4j {

   // TODO Cf. paramétrage "log4j.logger.demo.log4j.Demo1Log4" dans "src\main\ressources\log4j.properties"
   private static final Logger logger = Logger.getLogger(Demo1Log4j.class);

   /**
    * @param args
    */
   public static void main (String[] args) {
      // TODO log4j demo 1
      logger.info("message de type debug");
      logger.log(Level.DEBUG, "message de type debug via instruction log");

      // TODO log4j demo 2
      Demo2Log4j.messageDeLog();
   }
}
