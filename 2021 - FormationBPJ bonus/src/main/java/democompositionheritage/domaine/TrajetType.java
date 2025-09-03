package democompositionheritage.domaine;

public abstract class TrajetType {
   private String depart;
   private String arrivee;
   protected int distance;// en kms

   public abstract int calculCout ();

   public String getDepart () {
      return depart;
   }

   public String getArrivee () {
      return arrivee;
   }

   public int getDistance () {
      return distance;
   }

}
