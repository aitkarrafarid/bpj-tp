package tp.decoupage.couche_presentation;

import tp.decoupage._non_decoupe.Connexion;
import tp.decoupage.couche_data.Note;
import tp.decoupage.couche_service.NoteService;

import java.util.Scanner;

public class NoteIhm {

	private Scanner sc = new Scanner(System.in);

    private NoteService noteService = new NoteService();

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
		System.out.println("3. Afficher la moyenne coefficient�e");
		System.out.println("4. Afficher la moyenne simple");
		System.out.println("5. Quitter");
		int retour = sc.nextInt();
		if (retour < 0 || retour > 5) {
			System.out.println("Erreur de saisie");
			return -1;
		}
		return retour;
	}

	public String saisieChaine() {
		return sc.next();
	}

	public void close() {
		sc.close();
	}

	public void doMenu() {
		int choix = 0;
		// init BDD
        noteService.initBDD();
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
				System.out.println(n + "  est enregistree !");
				break;
			case 3:
				System.out.println("Calcul moyenne ponderee :");
				int moyennePonderee = noteService.calculMoyennePonderee();
				System.out.println("la moyenne ponderee  est "
						+ moyennePonderee);
				break;
			case 4:
				System.out.println("Calcul moyenne simple :");
				int moyenneSimple = noteService.calculMoyenneSimple();
				System.out.println("la moyenne simple  est " + moyenneSimple);
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
		Connexion.close();
	}
}
