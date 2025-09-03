package td.decoupage.ihm;

import td.decoupage.metier.Note;

public class NoteIhmMock implements INoteIhm {
   public static final String DATA_TEST_saisirNotesPonderee_CN = "saisirNotesPonderee_CN";

   private Note[] _tabNote;
   private int _rang = -1;

   public static INoteIhm getInstance(String nomTest) {
      NoteIhmMock retour;

      if (DATA_TEST_saisirNotesPonderee_CN.equals(nomTest)) {
         // Initialiser les données
         retour = new NoteIhmMock();
         retour._tabNote = new Note[] { new Note("Maths", 12, 4), new Note("Fran�ais", 10, 4) };

      }
      else {
         throw new IllegalArgumentException("Cas non pr�vu pour nomTest="
            + nomTest);
      }

      return retour;
   }

   @Override
   public Note creerNote() {
      Note retour;

      if (_rang < _tabNote.length
         - 1) {
         _rang++;
         retour = _tabNote[_rang];
      }
      else {
         retour = null;
      }

      return retour;
   }

   @Override
   public void close() {
      // RAS
   }

}
