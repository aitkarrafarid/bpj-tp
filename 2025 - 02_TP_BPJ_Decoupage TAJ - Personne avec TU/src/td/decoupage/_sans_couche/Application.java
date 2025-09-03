package td.decoupage._sans_couche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application implements IPersonneIhm {
   private static Application application = new Application();

   private static Scanner scanner = new Scanner(System.in);

   @Override
   public Personne obtenirPersonneSaisie() {
      System.out.println("--- Saisie d'une nouvelle personne ---");
      System.out.println("Entrer le nom (ou \"FIN\" pour sortir) : ");
      String nom = scanner.next();
      if ("FIN".equalsIgnoreCase(nom)) {
         return null;
      }
      else {
         System.out.println("Entrer le prenom : ");
         String prenom = scanner.next();
         System.out.println("Entrer l'age : ");
         int age = scanner.nextInt();
         return new Personne(nom, prenom, age);
      }
   }

   @Override
   public void closeIhm() throws Exception {
      scanner.close();
      MaConnexion.close();
   }

   public static int choixMenu() {
      System.out.println("--- Menu General ---");
      System.out.println("1. Afficher l'annuaire complet");
      System.out.println("2. Saisie d'une nouvelle personne");
      System.out.println("3. Rechercher les personnes de prenom...");
      System.out.println("4. Quitter");
      int retour = scanner.nextInt();
      if (retour < 0
         || retour > 4) {
         System.out.println("Erreur de saisie");
         return -1;
      }
      return retour;
   }

   public static String saisieChaine() {
      return scanner.next();
   }

   public static void main(String[] args) {
      try {
         int choix = 0;
         // init BDD
         System.out.println(
            "initialisation de la structure de la BDD :  code retour = "
               + application.initBdD());
         do {
            choix = choixMenu();
            switch (choix) {
               case 1:
                  System.out.println("Afficher TOUS !");
                  System.out.println(getListeComplete());
                  break;
               case 2:
                  // Obtenir la personne saisie dans l'IHM
                  Personne p = application.obtenirPersonneSaisie();
                  // Ajouter la personne en BdD
                  application.enregistrerPersonneEnBdD(p);
                  System.out.println(
                     p
                        + "  est enregistree !");
                  break;
               case 3:
                  System.out.println("recherche de personnes :");
                  System.out.println("Saisir le prenom voulu :");
                  String prenom = saisieChaine();
                  int nbPersonneDuPrenom = nbPersonnesNommees(prenom);
                  System.out.println(
                     nbPersonneDuPrenom
                        + " personnes trouvees dont le prenom est "
                        + prenom);

                  break;
               case 4:
                  // Nothing to do
                  break;
               default:
                  System.out.println("Vous devez saisir 1, 2, 3 ou 4 !!!");
                  break;
            }
         } while (choix != 4);
         application.closeIhm();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   // partie base de données
   @Override
   public int initBdD() throws Exception {
      Statement statement = null;
      // chargement Driver
      Connection c = MaConnexion.getConnexion();
      statement = c.createStatement();
      // Effacer la table
      String sql = "drop table PERSONNE;";
      try {
         statement.executeUpdate(sql);
      }
      catch (SQLException e) {
         // RAS : Si la table existe
      }

      // Créer la table
      sql = "create table PERSONNE (NOM char(30), PRENOM char(30), AGE INTEGER );";
      int retour = -1;
      retour = statement.executeUpdate(sql);

      if (retour == 0) {
         return 0;
      }
      c.commit();
      statement.close();
      return -1;
   }

   @Override
   public void enregistrerPersonneEnBdD(Personne p) throws Exception {
      PreparedStatement ps = null;
      Connection c = MaConnexion.getConnexion();
      // creation en BDD d'une nouvelle personne
      String sql = "insert into PERSONNE (NOM,PRENOM,AGE) values (?,?,?)";
      ps = c.prepareStatement(sql);
      ps.setString(1, p.getNom());
      ps.setString(2, p.getPrenom());
      ps.setInt(3, p.getAge());
      ps.executeUpdate();
      ps.close();
   }

   @Override
   public int getNbPersonnesEnBdD() throws Exception {
      int retour;
      Statement ps = null;
      // chargement Driver
      Connection c = MaConnexion.getConnexion();
      String sql = "select count(*) AS nbPers from PERSONNE";
      // ,age integer
      ps = c.createStatement();
      ResultSet rs = ps.executeQuery(sql);
      if (rs.next() == true) {
         retour = rs.getInt("nbPers");
      }
      else {
         retour = -1;
      }
      ps.close();

      return retour;
   }

   @Override
   public List<Personne> getListComplete() throws Exception {
      List<Personne> listePersonnesRetour = new ArrayList<Personne>();
      Statement s = null;
      ResultSet r = null;
      try {
         Connection c = MaConnexion.getConnexion();
         // création de la requete
         String sql = "select NOM,PRENOM,AGE from PERSONNE";
         s = c.createStatement();
         r = s.executeQuery(sql);
         while (r.next()) {
            Personne p = new Personne(r.getString("NOM"), r.getString("PRENOM"), r.getInt("AGE"));
            listePersonnesRetour.add(p);
         }
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
      finally {
         try {
            if (r != null)
               r.close();
         }
         catch (SQLException e) {
            e.printStackTrace();
         }
         try {
            if (s != null)
               s.close();
         }
         catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return listePersonnesRetour;
   }

   public static List<Personne> getListeComplete() throws Exception {
      return application.getListComplete();
   }

   static public List<Personne> recherchePersonneSelonPrenom(String prenom) throws Exception {
      List<Personne> listePersonnesRetour = new ArrayList<Personne>();
      PreparedStatement ps = null;
      ResultSet r = null;
      try {
         Connection c = MaConnexion.getConnexion();
         // recherche de toutes les personnes de meme prenom (en parametre)
         String sql = "select NOM,PRENOM,AGE from PERSONNE where PRENOM=?";
         ps = c.prepareStatement(sql);
         ps.setString(1, prenom);
         r = ps.executeQuery();
         while (r.next()) {
            Personne p = new Personne(r.getString("NOM"), r.getString("PRENOM"), r.getInt("AGE"));
            listePersonnesRetour.add(p);
         }
      }
      finally {
         if (r != null)
            r.close();
         if (ps != null)
            ps.close();
      }
      return listePersonnesRetour;
   }

   static public int nbPersonnesNommees(String prenom) throws Exception {
      List<Personne> personnesDePrenomParam = recherchePersonneSelonPrenom(prenom);
      int nbPersonnesNomRenseigne = 0;
      for (Personne p : personnesDePrenomParam) {
         if (p.getNom() != null) {
            nbPersonnesNomRenseigne++;
         }
      }
      return nbPersonnesNomRenseigne;
   }

}
