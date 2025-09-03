package tp.enumeration.dao;

import java.util.List;

import tp.decoupage.domaine.Note;

public interface INoteDao {

   // partie BDD
   public int initBDD ();

   public void enregistrerNote (Note n);

   public List<Note> getListeComplete ();

}