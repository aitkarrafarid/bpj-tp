package democompositionheritage.domaine;

public class MainClass {

   public static void main (String[] args) {
      Trajet trajet0 = new Trajet("Paris", "Toulouse", 600, null);
      Trajet trajet1 = new Trajet("Paris", "Toulouse", 600, new ModeAvion());
      Trajet trajet2 = new Trajet("Paris", "Rennes", 350, new ModeTrain());
   }

}
