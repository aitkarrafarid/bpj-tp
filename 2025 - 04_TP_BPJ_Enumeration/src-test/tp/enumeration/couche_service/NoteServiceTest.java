package tp.enumeration.couche_service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import tp.enumeration.couche_data.Note;
import tp.enumeration.couche_persistance.INoteDao;
import tp.enumeration.couche_service.NoteService;

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
      
      // Vérifier
      Assert.assertEquals(listNote.size(), 2);
   }

}
