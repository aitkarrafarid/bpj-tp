// Fichier : "BP1_JamaisCatchVide.java"
package tp_exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * BP : Ne pas laisser un catch vide.
 */
public class BP1_JamaisCatchVide {
   /** Déclaration du logger. */
   private static final Logger logger = Logger.getLogger(BP1_JamaisCatchVide.class.getName());

   /**
    * Configurer le logguer.
    * @throws IOException Si une erreur d'E/S se produit.
    */
   private static void configLogger () throws IOException {
      // Réinitialiser la config par défaut
      LogManager.getLogManager().reset();
      // Console handler
      ConsoleHandler consoleHandler = new ConsoleHandler();
      consoleHandler.setLevel(Level.ALL);
      consoleHandler.setFormatter(new SimpleFormatter());
      // File handler
      FileHandler fileHandler = new FileHandler("errors.log", true);
      fileHandler.setLevel(Level.ALL);
      fileHandler.setFormatter(new SimpleFormatter());
      logger.addHandler(consoleHandler);
      logger.addHandler(fileHandler);
   }
   
   public static void main (String[] args) throws Exception {
      configLogger();

      String pathname = "resources2/data.txt";
      BP1_JamaisCatchVide instance = new BP1_JamaisCatchVide();
      instance.lireFichier(pathname);
   }

   private void lireFichier (String pathname) {
      BufferedReader lecteur = null;
      File vFile = new File(pathname);
      try {
         lecteur = new BufferedReader(new FileReader(vFile.getAbsolutePath()));
         String ligne;
         while ((ligne = lecteur.readLine()) != null) {
            System.out.println(ligne);
         }
      }
      catch (FileNotFoundException e) {
//          System.err.println("Erreur fichier non trouvé : " + vFile.getAbsolutePath());
//         e.printStackTrace();
         logger.log(Level.SEVERE, "Erreur fichier non trouvé : " + vFile.getAbsolutePath(), e);
      }
      catch (IOException e) {
//          System.err.println("Erreur lors de la lecture du fichier : " + vFile.getAbsolutePath());
//          e.printStackTrace();
         logger.log(Level.SEVERE, "Erreur lors de la lecture du fichier : " + vFile.getAbsolutePath(), e);
      }
   }
}
