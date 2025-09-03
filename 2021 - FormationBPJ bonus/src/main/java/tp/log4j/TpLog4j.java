package tp.log4j;

import org.apache.log4j.Logger;

public class TpLog4j {

   private static final Logger logger = Logger.getLogger(TpLog4j.class);

   /**
    * @param args
    */
   public static void main (String[] args) {
      logger.info("message courant a afficher dans le cadre du TP log4j dans le repertoire chosi par la production");
   }
}
