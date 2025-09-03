package tp.pmd;

public class Vecteur {

   double x, y;

   Vecteur(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public double norme () {
      return Math.sqrt(this.x * this.x + this.y * this.y);
   }

}
