package tp.interfaces.couche_persistance;

import java.sql.SQLException;
import java.util.List;

import tp.interfaces.couche_data.Note;

public interface INoteDao {
   /**
    * Initialiser la BdD.
    * 
    * @return Non géré pour l'instant.
    * @throws ClassNotFoundException
    */
   abstract public int initBDD() throws ClassNotFoundException, SQLException;

   /**
    * Enregistrer une note.
    * 
    * @param n La note à ajouter dans la table.
    * @throws ClassNotFoundException
    * @throws SQLException
    */
   abstract public void enregistrerNote(Note n) throws ClassNotFoundException, SQLException;

   /**
    * Obtenir la liste de toutes notes.
    * 
    * @return La liste de toutes les notes.
    * @throws ClassNotFoundException
    * @throws SQLException
    */
   abstract public List<Note> getListeComplete() throws ClassNotFoundException, SQLException;
}
