package tp.enumeration.couche_service;

import java.sql.SQLException;
import java.util.List;

import tp.enumeration.couche_data.Note;
import tp.enumeration.couche_persistance.Connexion;
import tp.enumeration.couche_persistance.INoteDao;
import tp.enumeration.couche_persistance.NoteDao;

public class NoteService {
   private INoteDao noteDao = new NoteDao(); 
   
   public INoteDao getNoteDao() {
      return noteDao;
   }
   public void setNoteDao(INoteDao noteDao) {
      this.noteDao = noteDao;
   }

   public List<Note> getListeComplete() throws ClassNotFoundException, SQLException {
      return noteDao.getListeComplete();
   }

   public int calculMoyennePonderee() throws ClassNotFoundException, SQLException {
      List<Note> toutesLesNotes = noteDao.getListeComplete();
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

   public int calculMoyenneSimple() throws ClassNotFoundException, SQLException {
      List<Note> toutesLesNotes = noteDao.getListeComplete();
      int sommeNotes = 0;
      for (Note p : toutesLesNotes) {
         sommeNotes += p.getNote();
      }
      return (sommeNotes
         / toutesLesNotes.size());
   }

   public void enregistrerNote(Note n) throws ClassNotFoundException, SQLException {
      noteDao.enregistrerNote(n);
   }

   public int initBDD() throws ClassNotFoundException, SQLException {
      return noteDao.initBDD();
   }

   public void close() throws SQLException {
      Connexion.close();
   }

}
