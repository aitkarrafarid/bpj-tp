package demo1heritage.domaine;

public class TrajetTrain extends TrajetType {

   private static final int COEFF_COUT = 10;
   
   public TrajetTrain(String depart, String arrivee, int distance) {
      super(depart, arrivee, distance);
   }

   @Override
   public int calculCout() {
      // on peut imaginer plus compliqué bien sur !
      return getDistance() * COEFF_COUT;
   }

}
