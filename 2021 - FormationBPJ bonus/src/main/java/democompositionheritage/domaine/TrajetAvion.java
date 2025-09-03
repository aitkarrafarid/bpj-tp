package democompositionheritage.domaine;

public class TrajetAvion extends TrajetType {

   static final int COEFF_COUT = 100;

   @Override
   public int calculCout () {
      // on peut imaginer plus compliqu� bien sur !
      return this.distance * COEFF_COUT;
   }

}
