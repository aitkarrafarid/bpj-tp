package tp.refactoring._nonrefactore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import demo.exception.MonAppliException;

public class MonSerial {

   // on enveloppe les deux API
   FileOutputStream fos;
   FileInputStream fis;

   public static void main(String[] args) {
      MonSerial ms = new MonSerial();
      try {
         ms.sauvegarder();
         ms.charger();
      }
      catch (MonAppliException e) {
         System.out.println("Une erreur est intervenue, le traitement s'est arrêté ...");
      }

   }

   public void sauvegarder() throws MonAppliException {
      try {
         fos = new FileOutputStream("essai.dat");
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
         fis = new FileInputStream("essai.dat");
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
         throw new MonappliException("classe non accessible", e);

      }
   }
}
