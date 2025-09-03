package demo1heritage.domaine;

abstract public class TrajetType {
   private String depart;
   private String arrivee;
   private int distance;// en kms

   public TrajetType(String depart, String arrivee, int distance) {
      super();
      this.depart = depart;
      this.arrivee = arrivee;
      this.distance = distance;
   }

   public abstract int calculCout();

   public String getDepart() {
      return depart;
   }

   public String getArrivee() {
      return arrivee;
   }

   public int getDistance() {
      return distance;
   }

}
