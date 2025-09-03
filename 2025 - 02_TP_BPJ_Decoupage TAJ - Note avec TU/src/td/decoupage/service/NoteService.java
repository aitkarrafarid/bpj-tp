package td.decoupage.service;

import java.sql.SQLException;
import java.util.List;

import td.decoupage.metier.Note;
import td.decoupage.persistance.NoteDao;

public class NoteService {
   private NoteDao _NoteDao = new NoteDao();

   public int calculMoyennePonderee() throws Exception {
      List<Note> toutesLesNotes = getListeComplete();
      int sommeProduits = 0, sommeCoef = 0;
      for (Note p : toutesLesNotes) {
         sommeProduits +=
            p.getNote()
               * p.getCoefficient();
         sommeCoef += p.getCoefficient();
      }
      return (sommeProduits
         / sommeCoef);
   }

   public int calculMoyenneSimple() {
      List<Note> toutesLesNotes = getListeComplete();
      int sommeNotes = 0;
      for (Note p : toutesLesNotes) {
         sommeNotes += p.getNote();
      }
      return (sommeNotes
         / toutesLesNotes.size());
   }
   
   public List<Note> getListeComplete () {
      List<Note> toutesLesNotes = null;
      try {
         toutesLesNotes = _NoteDao.getListeComplete();
      }
      catch (Exception e) {
         throw new RuntimeException("Problème dans getListeComplete()", e);
      }

      return toutesLesNotes;
   }

   public void enregistrerNote(Note n) {
      _NoteDao.enregistrerNote(n);
   }

   public int initBDD() {
      return _NoteDao.initBDD();
   }

   public void close() throws Exception {
      _NoteDao.close();
   }
}
