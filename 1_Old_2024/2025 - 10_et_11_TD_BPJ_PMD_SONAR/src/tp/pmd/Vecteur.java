package tp.pmd;

public class Vecteur {

   double x, y;

   public Vecteur(final double x, final double y) { 
      this.x = x;
      this.y = y;
   }

   public double norme() {
      return Math.sqrt(
         this.x
            * this.x
            + this.y
               * this.y);
   }

}
