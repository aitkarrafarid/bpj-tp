package tp.decoupage.service;

import java.util.List;

import tp.decoupage.dao.Connexion;
import tp.decoupage.dao.NoteDao;
import tp.decoupage.domaine.Note;

public class NoteService {

   NoteDao nDao = new NoteDao();

   public int initBDD () {
      return nDao.initBDD();
   }

   public void closeConnexion () {
      Connexion.close();
   }

   public void enregistrerNote (Note n) {
      nDao.enregistrerNote(n);
   }

   public List<Note> getListeComplete () {
      return nDao.getListeComplete();
   }

   public int calculMoyennePonderee () {
      List<Note> toutesLesNotes = nDao.getListeComplete();
      int sommeProduits = 0, sommeCoef = 0;
      for (Note p : toutesLesNotes) {
         sommeProduits += p.getNote() * p.getCoefficient();
         sommeCoef += p.getCoefficient();
      }
      return (sommeProduits / sommeCoef);
   }

   public int calculMoyenneSimple () {
      List<Note> toutesLesNotes = nDao.getListeComplete();
      int sommeNotes = 0;
      for (Note p : toutesLesNotes) {
         sommeNotes += p.getNote();
      }
      return (sommeNotes / toutesLesNotes.size());
   }

}
