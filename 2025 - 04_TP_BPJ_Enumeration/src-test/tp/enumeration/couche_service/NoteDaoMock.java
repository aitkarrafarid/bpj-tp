package tp.enumeration.couche_service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tp.enumeration.couche_data.Note;
import tp.enumeration.couche_persistance.INoteDao;

public class NoteDaoMock implements INoteDao {
   private List<Note> listNote = new ArrayList<>();

   @Override
   public int initBDD() throws ClassNotFoundException, SQLException {
      throw new UnsupportedOperationException("Non implémentée pour l'instant");
   }

   @Override
   public void enregistrerNote(Note n) throws ClassNotFoundException, SQLException {
      listNote.add(n);
   }

   @Override
   public List<Note> getListeComplete() throws ClassNotFoundException, SQLException {
      return listNote;
   }

}
