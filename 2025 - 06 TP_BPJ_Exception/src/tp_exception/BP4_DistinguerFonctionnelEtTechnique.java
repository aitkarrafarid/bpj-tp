package tp_exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BP : Distinguer les erreurs fonctionnelles et les erreurs techniques.
 */
public class BP4_DistinguerFonctionnelEtTechnique {
   /** Déclaration du logger. */
   private static final Logger logger = Logger.getLogger(BP4_DistinguerFonctionnelEtTechnique.class.getName());

   public static void main (String[] args) {
      BP4_DistinguerFonctionnelEtTechnique instance = new BP4_DistinguerFonctionnelEtTechnique();
      try {
         String pathname = "resources2/data.txt";
         instance.lireFichier(pathname);
      }
      catch (FonctionnelleException e) {
         logger.log(Level.SEVERE, "Erreur métier", e);
      }
      catch (TechniqueException e) {
         logger.log(Level.SEVERE, "Erreur technique", e);
      }
      catch (Exception e) {
         logger.log(Level.SEVERE, "Erreur", e);
      }
   }

   private void lireFichier (String pathName) throws TechniqueException, FonctionnelleException, IOException {
      if (pathName == null) {
         throw new FonctionnelleException("Le pathName est obligatoire");
      }
      BufferedReader lecteur = null;
      File vFile = new File(pathName);
      try {
         lecteur = new BufferedReader(new FileReader(vFile.getAbsolutePath()));
         String ligne;
         while ((ligne = lecteur.readLine()) != null) {
            System.out.println(ligne);
         }
      }
      catch (IOException e) {
         // Remonter l'erreur après l'avoir enrichie à l'appelant
         throw new TechniqueException("Erreur lors de la lecture du fichier : " + vFile.getAbsolutePath(), e);
      }
      finally {
         if (lecteur != null) {
            lecteur.close();
         }
      }
   }

// Début partie socle à extraire
//
   /**
    * Pour les erreurs métier.
    */
   class FonctionnelleException extends Exception {
      public FonctionnelleException(String message, Throwable cause) {
         super(message, cause);
      }

      public FonctionnelleException(String message) {
         super(message);
      }
   }

   /**
    * Pour les erreurs techniques.
    */
   class TechniqueException extends RuntimeException {
      public TechniqueException(String message, Throwable cause) {
         super(message, cause);
      }

      public TechniqueException(String message) {
         super(message);
      }
   }
//
// Fin partie socle à extraire
} // FIN class BP4_DistinguerFonctionnelEtTechnique