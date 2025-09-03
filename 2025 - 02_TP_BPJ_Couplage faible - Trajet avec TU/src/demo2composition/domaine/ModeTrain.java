package demo2composition.domaine;

public class ModeTrain implements IModeDeTransport {
   static final int COEFF_COUT = 10;

   public int calculCout(int distance) {
      // on peut imaginer plus compliqué bien sur !
      return COEFF_COUT * distance;
   }

}
