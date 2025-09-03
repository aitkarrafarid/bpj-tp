package demo.try_with_rsc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoTryWithRsc {

   public static void main (String[] args) {
      try {
         String inputFile = (new File("inputFile.txt")).getAbsolutePath();
         String outputFile = (new File("outputFile.txt")).getAbsolutePath();
         sans(inputFile, outputFile);
         avec(inputFile, outputFile);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Exemple sans le try whith resources.
    */
   private static void sans (String inputFile, String outputFile) throws IOException {
      FileInputStream fis = null;
      FileOutputStream fos = null;
      try {
         fis = new FileInputStream(inputFile);
         fos = new FileOutputStream(outputFile);

         // Ici on manipule nos deux fichiers (une copie de fichier, par exemple)

      }
      finally {
         if (fis != null) {
            fis.close();
         }
         if (fos != null) {
            fos.close();
         }
      }
   }

   /**
    * Exemple avec le try whith resources.
    */
   private static void avec (String inputFile, String outputFile) throws IOException {
      try (FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile)) {

         // Ici on manipule nos deux fichiers (une copie de fichier, par exemple)

      } // Appels aux méthodes close automatique
   }
}
