package tp.interfaces.couche_service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tp.interfaces.couche_data.Note;
import tp.interfaces.couche_persistance.INoteDao;

public class NoteServiceTest {

   @Test
   public void getListeComplete_CN() throws ClassNotFoundException, SQLException {
      NoteService ns = new NoteService();
      INoteDao noteDao = new NoteDaoMock();
      // Affecter le DAO de Mock
      ns.setNoteDao(noteDao);
      // Constituer le JdD
      noteDao.enregistrerNote(new Note("Maths", 12, 1));
      noteDao.enregistrerNote(new Note("Maths", 14, 1));
      
      List<Note> listNote = ns.getListeComplete();
      
      // V�rifier
      Assert.assertEquals(listNote.size(), 2);
   }

}
