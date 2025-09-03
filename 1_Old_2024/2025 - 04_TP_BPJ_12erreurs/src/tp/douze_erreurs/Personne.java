package tp.douze_erreurs;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Personne implements donneAge {
   private final int ageMineur = 18;

   private String nom; // nom de la personne
   private int AnneeNaissance;

   public int donneAgeAujourdui() {
      GregorianCalendar calendar = new java.util.GregorianCalendar();
      calendar.setTime(new Date());
      return DonneAge(calendar.get(Calendar.YEAR));
   }

   protected int DonneAge(int anneeReference) {
      return (anneeReference
         - AnneeNaissance);
   }

   public boolean isMin() {
      if ((this.donneAgeAujourdui() < ageMineur))
         return true;
      return false;
   }

   public Personne(String nom, int anneeNaissance) {
      super();
      this.nom = nom;
      this.AnneeNaissance = anneeNaissance;
   }

   public String getNom(String nom) {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

}
