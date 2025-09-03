package demo.singleton;

public class SampleSingleton {
   /** Instance du Singleton */
   private static final SampleSingleton instance = new SampleSingleton();

   private SampleSingleton() {
      super();
   }

   /**
    * Obtenir l'instance du Singleton.
    * @return L'instance.
    */
   public static SampleSingleton getInstance () {
      return instance;
   }

   public void methode1 () {
      System.out.println("methode1");
   }
}
