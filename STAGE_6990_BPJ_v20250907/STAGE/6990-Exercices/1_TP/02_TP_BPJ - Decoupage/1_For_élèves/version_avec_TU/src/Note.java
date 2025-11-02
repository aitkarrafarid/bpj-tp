package td.decoupage._non_decoupe;

public class Note {
   private String matiere;
   private int note;
   private int coefficient;

   public String getMatiere() {
      return matiere;
   }

   public void setMatiere(String matiere) {
      this.matiere = matiere;
   }

   public int getNote() {
      return note;
   }

   public void setNote(int note) {
      this.note = note;
   }

   public int getCoefficient() {
      return coefficient;
   }

   public void setCoefficient(int coefficient) {
      this.coefficient = coefficient;
   }

   @Override
   public String toString() {
      return "Personne [matiere="
         + matiere
         + ", note="
         + note
         + ", coefficient="
         + coefficient
         + "]";
   }

   public Note(String matiere, int note, int coefficient) {
      super();
      this.matiere = matiere;
      this.note = note;
      this.coefficient = coefficient;
   }

}
