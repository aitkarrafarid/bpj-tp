package tp.enumeration.couche_persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tp.enumeration.couche_data.Note;

public class NoteDao implements INoteDao {
   @Override
   public int initBDD() throws ClassNotFoundException, SQLException {
      PreparedStatement ps = null;
      // chargement Driver
      try {
         Connection c = Connexion.getConnexion();
//         String sql = "create table NOTE (MATIERE char(30), NOTE INTEGER, COEFFICIENT INTEGER );";
         String sql =
            "create table " + NoteColumnsEnum.TABLE_NAME + " ("
               + NoteColumnsEnum.matiere.getNom()
               + " char("
               + NoteColumnsEnum.matiere.getTaille()
               + "), "
               + NoteColumnsEnum.note.getNom()
               + " INTEGER, "
               + NoteColumnsEnum.coefficient.getNom()
               + " INTEGER );";

         ps = c.prepareStatement(sql);
         int retour = ps.executeUpdate();
         if (retour == 0) {
            return 0;
         }
      }
      finally {
         if (ps != null)
            ps.close();
      }
      return -1;
   }

   @Override
   public void enregistrerNote(Note n) throws ClassNotFoundException, SQLException {
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
      }
      finally {
         if (ps != null)
            ps.close();
      }
   }

   public List<Note> getListeComplete() throws ClassNotFoundException, SQLException {
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

}
