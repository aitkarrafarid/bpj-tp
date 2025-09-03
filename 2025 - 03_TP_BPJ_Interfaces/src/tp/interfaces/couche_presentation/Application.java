package tp.interfaces.couche_presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import tp.interfaces.couche_data.Note;
import tp.interfaces.couche_service.NoteService;

public class Application {
   private NoteService noteService = new NoteService();

   private static Scanner sc = new Scanner(System.in);

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

   public static void main(String[] args) {
      Application application = new Application();
      try {
         application.saisie();
      }
      catch (ClassNotFoundException | SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   private void saisie() throws ClassNotFoundException, SQLException {
      int choix = 0;
      // init BDD
      System.out.println(
         "initialisation de la structure de la BDD :  code retour = "
            + initBDD());
      do {
         choix = choixMenu();
         switch (choix) {
            case 1:
               System.out.println("Voici toutes les notes");
               System.out.println(getListeComplete());
               break;
            case 2:
               Note n = creerNote();
               enregistrerNote(n);
               System.out.println(
                  n
                     + "  est enregistree !");
               break;
            case 3:
               System.out.println("Calcul moyenne ponderee :");
               int moyennePonderee = calculMoyennePonderee();
               System.out.println(
                  "la moyenne ponderee  est "
                     + moyennePonderee);
               break;
            case 4:
               System.out.println("Calcul moyenne simple :");
               int moyenneSimple = calculMoyenneSimple();
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
      close();
   }

   // partie BDD
   public int initBDD() throws ClassNotFoundException, SQLException {
      return noteService.initBDD();
   }

   public void enregistrerNote(Note n) throws ClassNotFoundException, SQLException {
      noteService.enregistrerNote(n);
   }

   public List<Note> getListeComplete() throws ClassNotFoundException, SQLException {
      return noteService.getListeComplete();
   }

   public int calculMoyennePonderee() throws ClassNotFoundException, SQLException {
      return noteService.calculMoyennePonderee();
   }

   public int calculMoyenneSimple() throws ClassNotFoundException, SQLException {
      return noteService.calculMoyenneSimple();
   }

   public void close() throws SQLException {
      noteService.close();
      sc.close();
   }

   //
   // Méthodes utilitaires
   //

   public static String saisieChaine() {
      return sc.next();
   }

}
