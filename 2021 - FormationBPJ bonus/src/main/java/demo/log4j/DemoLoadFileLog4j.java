/**
 * 
 */
package demo.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * TP Log4J avec chargement du Properties.
 */
public class DemoLoadFileLog4j {

   private static final Logger logger = Logger.getLogger(DemoLoadFileLog4j.class);

   public static void main (String[] args) {
      // Charger le Properties
      PropertyConfigurator.configure("conf/log4j.properties");

      // TODO Il faut avoir lancé avec parametre VM :
      // -DcheminLog="../log"
      String cheminLog = System.getProperties().getProperty("cheminLog");
      System.out.println("${cheminLog} = " + cheminLog);

      logger.trace("TRACE - Debut du main");
      logger.debug("DEBUG - Debut du main");
      logger.info("INFO - Debut du main");
      logger.warn("WARN - Debut du main");
      logger.error("ERROR - Debut du main");
      logger.fatal("FATAL - Debut du main");
   }

}
