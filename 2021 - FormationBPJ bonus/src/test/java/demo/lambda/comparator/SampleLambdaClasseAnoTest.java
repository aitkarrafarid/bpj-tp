package demo.lambda.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import demo.lambda.comparator.data.Personne;
import socle.cours.IllustrationCoursAbstract;

// Pour réaliser lambda expression avec un thread, on peut :
//                                 Avec Lambda Sans Lambda
// - En cas d’erreur c’est parlant +++         +++
// - Le code est lisible           +++         +++
// - On peut utiliser le debugger  +++         +++
public class SampleLambdaClasseAnoTest extends SampleLambdaAbstract {

   public SampleLambdaClasseAnoTest() {
      super(SampleLambdaClasseAnoTest.class.getName());
   }

   @Test
   public void avecLambda () {
      // Given
      startChrono("avecLambda");
      Runnable thread = () -> {
         // Le traitement
         System.out.println("Le traitement du thread terminé");
      };
      new Thread(thread).start();
      stopChrono();
   }

   @Test
   public void avecLambda_CE () {
      // Given
      startChrono("avecLambda_CE");
      Runnable thread = () -> {
         // Le traitement
         String npe = null;
         npe.toString();
         System.out.println("Le traitement du thread terminé");
      };
      new Thread(thread).start();
      stopChrono();
   }
   
   @Test
   public void sansLambda () {
      // Given
      startChrono("sansLambda");
      Runnable thread = new Runnable() {
         @Override
         public void run () {
            // Le traitement
            System.out.println("Le traitement du thread terminé");
         }
      };
      new Thread(thread).start();
      stopChrono();
   }
   
   @Test
   public void sansLambda_CE () {
      // Given
      startChrono("sansLambda_CE");
      Runnable thread = new Runnable() {
         @Override
         public void run () {
            // Le traitement
            String npe = null;
            npe.toString();
            System.out.println("Le traitement du thread terminé");
         }
      };
      new Thread(thread).start();
      stopChrono();
   }

}
