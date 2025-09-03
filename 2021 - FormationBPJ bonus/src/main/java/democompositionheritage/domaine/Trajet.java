package democompositionheritage.domaine;

public class Trajet {
   private String depart;
   private String arrivee;
   protected int distance;// en kms

   // c'est ici que l'on compose
   private IModeDeTransport modeDeTransport;

   // il faut un constructeur avec comme argument (au moins) le mode de
   // transport

   public Trajet(String depart, String arrivee, int distance,
         IModeDeTransport modeDeTransport) {
      super();
      setDepart(depart);
      setArrivee(arrivee);
      setDistance(distance);
      setModeDeTransport(modeDeTransport);
   }

   public final String getDepart () {
      return depart;
   }

   public final void setDepart (String depart) {
      this.depart = depart;
   }

   public final String getArrivee () {
      return arrivee;
   }

   public final void setArrivee (String arrivee) {
      this.arrivee = arrivee;
   }

   public final int getDistance () {
      return distance;
   }

   public final void setDistance (int distance) {
      this.distance = distance;
   }

   public final IModeDeTransport getModeDeTransport () {
      return modeDeTransport;
   }

   public final void setModeDeTransport (IModeDeTransport modeDeTransport) {
      // Le paramètre 'modeDeTransport' est manquant
      if (null == modeDeTransport) {
         throw new IllegalArgumentException("Le 'modeDeTransport' est obligatoire");
      }

      this.modeDeTransport = modeDeTransport;
   }

   public int getCout () {
      // Polymorphisme
      return modeDeTransport.calculCout(distance);
   }
}
