package td.decoupage._non_decoupe;

import java.sql.SQLException;

public interface INoteIhm {

   /**
    * Cr�ation d'une note.
    * 
    * @return La note saisie.
    */
   abstract public Note creerNote() throws SQLException;

   /**
    * Fermer le flux de saisie.
    */
   abstract public void close() throws SQLException;
}
