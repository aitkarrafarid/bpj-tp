package td.decoupage.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import td.decoupage.metier.Personne;

public class PersonneDao extends AbstractDao {

   public void enregistrerPersonneEnBdD(Personne p) throws ClassNotFoundException, SQLException {
      PreparedStatement ps = null;
      Connection c = getConnexion();
      // creation en BDD d'une nouvelle personne
      String sql = "insert into PERSONNE (NOM,PRENOM,AGE) values (?,?,?)";
      ps = c.prepareStatement(sql);
      ps.setString(1, p.getNom());
      ps.setString(2, p.getPrenom());
      ps.setInt(3, p.getAge());
      ps.executeUpdate();
      ps.close();
   }

   public int getNbPersonnesEnBdD() throws SQLException, ClassNotFoundException {
      int retour;
      Statement ps = null;
      // chargement Driver
      Connection c = getConnexion();
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

   public List<Personne> getListeComplete() throws ClassNotFoundException, SQLException {
      List<Personne> listePersonnesRetour = new ArrayList<Personne>();
      Statement s = null;
      ResultSet r = null;
      Connection c = getConnexion();
      // création de la requete
      String sql = "select NOM,PRENOM,AGE from PERSONNE";
      s = c.createStatement();
      r = s.executeQuery(sql);
      while (r.next()) {
         Personne p = new Personne(r.getString("NOM"), r.getString("PRENOM"), r.getInt("AGE"));
         listePersonnesRetour.add(p);
      }
      r.close();
      s.close();
      return listePersonnesRetour;
   }

   public List<Personne> recherchePersonneSelonPrenom(String prenom) throws ClassNotFoundException, SQLException {
      List<Personne> listePersonnesRetour = new ArrayList<Personne>();
      PreparedStatement ps = null;
      ResultSet r = null;
      Connection c = getConnexion();
      // recherche de toutes les personnes de meme prenom (en parametre)
      String sql = "select NOM,PRENOM,AGE from PERSONNE where PRENOM=?";
      ps = c.prepareStatement(sql);
      ps.setString(1, prenom);
      r = ps.executeQuery();
      while (r.next()) {
         Personne p = new Personne(r.getString("NOM"), r.getString("PRENOM"), r.getInt("AGE"));
         listePersonnesRetour.add(p);
      }
      r.close();
      ps.close();
      return listePersonnesRetour;
   }
}
