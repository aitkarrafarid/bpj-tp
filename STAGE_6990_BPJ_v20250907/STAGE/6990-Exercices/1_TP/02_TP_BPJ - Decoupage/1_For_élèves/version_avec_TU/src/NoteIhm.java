package td.decoupage._non_decoupe;

import java.util.Scanner;

public class NoteIhm implements INoteIhm {
   private static Scanner sc = new Scanner(System.in);

   public int choixMenu() {
      System.out.println("--- Menu General ---");
      System.out.println("1. Afficher toutes les notes");
      System.out.println("2. Saisie d'une nouvelle note");
      System.out.println("3. Afficher la moyenne coefficient�e");
      System.out.println("4. Afficher la moyenne simple");
      System.out.println("5. Quitter");
      int retour = sc.nextInt();
      if (retour < 0
         || retour > 5) {
         System.out.println("Erreur de saisie");
         return -1;
      }
      return retour;
   }

   @Override
   public Note creerNote() {
      System.out.println("--- Saisie d'une nouvelle note ---");
      System.out.println("Entrer la matiere : ");
      String matiere = sc.next();
      System.out.println("Entrer la note : ");
      int note = sc.nextInt();
      System.out.println("Entrer le coefficient : ");
      int coef = sc.nextInt();
      return new Note(matiere, note, coef);
   }

   @Override
   public void close() {
      sc.close();
   }

   public String saisieChaine() {
      return sc.next();
   }
}
