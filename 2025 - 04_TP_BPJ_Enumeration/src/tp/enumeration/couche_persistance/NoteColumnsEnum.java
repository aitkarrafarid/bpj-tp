package tp.enumeration.couche_persistance;

public enum NoteColumnsEnum {
   matiere("MATIERE", 255),
   note("NOTE", 16),
   coefficient("COEFFICIENT", 8);

   /** Définir le nom de la table en constante. */
   public static final String TABLE_NAME = "NOTE";
   
   private String nom;
   private Integer taille;

   /**
    * Constructeur de l'enum.
    */
   private NoteColumnsEnum(final String nom, final Integer taille) {
      this.nom = nom;
      this.taille = taille;
   }

   public String getNom() {
      return nom;
   }

   public Integer getTaille() {
      return taille;
   }

}
