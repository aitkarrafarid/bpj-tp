package tp.log4j;

import org.apache.log4j.Logger;

public class TpLog4jExterne {

   private static final Logger logger = Logger.getLogger(TpLog4jExterne.class);

   /**
    * @param args
    */
   public static void main (String[] args) {
      logger.info("message courant a afficher dans le cadre du TP log4j variante externe");
      if (logger.isTraceEnabled()) {
         logger.trace("message specifique de type trace a afficher  depuis l'exterieur de l'application dans le cadre du TP log4j");
      }
   }
}
