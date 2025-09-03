package demo.demeter;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Commune implements Cloneable {
   private static final Logger logger = Logger.getLogger(Commune.class);
   private CommuneId compositeId;
   private Departement departement;
   private String nom;
   private int nbResPrincipales;
   private int nbResSecondaires;
   private int nbLogOccasionnels;
   private int nbLogVacants;
   private int popLegale;
   private Integer nbLogPrevu;
   private Integer nbLogCharge;

   // TODO demo DEMETER
   public String toString () {
      return this.departement.getRegionGeo().getNom() + this.depCom() + " ("
            + this.nbResPrincipales + " r�s. princ.)";
   }

   public Commune() {
   }

   public Commune(CommuneId compositeId) {
      this.compositeId = compositeId;
   }

   public CommuneId getCompositeId () {
      return compositeId;
   }

   public void setCompositeId (CommuneId compositeId) {
      this.compositeId = compositeId;
   }

   public String getNom () {
      return nom;
   }

   public void setNom (String nom) {
      this.nom = nom;
   }

   public Departement getDepartement () {
      return departement;
   }

   public void setDepartement (Departement departement) {
      this.departement = departement;
   }

   public String depCom () {
      return (this.compositeId.getDepartementId() + this.compositeId
            .getCodeCommune());
   }

   public int getNbLogOccasionnels () {
      return nbLogOccasionnels;
   }

   public void setNbLogOccasionnels (int nbLogOccasionnels) {
      this.nbLogOccasionnels = nbLogOccasionnels;
   }

   public int getNbLogVacants () {
      return nbLogVacants;
   }

   public void setNbLogVacants (int nbLogVacants) {
      this.nbLogVacants = nbLogVacants;
   }

   public int getNbResPrincipales () {
      return nbResPrincipales;
   }

   public void setNbResPrincipales (int nbResPrincipales) {
      this.nbResPrincipales = nbResPrincipales;
   }

   public int getNbResSecondaires () {
      return nbResSecondaires;
   }

   public void setNbResSecondaires (int nbResSecondaires) {
      this.nbResSecondaires = nbResSecondaires;
   }

   public int getPopLegale () {
      return popLegale;
   }

   public void setPopLegale (int popLegale) {
      this.popLegale = popLegale;
   }

   public Integer getNbLogCharge () {
      return nbLogCharge;
   }

   public void setNbLogCharge (Integer nbLogCharge) {
      this.nbLogCharge = nbLogCharge;
   }

   public Integer getNbLogPrevu () {
      return nbLogPrevu;
   }

   public void setNbLogPrevu (Integer nbLogPrevu) {
      this.nbLogPrevu = nbLogPrevu;
   }

   public static boolean isValid (String valeur) {
      return Pattern.matches("\\A[0-9]{3}\\z", valeur);
   }

   public static final String descriptionIsValid () {
      return "doit comporter exactement 3 chiffres";
   }

   public Commune clone () {
      Commune comClone = null;
      try {
         comClone = (Commune) super.clone();
         comClone.setCompositeId(this.getCompositeId().clone());
      }
      catch (CloneNotSupportedException e) {
         logger.error("Probl�me au clonage de la commune "
               + this.getCompositeId().getDepartementId()
               + this.getCompositeId().getCodeCommune());
      }
      return comClone;
   }

   public String getcodePetiteGrande () {
      return null;
   }

   /**
    * Coefficient correctif pour d�faut de collecte, � appliquer � une proba
    * d'inclusion (et non � un poids).
    * 
    * @return le correctif de collecte s'il y a un d�faut de collecte, 1 sinon.
    */
   public double donneCorrectifCollectePi () {
      // si aucun correctif renseign�, le coeff vaut 1.
      // un contr�le est d�j� fait � la saisie pour que les �l�ments de
      // correctif
      // nbLogPrevu et nbLogCharge soient tous les deux sup�rieurs strict. � 0
      // si un correctif doit �tre appliqu�.
      if (nbLogPrevu == null || nbLogPrevu == 0) {
         if (logger.isTraceEnabled()) {
            logger.trace("--Pas de d�faut de collecte pour "
                  + this.toString());
         }
         return 1;
      }
      else {
         double correctif = (double) nbLogCharge / nbLogPrevu;
         if (logger.isTraceEnabled()) {
            logger.trace("--Correctif d�faut de collecte "
                  + this.toString() + " = " + nbLogCharge + " / "
                  + nbLogPrevu + " = " + correctif);
         }
         return correctif;
      }
   }

   public String getCorrectifCollecteFormat () {
      DecimalFormat df = new DecimalFormat("###.###");
      return df.format(donneCorrectifCollectePi());
   }

}
