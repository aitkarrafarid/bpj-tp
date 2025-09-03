// Fichier : "BP2_GererAuTop.java"
package tp_exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BP : Gérer les exceptions au niveau de la couche "présentation (= IHM).
 */
public class BP2_GererAuTop {
   /** Déclaration du logger. */
   private static final Logger logger = Logger.getLogger(BP1_JamaisCatchVide.class.getName());

   public static void main (String[] args) {
      BP2_GererAuTop instance = new BP2_GererAuTop();
      try {
         String pathname = "resources2/data.txt";
         instance.lireFichier(pathname);
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
}
