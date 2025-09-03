package demo.exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MonSerial {

   // on enveloppe les deux API
   FileOutputStream fos;
   FileInputStream fis;

   public static void main (String[] args) {
      MonSerial ms = new MonSerial();
      try {
         ms.sauvegarder();
         ms.charger();
      }
      catch (Exception e) {
         System.err.println("Erreur  - le traitement s'est arrêté ...");
         e.printStackTrace();
      }

   }

   public void sauvegarder () throws MonappliException, IOException {
      ObjectOutputStream oos = null;
      try {
         fos = new FileOutputStream("essai.dat");
         oos = new ObjectOutputStream(fos);
         // Ecrire dans un certain sens, ici un String un entier et un String
         oos.writeObject("Bruno");
         oos.writeObject(1000);
         oos.writeObject("Berlemont");
      }
      finally {
         if (oos != null)
            oos.close();
      }
   }

   public void charger () throws MonappliException, IOException, ClassNotFoundException {
      ObjectInputStream ois = null;
      try {
         fis = new FileInputStream("essai.dat");
         ois = new ObjectInputStream(fis);
         // Relire dans le même sens
         String chaine = (String) ois.readObject();
         System.out.println(chaine);
         int entier = (Integer) ois.readObject();
         System.out.println(entier);
         chaine = (String) ois.readObject();
         System.out.println(chaine);
      }
      finally {
         if (ois != null)
            ois.close();
      }
   }
}
