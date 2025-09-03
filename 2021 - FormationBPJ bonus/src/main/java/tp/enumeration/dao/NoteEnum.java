package tp.enumeration.dao;

public enum NoteEnum {
   MATIERE("MATIERE", 1),
   NOTE("NOTE", 2),
   COEFFICIENT("COEFFICIENT", 3);

   public static final String NOM_TABLE_NOTE = "NOTE";

   public final String nomColonne;
   public final int rangColonne;

   private NoteEnum(String nomColonne, int rangColonne) {
      this.nomColonne = nomColonne;
      this.rangColonne = rangColonne;
   }

}
