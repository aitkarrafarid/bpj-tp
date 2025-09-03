package democompositionheritage.domaine;

public class ModeTrain implements IModeDeTransport {
   static final int COEFF_COUT = 10;

   public int calculCout (int distance) {
      // TODO Auto-generated method stub
      return COEFF_COUT * distance;
   }

}
