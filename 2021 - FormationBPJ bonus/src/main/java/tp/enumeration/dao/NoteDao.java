package tp.enumeration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
// import static tp.enumeration.dao.NoteEnum.*;

import tp.decoupage.domaine.Note;

public class NoteDao implements INoteDao {

   // partie BDD
   /*
    * (non-Javadoc)
    * 
    * @see tp.enumeration.dao.INoteDao#initBDD()
    */
   public int initBDD () {
      PreparedStatement ps = null;
      // chargement Driver
      try {
         Connection c = Connexion.getConnexion();
         String sql = "create table " + NoteEnum.NOM_TABLE_NOTE + " ("
               + NoteEnum.MATIERE.nomColonne + " char(30), " + NoteEnum.NOTE.nomColonne
               + " INTEGER, " + NoteEnum.COEFFICIENT.nomColonne + " INTEGER );";
         // ,age integer
         ps = c.prepareStatement(sql);
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

   /*
    * (non-Javadoc)
    * 
    * @see
    * tp.enumeration.dao.INoteDao#enregistrerNote(tp.decoupage.domaine.Note)
    */
   public void enregistrerNote (Note n) {
      PreparedStatement ps = null;
      try {
         Connection c = Connexion.getConnexion();
         // creation en BDD d'une nouvelle note
         String sql = "insert into " + NoteEnum.NOM_TABLE_NOTE + " ("
               + NoteEnum.MATIERE.nomColonne + "," + NoteEnum.NOTE.nomColonne + ","
               + NoteEnum.COEFFICIENT.nomColonne + ") values (?,?,?)";
         ps = c.prepareStatement(sql);
         ps.setString(NoteEnum.MATIERE.rangColonne, n.getMatiere());
         ps.setInt(NoteEnum.NOTE.rangColonne, n.getNote());
         ps.setInt(NoteEnum.COEFFICIENT.rangColonne, n.getCoefficient());
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

   /*
    * (non-Javadoc)
    * 
    * @see tp.enumeration.dao.INoteDao#getListeComplete()
    */
   public List<Note> getListeComplete () {
      List<Note> listePersonnesRetour = new ArrayList<Note>();
      Statement s = null;
      ResultSet r = null;
      try {
         Connection c = Connexion.getConnexion();
         // creation de la requete
         String sql = "select " + NoteEnum.MATIERE.nomColonne + "," + NoteEnum.NOTE.nomColonne
               + "," + NoteEnum.COEFFICIENT.nomColonne + " from " + NoteEnum.NOM_TABLE_NOTE;
         s = c.createStatement();
         r = s.executeQuery(sql);
         while (r.next()) {
            Note p = new Note(r.getString("MATIERE"), r.getInt("NOTE"),
                  r.getInt("COEFFICIENT"));
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

}
