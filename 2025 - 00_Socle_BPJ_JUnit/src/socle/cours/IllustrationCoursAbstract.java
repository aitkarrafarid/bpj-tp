package socle.cours;

import java.util.List;

import socle.cours.performance.Chrono;

public class IllustrationCoursAbstract {
   protected static final int NB_ITER = 900;
//   protected static final int NB_ITER = 9000000;

   private Chrono _Chrono;
   private String _ChronoNameTrt;
   private String _Name;

   public IllustrationCoursAbstract(String _Name) {
      super();
      this._Name = _Name;
      _Chrono = Chrono.newInstance("Illustration Cours pour " + _Name, System.out, false);
   }

   private IllustrationCoursAbstract() {
      // RAS
   }

   public void startChrono (String chronoName) {
      _ChronoNameTrt = chronoName;
      System.out.println("");
      System.out.println("DEBUT " + _Name + "." + _ChronoNameTrt);
      _Chrono.start();
   }

   public void stopChrono () {
      _Chrono.stop();
      System.out.println("FIN " + _Name + "." + _ChronoNameTrt);
   }

   public void afficher (Object object) {
      System.out.println(object);
   }

   public void afficher (Object[] tabObject) {
      for (Object elem : tabObject) {
         System.out.println(elem);
      }   
   }

   public void afficher (List<?> list) {
      for (Object elem : list) {
         System.out.println(elem);
      }
   }
}
