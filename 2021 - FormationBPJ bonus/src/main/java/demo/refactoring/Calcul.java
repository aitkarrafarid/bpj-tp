package demo.refactoring;

public class Calcul {

   // TODO demo refactoring 2 : montrer l'impossibilit� d'extraire la m�thode
   // sauf si la derni�re ligne est en commentaire
   /**
    * @param args
    */
   public static void main (String[] args) {
      int largeur = 10, longueur = 30, hauteur = 5;
      int surface, volume;
      surface = largeur * longueur;
      volume = largeur * longueur * hauteur;
      System.out.println("la surface vaut " + surface);
      System.out.println("le volume vaut " + volume);

   }

}
