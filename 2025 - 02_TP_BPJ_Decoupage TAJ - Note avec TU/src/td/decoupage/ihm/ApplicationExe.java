package td.decoupage.ihm;

import td.decoupage.metier.Note;
import td.decoupage.service.NoteService;

public class ApplicationExe {
   public static void main(String[] args) {
      int choix = 0;

      try {
         NoteIhm app = new NoteIhm();
         app.doMenu();
      }
      catch (Exception e) {
         // TODO Passer par un logger
         e.printStackTrace();
      }
   }

}
