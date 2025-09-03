package tp_exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BP : Toujours fermer une ressource ouverte.
 */
public class BP3_ToujoursFermer {
   /** Déclaration du logger. */
   private static final Logger logger = Logger.getLogger(BP3_ToujoursFermer.class.getName());

   public static void main (String[] args) {
      BP3_ToujoursFermer instance = new BP3_ToujoursFermer();
      try {
         String pathname = "resources2/data.txt";
         instance.lireFichier(pathname);  // Version avec finally
         instance.lireFichier2(pathname); // Version avec "try with resource"
      }
      catch (Exception e) {
         logger.log(Level.SEVERE, "Erreur", e);
      }
   }

   private void lireFichier (String pathname) throws IOException {
      BufferedReader lecteur = null;
      File vFile = new File(pathname);
      try {
         lecteur = new BufferedReader(new FileReader(vFile.getAbsolutePath()));
         String ligne;
         while ((ligne = lecteur.readLine()) != null) {
            System.out.println(ligne);
         }
      }
      catch (IOException e) {
         // Remonter l'erreur après l'avoir enrichie à l'appelant
         throw new IOException("Erreur lors de la lecture du fichier : " + vFile.getAbsolutePath(), e);
      }
      finally {
         if (lecteur != null) {
            lecteur.close();
            System.out.println("Fichier fermé.");
         }
      }
   }
   
   /**
    * Version avec un "try with resource".
    * @param pathname Le chemin en absolu vers le fichier.
    * @throws IOException Si une erreur d'E/S se produit.
    */
   private void lireFichier2 (String pathname) throws IOException {
      File vFile = new File(pathname);
      try (BufferedReader lecteur = new BufferedReader(new FileReader(vFile.getAbsolutePath()))) {
         String ligne;
         while ((ligne = lecteur.readLine()) != null) {
            System.out.println(ligne);
         }
      } // FIN du try déclanchant la fermeture de la ressource
      catch (IOException e) {
         // Remonter l'erreur après l'avoir enrichie à l'appelant
         throw new IOException("Erreur lors de la lecture du fichier : " + vFile.getAbsolutePath(), e);
      }
   }

}
