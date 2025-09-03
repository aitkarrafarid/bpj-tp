package tp_log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * TP Log4J.
 */
public class TpLog4j {

   private static final Logger logger = Logger.getLogger(TpLog4j.class);

   public static void main(String[] args) {
      //PropertiesConfigurator is used to configure logger from properties file
      PropertyConfigurator.configure("conf/log4j.properties");

      // TODO Il faut avoir lancé avec paramètre VM :
      // -DcheminLog="../log"
      String cheminLog = System.getProperties().getProperty("cheminLog");
      System.out.println(
         "${cheminLog} = "
            + cheminLog);

      logger.trace("TRACE - Début du main");
      logger.debug("DEBUG - Début du main");
      logger.info("INFO - Début du main");
      logger.warn("WARN - Début du main");
      logger.error("ERROR - Début du main");
      logger.fatal("FATAL - Début du main");
   }

}
