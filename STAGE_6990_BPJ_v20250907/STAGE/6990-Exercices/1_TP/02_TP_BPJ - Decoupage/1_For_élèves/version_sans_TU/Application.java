package tp.decoupage._non_decoupe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	private static Scanner sc = new Scanner(System.in);

	public static Note creerNote() {
		System.out.println("--- Saisie d'une nouvelle note ---");
		System.out.println("Entrer la matiere : ");
		String matiere = sc.next();
		System.out.println("Entrer la note : ");
		int note = sc.nextInt();
		System.out.println("Entrer le coefficient : ");
		int coef = sc.nextInt();
		return new Note(matiere, note, coef);
	}

	public static int choixMenu() {
		System.out.println("--- Menu General ---");
		System.out.println("1. Afficher toutes les notes");
		System.out.println("2. Saisie d'une nouvelle note");
		System.out.println("3. Afficher la moyenne coefficientée");
		System.out.println("4. Afficher la moyenne simple");
		System.out.println("5. Quitter");
		int retour = sc.nextInt();
		if (retour < 0 || retour > 5) {
			System.out.println("Erreur de saisie");
			return -1;
		}
		return retour;
	}

	public static String saisieChaine() {
		return sc.next();
	}

	public static void close() {
		sc.close();
	}

	public static void main(String[] args) {
		int choix = 0;
		// init BDD
		System.out
				.println("initialisation de la structure de la BDD :  code retour = "
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
				System.out.println(n + "  est enregistree !");
				break;
			case 3:
				System.out.println("Calcul moyenne ponderee :");
				int moyennePonderee = calculMoyennePonderee();
				System.out.println("la moyenne ponderee  est "
						+ moyennePonderee);
				break;
			case 4:
				System.out.println("Calcul moyenne simple :");
				int moyenneSimple = calculMoyenneSimple();
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

	// partie BDD
	public static int initBDD() {
		PreparedStatement ps = null;
		// chargement Driver
		try {
			Connection c = Connexion.getConnexion();
			String sql = "create table NOTE (MATIERE char(30), NOTE INTEGER, COEFFICIENT INTEGER );";
			// ,age integer
			ps = c.prepareStatement(sql);
			int retour = ps.executeUpdate();
			if (retour == 0) {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public static void enregistrerNote(Note n) {
		PreparedStatement ps = null;
		try {
			Connection c = Connexion.getConnexion();
			// creation en BDD d'une nouvelle note
			String sql = "insert into NOTE (MATIERE,NOTE,COEFFICIENT) values (?,?,?)";
			ps = c.prepareStatement(sql);
			ps.setString(1, n.getMatiere());
			ps.setInt(2, n.getNote());
			ps.setInt(3, n.getCoefficient());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Note> getListeComplete() {
		List<Note> listePersonnesRetour = new ArrayList<Note>();
		Statement s = null;
		ResultSet r = null;
		try {
			Connection c = Connexion.getConnexion();
			// creation de la requete
			String sql = "select MATIERE,NOTE,COEFFICIENT from NOTE";
			s = c.createStatement();
			r = s.executeQuery(sql);
			while (r.next()) {
				Note p = new Note(r.getString("MATIERE"), r.getInt("NOTE"),
						r.getInt("COEFFICIENT"));
				listePersonnesRetour.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (r != null)
					r.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (s != null)
					s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listePersonnesRetour;
	}

	static public int calculMoyennePonderee() {
		List<Note> toutesLesNotes = getListeComplete();
		int sommeProduits = 0, sommeCoef = 0;
		for (Note p : toutesLesNotes) {
			sommeProduits += p.getNote() * p.getCoefficient();
			sommeCoef += p.getCoefficient();
		}
		return (sommeProduits / sommeCoef);
	}

	static public int calculMoyenneSimple() {
		List<Note> toutesLesNotes = getListeComplete();
		int sommeNotes = 0;
		for (Note p : toutesLesNotes) {
			sommeNotes += p.getNote();
		}
		return (sommeNotes / toutesLesNotes.size());
	}
}
