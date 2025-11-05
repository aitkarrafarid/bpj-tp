package tp.decoupage.couche_service;

import tp.decoupage.couche_data.Note;
import tp.decoupage.couche_persistance.NoteDao;

import java.util.List;

public class NoteService {

    private NoteDao noteDao = new NoteDao();

    public void initBDD(){
        noteDao.initBDD();
    }

    public List<Note> getListeComplete() {
        return noteDao.getListeComplete();
    }

    public void enregistrerNote(Note n) {
        noteDao.enregistrerNote(n);
    }

    public int calculMoyennePonderee() {
        List<Note> toutesLesNotes = this.getListeComplete();
        int sommeProduits = 0, sommeCoef = 0;
        for (Note p : toutesLesNotes) {
            sommeProduits += p.getNote() * p.getCoefficient();
            sommeCoef += p.getCoefficient();
        }
        return (sommeProduits / sommeCoef);
    }

    public int calculMoyenneSimple() {
		List<Note> toutesLesNotes = this.getListeComplete();
		int sommeNotes = 0;
		for (Note p : toutesLesNotes) {
			sommeNotes += p.getNote();
		}
		return (sommeNotes / toutesLesNotes.size());
    }
}
