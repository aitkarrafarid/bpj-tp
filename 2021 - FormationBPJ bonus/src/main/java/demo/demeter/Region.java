package demo.demeter;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Region {
   private String code;
   private String nom;
   private Set<Departement> lesDept = new HashSet<Departement>();

   public Region(String codeRegion) {
      this.code = codeRegion;
   }

   public Region() {
   }

   public String getCode () {
      return code;
   }

   public void setCode (String code) {
      this.code = code;
   }

   public Set<Departement> getLesDept () {
      return lesDept;
   }

   public void setLesDept (Set<Departement> lesDept) {
      this.lesDept = lesDept;
   }

   public String getNom () {
      return nom;
   }

   public void setNom (String nom) {
      this.nom = nom;
   }

   public Region(String code, String nom) {
      this.code = code;
      this.nom = nom;
   }

   public static boolean isValid (String valeur) {
      return Pattern.matches("\\A[0-9]{2}\\z", valeur);
   }

   public static final String descriptionIsValid () {
      return "doit prendre ses valeurs parmi 2 chiffres";
   }
}
