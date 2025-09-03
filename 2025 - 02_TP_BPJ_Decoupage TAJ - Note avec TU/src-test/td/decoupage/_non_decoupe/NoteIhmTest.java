package td.decoupage._non_decoupe;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import td.decoupage._non_decoupe.Application;
import td.decoupage._non_decoupe.INoteIhm;
import td.decoupage._non_decoupe.Note;

public class NoteIhmTest {
   Application _NoteService = new Application();

   @Before
   public void setup() {
      _NoteService.initBDD();
   }

   @After
   public void tearDown() throws Exception {
      _NoteService.close();
   }

   @Test
   public void saisirNotesPonderee_CN() throws Exception {
      // Given
      INoteIhm noteIhm = NoteIhmMock.getInstance(NoteIhmMock.DATA_TEST_saisirNotesPonderee_CN);
      Note note;
      // Simuler la saisie des notes
      while ((note = noteIhm.creerNote()) != null) {
         _NoteService.enregistrerNote(note);
      }
      ;

      // When
      int moyPonderee = _NoteService.calculMoyennePonderee();

      // Then
      Assert.assertTrue(moyPonderee == 11);
   }
}
