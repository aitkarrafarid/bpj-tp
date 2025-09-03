package tp.refactoring._nonrefactore;

public class Calcul {

   public static void main(String[] args) {
      int largeur = 10, longueur = 30, hauteur = 5;
      int surface, volume;
      surface =
         largeur
            * longueur;
      volume =
         largeur
            * longueur
            * hauteur;
      System.out.println(
         "la surface vaut "
            + surface);
      System.out.println(
         "le volume vaut "
            + volume);

   }

}
