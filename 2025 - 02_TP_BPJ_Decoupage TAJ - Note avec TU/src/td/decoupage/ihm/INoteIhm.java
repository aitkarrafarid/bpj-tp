package td.decoupage.ihm;

import java.sql.SQLException;

import td.decoupage.metier.Note;

public interface INoteIhm {

   /**
    * Cr�ation d'une note.
    * 
    * @return La note saisie.
    */
   abstract public Note creerNote();

   /**
    * Fermer le flux de saisie.
    */
   abstract public void close() throws SQLException;
}
