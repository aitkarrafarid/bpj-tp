package tp_exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BP : Indiquer des pistes de corrections potentielles de l'erreur.
 */
public class BP5_IndiquerSolutionsPossibles {
   /** Déclaration du logger. */
   private static final Logger logger = Logger.getLogger(BP5_IndiquerSolutionsPossibles.class.getName());

   public static void main (String[] args) {
      BP5_IndiquerSolutionsPossibles instance = new BP5_IndiquerSolutionsPossibles();
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
      catch (FileNotFoundException e) {
         // Remonter l'erreur après l'avoir enrichie à l'appelant
         throw new TechniqueException("Erreur fichier non trouvé : " + vFile.getAbsolutePath(), e,
               "Vérifier que le répertoire est correct",
               "Vérifier que le nom du fichier est correct");
      }
      catch (IOException e) {
         // Remonter l'erreur après l'avoir enrichie à l'appelant
         throw new TechniqueException("Erreur lors de la lecture du fichier : " + vFile.getAbsolutePath(), e,
               "Vérifier que les droits en lecture sur le répertoire pour le user sont positionnés");
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
      /** Les solutions potentielles pour corriger l'erreur. */
      private String[] tabSol;
      public FonctionnelleException(String message, Throwable cause, String... tabSol) {
         super(message, cause);
         this.tabSol = tabSol;
      }

      public FonctionnelleException(String message, String... tabSol) {
         super(message);
         this.tabSol = tabSol;
      }
      
      @Override
      public String toString () {
         String  vReturn = super.toString();
         if (tabSol != null) {
            vReturn = vReturn + "\nSolutions potentielles :";
            for (String sol : tabSol) {
               vReturn = vReturn + "\n   " + sol;
            }
         }
         return vReturn;
      }
   }

   /**
    * Pour les erreurs techniques.
    */
   class TechniqueException extends RuntimeException {
      /** Les solutions potentielles pour corriger l'erreur. */
      private String[] tabSol;
      public TechniqueException(String message, Throwable cause, String... tabSol) {
         super(message, cause);
         this.tabSol = tabSol;
      }

      public TechniqueException(String message, String... tabSol) {
         super(message);
         this.tabSol = tabSol;
      }
      
      @Override
      public String toString () {
         String  vReturn = super.toString();
         if (tabSol != null) {
            vReturn = vReturn + "\nSolutions potentielles :";
            for (String sol : tabSol) {
               vReturn = vReturn + "\n   " + sol;
            }
         }
         return vReturn;
      }
   }
//
// Fin partie socle à extraire
} // FIN class BP5_IndiquerSolutionsPossibles