package demo.lambda.comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import demo.lambda.comparator.data.Personne;

// Les streams permettent une écriture concise qui, quand on a l’habitude paraît plus « sexy », 
// mais https://www.javacodegeeks.com/2014/03/the-dark-side-of-lambda-expressions-in-java-8.html
//                                    Avec Lambda           Sans Lambda 
// - En cas d’erreur c’est parlant    ++                    +++
// - Le code est lisible              +                     +++
// - Usage du debugger                +                     +++
// Risque à ne pas faire : • Difficulté d’évolutivité, car pas de debuggueur
public class SampleLambdaStreamTest extends SampleLambdaAbstract {

   public SampleLambdaStreamTest() {
      super(SampleLambdaStreamTest.class.getName());
   }

   @Test
   public void sansLambda () {
      // Given
      List<Personne> list = initData_listPersonne();
      final int id = 2;
      Personne result = null;

      startChrono("sansLambda");
      for (int i = 0; i < NB_ITER; i++) {
         // Parcourir la liste des entrepots
         for (Personne personne : list) {
            // SI on a trouvé l'élément
            if (personne.getId().equals(id)) {
               result = personne;
               break;
            }
         }
      }
//      afficher(result);
      stopChrono();
   }

   /**
    * Test provoiquant une erreur pour montrer la maintenabilité de la ST. 
    */
   @Test
   public void sansLambda_CE () {
      // Given
      List<Personne> list = initData_listPersonne();
      // Ajouter le tuple pour provoquer l'erreur
      list.add(new Personne(null, null));
      final int id = 9999;
      Personne result = null;

      startChrono("sansLambda_CE");
      for (int i = 0; i < NB_ITER; i++) {
         // Parcourir la liste des entrepots
         for (Personne personne : list) {
            // SI on a trouvé l'élément
            if (personne.getId().equals(id)) {
               result = personne;
               break;
            }
         }
      }
//      afficher(result);
      stopChrono();
   }

   @Test
   public void avecLambda () {
      // Given
      List<Personne> list = initData_listPersonne();
      final int id = 2;
      Personne result = null;

      startChrono("avecLambda");
      for (int i = 0; i < NB_ITER; i++) {
         result = list.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
      }
//      afficher(result);
      stopChrono();
   }

   /**
    * Test provoiquant une erreur pour montrer la maintenabilité de la ST. 
    */
   @Test
   public void avecLambda_CE () {
      // Given
      List<Personne> list = initData_listPersonne();
      // Ajouter le tuple pour provoquer l'erreur
      list.add(new Personne(null, null));
      final int id = 9999;
      Personne result = null;

      startChrono("avecLambda_CE");
      for (int i = 0; i < NB_ITER; i++) {
         result = list.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
      }
//      afficher(result);
      stopChrono();
   }

   
   /** 
    * Conversion List --> Map.
    */
   @Test
   public void toMapSansStream () {
      // Given
      List<Personne> list = initData_listPersonne();
      Assert.assertTrue(list.size() > 0);

      startChrono("toMapWithSansStream");
      // List --> Map (Java6)
      Map<Integer, Personne> map1 = toMap(list);
      stopChrono();
      Assert.assertEquals(list.size(), map1.size());
   }
   private Map<Integer, Personne> toMap (List<Personne> pList) {
      final Map<Integer, Personne> hashMap = new HashMap<>();
      for (final Personne elem : pList) {
         hashMap.put(elem.getId(), elem);
      }
      return hashMap;
   }

   @Test
   public void toMapAvecStream () {
      // Given
      List<Personne> list = initData_listPersonne();
      Assert.assertTrue(list.size() > 0);

      startChrono("toMapAvecStream");
      // List --> Map (Java8 - stream)
      Map<Integer, Personne> map1 = list.stream().collect(Collectors.toMap(elem -> elem.getId(), elem -> elem));
      stopChrono();
      Assert.assertEquals(list.size(), map1.size());
   }

   
   /** 
    * Tableaux.
    */
   @Test
   public void toArraySansSansStream () {
      String[] tabElem = new String[] {
            "elem1", "elem2", "elem3"
      };
   }

   @Test
   public void toArrayAvecSansStream () {
      Stream<String> streamElem = Stream.of("elem1", "elem2", "elem3");
      // Pas possible de caster en 'String'
      Object[] tabElem = streamElem.toArray(); 
//      String[] tabElem = (String[]) streamElem.toArray(); // ERREUR java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.String; ([Ljava.lang.Object; and [Ljava.lang.String; are in module java.base of loader 'bootstrap')
      afficher(tabElem);
   }

}
