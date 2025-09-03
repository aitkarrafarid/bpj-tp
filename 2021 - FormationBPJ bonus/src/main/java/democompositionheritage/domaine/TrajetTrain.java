package democompositionheritage.domaine;

public class TrajetTrain extends TrajetType {

   static final int COEFF_COUT = 10;

   @Override
   public int calculCout () {
      // on peut imaginer plus compliqu� bien sur !
      return this.distance * COEFF_COUT;
   }

}
