package demo2composition.domaine;

public class Trajet {
   private String depart;
   private String arrivee;
   protected int distance;// en kms

   // c'est ici que l'on compose
   private IModeDeTransport modeDeTransport;

   // il faut un constructeur avec comme argument (au moins) le mode de
   // transport

   public Trajet(String depart, String arrivee, int distance, IModeDeTransport modeDeTransport) {
      super();
      this.depart = depart;
      this.arrivee = arrivee;
      this.distance = distance;
      this.modeDeTransport = modeDeTransport;
   }

   public String getDepart() {
      return depart;
   }

   public void setDepart(String depart) {
      this.depart = depart;
   }

   public String getArrivee() {
      return arrivee;
   }

   public void setArrivee(String arrivee) {
      this.arrivee = arrivee;
   }

   public int getDistance() {
      return distance;
   }

   public void setDistance(int distance) {
      this.distance = distance;
   }

   public IModeDeTransport getModeDeTransport() {
      return modeDeTransport;
   }

   public void setModeDeTransport(IModeDeTransport modeDeTransport) {
      this.modeDeTransport = modeDeTransport;
   }

   public int getCout() {
      return modeDeTransport.calculCout(distance);
   }
}
