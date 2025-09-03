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

      // TODO Il faut avoir lanc� avec param�tre VM :
      // -DcheminLog="../log"
      String cheminLog = System.getProperties().getProperty("cheminLog");
      System.out.println(
         "${cheminLog} = "
            + cheminLog);

      logger.trace("TRACE - D�but du main");
      logger.debug("DEBUG - D�but du main");
      logger.info("INFO - D�but du main");
      logger.warn("WARN - D�but du main");
      logger.error("ERROR - D�but du main");
      logger.fatal("FATAL - D�but du main");
   }

}
