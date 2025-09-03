package demo2composition.domaine;

public class ModeAvion implements IModeDeTransport {
   static final int COEFF_COUT = 100;

   public int calculCout(int distance) {
      // TODO Auto-generated method stub
      return COEFF_COUT * distance;
   }

}
