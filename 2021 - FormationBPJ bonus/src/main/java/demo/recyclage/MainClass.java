package demo.recyclage;

import java.util.Date;

import demo.socle.performance.Chrono;

public class MainClass {

   private static final int NB_ITERATIONS = 100;

   public static void main (String[] args) {
      sampleModificationContenu();
//      // 1er appel ne compte pas
//      demoWithoutRecyclage();
//      demoWithRecyclage();
//
//      System.out.println("---------------------------");
//      // On commence ici
//      demoWithoutRecyclage();
//      demoWithRecyclage();
   }

   private static void demoWithoutRecyclage () {
      Chrono.startChrono("demoWithoutRecyclage", System.out);
      Pers pers;
      for (int i = 0; i < NB_ITERATIONS; i++) {
         // On créé une nouvelle instance à chaque itération
         pers = new Pers("nom" + i, new Date());
         afficherNom(pers.getNom());
      }
      Chrono.stopChrono();
   }

   private static void demoWithRecyclage () {
      Chrono.startChrono("demoWithRecyclage", System.out);
      Pers pers = new Pers();
      for (int i = 0; i < NB_ITERATIONS; i++) {
         // On recycle l'instance
         pers.resetPers("nom" + i, new Date());
         afficherNom(pers.getNom());
      }
      Chrono.stopChrono();
   }

   private static void afficherNom (String pNom) {
      // RAS
   }

   private static void sampleModificationContenu () {
      Pers pers = new Pers("DUPONT", new Date());
      System.out.println("1 - " + pers.getNom());
      modifierNom(pers.getNom());
      System.out.println("2 - " + pers.getNom());
      modifier(pers);
      System.out.println("3 - " + pers.getNom());
   }

   private static void modifierNom (String pNom) {
      pNom = "DUPUIS";
   }

   private static void modifier (Pers pPers) {
      pPers.setNom("DUPUIS");
   }
}

class Pers {
   private String nom;
   private Date naissance;

   public Pers() {
      // RAS
   }

   public Pers(String nom, Date naissance) {
      resetPers(nom, naissance);
   }

   public void resetPers (String nom, Date naissance) {
      setNom(nom);
      setNaissance(naissance);
   }

   public String getNom () {
      return nom;
   }

   public void setNom (String nom) {
      this.nom = nom;
   }

   public Date getNaissance () {
      return naissance;
   }

   public void setNaissance (Date naissance) {
      this.naissance = naissance;
   }

}
