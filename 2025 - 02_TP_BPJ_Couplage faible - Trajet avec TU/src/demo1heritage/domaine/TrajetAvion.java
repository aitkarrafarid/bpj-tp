package demo1heritage.domaine;

public class TrajetAvion extends TrajetType {

   private static final int COEFF_COUT = 100;
   
   public TrajetAvion(String depart, String arrivee, int distance) {
      super(depart, arrivee, distance);
   }

   @Override
   public int calculCout() {
      // on peut imaginer plus compliqué bien sur !
      return getDistance() * COEFF_COUT;
   }

}
