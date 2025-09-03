package td.decoupage.ihm;

import java.util.Scanner;

import td.decoupage.metier.Note;
import td.decoupage.service.NoteService;

public class NoteIhm implements INoteIhm {
   private Scanner sc = new Scanner(System.in);

   public void doMenu() throws Exception {
      int choix;
      NoteService noteService = new NoteService();
      // init BDD
      System.out.println(
         "initialisation de la structure de la BDD :  code retour = "
            + noteService.initBDD());
      do {
         choix = choixMenu();
         switch (choix) {
            case 1:
               System.out.println("Voici toutes les notes");
               System.out.println(noteService.getListeComplete());
               break;
            case 2:
               Note n = creerNote();
               noteService.enregistrerNote(n);
               System.out.println(
                  n
                     + "  est enregistree !");
               break;
            case 3:
               System.out.println("Calcul moyenne ponderee :");
               int moyennePonderee = noteService.calculMoyennePonderee();
               System.out.println(
                  "la moyenne ponderee  est "
                     + moyennePonderee);
               break;
            case 4:
               System.out.println("Calcul moyenne simple :");
               int moyenneSimple = noteService.calculMoyenneSimple();
               System.out.println(
                  "la moyenne simple  est "
                     + moyenneSimple);
               break;
            case 5:
               // Nothing to do
               break;
            default:
               System.out.println("Vous devez saisir 1, 2, 3, 4 ou 5 !!!");
               break;
         }
      } while (choix != 5);

      // Fermetures
      close();
      noteService.close();
   }

   public int choixMenu() {
      System.out.println("--- Menu General ---");
      System.out.println("1. Afficher toutes les notes");
      System.out.println("2. Saisie d'une nouvelle note");
      System.out.println("3. Afficher la moyenne coefficientée");
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
