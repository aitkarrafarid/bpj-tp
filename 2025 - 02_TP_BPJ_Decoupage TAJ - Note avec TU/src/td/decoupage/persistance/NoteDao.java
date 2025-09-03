package td.decoupage.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import td.decoupage.metier.Note;

public class NoteDao {
   private Connection _Connexion = Connexion.getConnexion();

   // partie BDD
   public int initBDD() {
      PreparedStatement ps = null;
      // chargement Driver
      try {
         String sql = "create table NOTE (MATIERE char(30), NOTE INTEGER, COEFFICIENT INTEGER );";
         // ,age integer
         ps = _Connexion.prepareStatement(sql);
         int retour = ps.executeUpdate();
         if (retour == 0) {
            return 0;
         }
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
      finally {
         try {
            if (ps != null)
               ps.close();
         }
         catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return -1;
   }

   public void enregistrerNote(Note n) {
      PreparedStatement ps = null;
      try {
         // creation en BDD d'une nouvelle note
         String sql = "insert into NOTE (MATIERE,NOTE,COEFFICIENT) values (?,?,?)";
         ps = _Connexion.prepareStatement(sql);
         ps.setString(1, n.getMatiere());
         ps.setInt(2, n.getNote());
         ps.setInt(3, n.getCoefficient());
         ps.executeUpdate();
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
      finally {
         try {
            if (ps != null)
               ps.close();
         }
         catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   public List<Note> getListeComplete() throws SQLException {
      List<Note> listePersonnesRetour = new ArrayList<Note>();
      Statement s = null;
      ResultSet r = null;
      try {
         // creation de la requete
         String sql = "select MATIERE,NOTE,COEFFICIENT from NOTE";
         s = _Connexion.createStatement();
         r = s.executeQuery(sql);
         while (r.next()) {
            Note p = new Note(r.getString("MATIERE"), r.getInt("NOTE"), r.getInt("COEFFICIENT"));
            listePersonnesRetour.add(p);
         }
      }
      finally {
         if (r != null)
            r.close();
         if (s != null)
            s.close();
      }
      return listePersonnesRetour;
   }

   public void close() throws SQLException {
      _Connexion.close();
   }

}
