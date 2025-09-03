package tp.refactoring.ended;

public class Calcul {

   public static void main(String[] args) {
      int surface = calculeSurface();
//      volume =
//         largeur
//            * longueur
//            * hauteur;
      System.out.println(
         "la surface vaut "
            + surface);
//      System.out.println(
//         "le volume vaut "
//            + volume);

   }

   private static int calculeSurface() {
      int largeur = 10, longueur = 30, hauteur = 5;
      int surface, volume;
      surface =
         largeur
            * longueur;
      return surface;
   }

}
