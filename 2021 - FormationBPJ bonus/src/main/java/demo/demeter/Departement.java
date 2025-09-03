// Source file: D:\\mavenOcto\\octopusse-core\\src\\main\\java\\fr\\insee\\octopusse\\domaine\\basesondage\\reference\\Departement.java
package demo.demeter;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Departement {
   private String code;

   private String nom;

   private Region regionGeo;

   private Region regionGestion;

   private Set<Commune> lesCommunes = new HashSet<Commune>();

   public Departement() {
   }

   public Departement(String code, String nom, Region regionAdmin) {
      this.code = code;
      this.nom = nom;
      this.regionGeo = regionAdmin;
   }

   public String getCode () {
      return code;
   }

   public void setCode (String code) {
      this.code = code;
   }

   public Set<Commune> getLesCommunes () {
      return lesCommunes;
   }

   public void setLesCommunes (Set<Commune> lesCommunes) {
      this.lesCommunes = lesCommunes;
   }

   public String getNom () {
      return nom;
   }

   public void setNom (String nom) {
      this.nom = nom;
   }

   public Region getRegionGeo () {
      return regionGeo;
   }

   public String getNomRegionGeo () {
      return regionGeo.getNom();
   }

   public void setRegionGeo (Region regionGeo) {
      this.regionGeo = regionGeo;
   }

   public Region getRegionGestion () {
      return regionGestion;
   }

   public void setRegionGestion (Region regionGestion) {
      this.regionGestion = regionGestion;
   }

   public static boolean isValid (String valeur) {
      boolean a = Pattern.matches("\\A[0-9]{2}\\z", valeur);
      boolean b = Pattern.matches("\\A(2A)|(2B){1}\\z", valeur);
      boolean c = Pattern
            .matches("\\A(00)|(96)|(97)|(98)|(99){1}\\z", valeur);
      if ((a == false && b == false) || c == true) {
         return false;
      }
      else
         return true;
   }

   public static final String descriptionIsValid () {
      return "doit prendre ses valeurs dans 01 � 95 (hors DOM) ou 2A ou 2B (Corse)";
   }
}
