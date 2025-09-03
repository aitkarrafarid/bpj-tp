package tpcorrection.douzeerreurs; // 1 : Pas de "_" sur les package

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Personne implements DonneAge { // 2 : Interface commence par une majuscule
   private static final int AGE_MINEUR = 18; // 3 : Constante en majuscule
   // 4 : Constante en static
   private String nom; // nom de la personne
   private int anneeNaissance; // 5 : Attribut commence par minuscule

   public int donneAgeAujourdui() {
      GregorianCalendar calendar = new GregorianCalendar(); // 6 : Pr�fixe "java.util." enl�ve de la lisibilit�, et il y a l'import 
      calendar.setTime(new Date());
      return donneAge(calendar.get(Calendar.YEAR));
   }

   protected int donneAge(int anneeReference) { // 7 : M�thode commence par une minuscule
      return (anneeReference
         - anneeNaissance);
   }

   public boolean isMin() { // 8 : Trop court, plut�t "isMineur()"
      if ((this.donneAgeAujourdui() < AGE_MINEUR)) // 9 : Pas d'accolade
         return true;
      // 10 : Pas de else 
      return false;
   }

   public Personne(String nom, int anneeNaissance) {
      super();
      this.nom = nom;
      this.anneeNaissance = anneeNaissance; // 11 : 2 instructions sur la m�me ligne
   }

   public String getNom(String nom) {
      return this.nom; // 12 : retourner l'attribut "this.nom" au lieu du param�tre 
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

}
