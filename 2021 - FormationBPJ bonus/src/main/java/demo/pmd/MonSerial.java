package demo.pmd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import demo.exception.MonappliException;

public class MonSerial {

   public static void main (String[] args) {
      MonSerial ms = new MonSerial();
      try {
         ms.sauvegarder();
         ms.charger();
      }
      catch (MonappliException e) {
         System.out
               .println("Une erreur est intervenue, le traitement s'est arr�t� ...");
      }

   }

   public void sauvegarder () throws MonappliException {
      try {
         final FileOutputStream fos = new FileOutputStream("essai.dat");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         // j'�cris dans un certain sens, ici un string puis un entier puis
         // un string
         oos.writeObject("Bruno");
         oos.writeObject(1000);
         oos.writeObject("Berlemont");
         oos.close();
      }
      catch (FileNotFoundException e) {
         throw new MonappliException("Fichier non trouv�", e);
      }
      catch (IOException e) {
         throw new MonappliException("Fichier non accessible", e);
      }
      finally {

      }
   }

   public void sauvegardertxt () throws MonappliException {
      try {
         final FileOutputStream fos = new FileOutputStream("essai.txt");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         // j'�cris dans un certain sens, ici un string puis un entier puis
         // un string
         oos.writeObject("Bruno");
         oos.writeObject(1000);
         oos.writeObject("Berlemont");
         oos.close();
      }
      catch (FileNotFoundException e) {
         throw new MonappliException("Fichier non trouv�", e);
      }
      catch (IOException e) {
         throw new MonappliException("Fichier non accessible", e);
      }
      finally {

      }
   }

   public void charger () throws MonappliException {
      try {
         final FileInputStream fis = new FileInputStream("essai.dat");
         ObjectInputStream ois = new ObjectInputStream(fis);
         // je relis dans le m�me sens
         String chaine = (String) ois.readObject();
         System.out.println(chaine);
         int entier = (Integer) ois.readObject();
         System.out.println(entier);
         chaine = (String) ois.readObject();
         System.out.println(chaine);
         ois.close();

      }
      catch (FileNotFoundException e) {
         throw new MonappliException("Fichier non trouv�", e);
      }
      catch (IOException e) {
         throw new MonappliException("Fichier non accessible", e);
      }
      catch (ClassNotFoundException e) {
         throw new MonappliException("classe non accessible", e);

      }
   }
}
