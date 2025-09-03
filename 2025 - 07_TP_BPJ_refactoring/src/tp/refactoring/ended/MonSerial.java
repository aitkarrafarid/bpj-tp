package tp.refactoring.ended;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MonSerial {

   private static final String NOM_FIC_DEFAUT = "essai.dat";
   // on enveloppe les deux API
   FileOutputStream fos;
   FileInputStream fis;

   public static void main(String[] args) {
      MonSerial ms = new MonSerial();
      try {
         ms.sauvegarder(NOM_FIC_DEFAUT);
         ms.charger();
      }
      catch (MonAppliException e) {
         System.out.println("Une erreur est intervenue, le traitement s'est arrêté ...");
      }

   }

   public void sauvegarder(String fichierSortie) throws MonAppliException {
      try {
         fos = new FileOutputStream(fichierSortie);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         // j'écris dans un certain sens, ici un string puis un entier puis
         // un string
         oos.writeObject("Bruno");
         oos.writeObject(1000);
         oos.writeObject("Berlemont");
         oos.close();
      }
      catch (FileNotFoundException e) {
         throw new MonAppliException("Fichier non trouvé", e);
      }
      catch (IOException e) {
         throw new MonAppliException("Fichier non accessible", e);
      }
      finally {

      }
   }

   public void charger() throws MonAppliException {
      try {
         fis = new FileInputStream(NOM_FIC_DEFAUT);
         ObjectInputStream ois = new ObjectInputStream(fis);
         // je relis dans le même sens
         String chaine = (String) ois.readObject();
         System.out.println(chaine);
         int entier = (Integer) ois.readObject();
         System.out.println(entier);
         chaine = (String) ois.readObject();
         System.out.println(chaine);
         ois.close();

      }
      catch (FileNotFoundException e) {
         throw new MonAppliException("Fichier non trouvé", e);
      }
      catch (IOException e) {
         throw new MonAppliException("Fichier non accessible", e);
      }
      catch (ClassNotFoundException e) {
         throw new MonAppliException("classe non accessible", e);

      }
   }
}
