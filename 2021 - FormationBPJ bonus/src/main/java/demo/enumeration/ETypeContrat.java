package demo.enumeration;

public enum ETypeContrat {

   CONTRAT_ENCOURS(1, "en cours"),
   CONTRAT_VALIDE(2, "valide"),
   CONTRAT_CLOTURE(3, "clotur�");

   private int code;
   private String libelle;

   ETypeContrat(int code, String libelle) {
      this.code = code;
      this.libelle = libelle;
   }

   public int getCode () {
      return code;
   }

   public void setCode (int code) {
      this.code = code;
   }

   public String getLibelle () {
      return libelle;
   }

   public void setLibelle (String libelle) {
      this.libelle = libelle;
   }
}
