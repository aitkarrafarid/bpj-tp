/**
 * 
 */
package tp_collections.set;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

/**
 * 3°) Reprendre la classe SetInteger (en la copiant et la nommant SetMyType) pour mettre dans le Set des MyType au lieu des Integer. Exécuter et constater la taille de la liste
 * 4°) Dans la classe MyType adapter les méthodes HashCode() et Equals() pour reproduire le comportement du 1)
 */
public class Sample4HashSet_MonIteger<MyType> {
   
   public static void main(String[] args) {
      try {
         Sample4HashSet_MonIteger<MonInteger0> etape3_1 = new Sample4HashSet_MonIteger<>("tp_collections.set.MonInteger0");
         etape3_1.doTraitement("Etape 3.1");
         // Conclusion :
         // SI pas de redéfinituion de "equals()" et "hashCode()" ALORS il y aura des doublons
         // L'instance n'étant pas "equals()" : pas de suppression !

         Sample4HashSet_MonIteger<MonInteger1> etape3_2 = new Sample4HashSet_MonIteger<>("tp_collections.set.MonInteger1");
         etape3_2.doTraitement("Etape 3.2");
         // Conclusion :
         // Comme redéfinition classique de "equals()" et "hashCode()" : pas de doublons
         // Suppression de 1 seule instance : celle ayant la valeur "100" uniquement !

         Sample4HashSet_MonIteger<MonInteger2> etape4 = new Sample4HashSet_MonIteger<>("tp_collections.set.MonInteger2");
         etape4.doTraitement("Etape 4");
         // Conclusion :
         // Idem précédement : c'est une variante du "equals()" et "hashCode()"
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   private String _ImplemName;

   public Sample4HashSet_MonIteger(String pImplemName) {
      _ImplemName = pImplemName;
   }
   
   /**
    * Ecrire une méthode qui crée une liste de 1 million d’entiers (de 1 à 1 000 000). Ajouter 100 fois le nombre 1. constater la taille de la liste. On utilisera un ArralyList (et bien sur des MyType c’est à dire une classe java pour les entiers et non un type primitif).
    * @throws SecurityException 
    * @throws NoSuchMethodException 
    * @throws ClassNotFoundException 
    */
   private Set<MyType> doTraitement_intern() throws Exception {
      Set<MyType> setMyType = new HashSet<MyType>();
      // Ajouter 1 million d’entiers
      for (int i = 0; i < 1000000; i++) {
//         listMyType.add(new MyType(i));
         setMyType.add(getInstanceWithName(new Integer(i)));
      }

      // Ajouter 100 fois le nombre 1
      for (int i = 0; i < 100; i++) {
         // Rq : on met la même valeur
//         listMyType.add(new MyType(1));
         setMyType.add(getInstanceWithName(new Integer(1)));
      }

      System.out.println(
         "Ajout de 1 million de \"i\" et 100 \"1\" : setMyType.size() = "
            + setMyType.size());
//      Assert.assertEquals(1000000, listMyType.size());

      return setMyType;
   }

   /**
    * Détruire 5000 fois l’élément de rang 100. Vérifier la taille de la liste. Afficher la durée d’exécution et la mémoire utilisée (voir Runtime.getRuntime()
    * @throws ClassNotFoundException 
    * @throws SecurityException 
    * @throws NoSuchMethodException 
    */
   private void doTraitement(String pNomEtape) throws Exception {
      long start;
      long end;

      System.out.println("-------------------------------");
      System.out.println(pNomEtape + " avec " + _ImplemName);
      Set<MyType> setMyType = doTraitement_intern();

      start = System.currentTimeMillis();
      // Détruire 5000 fois l’élément de valeur '100'
      for (int i = 0; i < 5000; i++) {
         setMyType.remove(getInstanceWithName(new Integer(100)));
      }
      end = System.currentTimeMillis();
      System.out.println(
         "Suppression de 500 éléments de valeur '100' : setMyType.size() = "
            + setMyType.size());
      System.out.println(
         "   Temps en ms        : "
            + (end
               - start));
   }

   /**
    * Instancier un 'MyType' en passant un entier dans le constructeur.
    * @param pValue La valeur entière.
    * @return L'instance désirée.
    * @throws Exception
    */
   private MyType getInstanceWithName(Integer pValue) throws Exception {
      @SuppressWarnings("unchecked")
      Class<MyType> vClass = (Class<MyType>) Class.forName(_ImplemName);
      Constructor<MyType> vConstructor = vClass.getConstructor(Integer.class);
      MyType vMyType = vConstructor.newInstance(pValue);
      return vMyType;
   }
} // FIN classe

/**
 * Créer une classe appelée MyType avec redéfinition classique de "equals()" et "hashCode()".
 */
class MonInteger1 extends MonInteger0 {
   public MonInteger1(Integer entier) {
      super(entier);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result =
         prime
            * result
            + ((entier == null) ? 0 : entier.hashCode());
      return result;
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      MonInteger0 other = (MonInteger0) obj;
      if (entier == null) {
         if (other.entier != null)
            return false;
      }
      else if (!entier.equals(other.entier))
         return false;
      return true;
   }
}

/**
 * Variante reproduisant le comportant d'un 'Integer'.
 */
class MonInteger2 extends MonInteger0 {
   public MonInteger2(Integer entier) {
      super(entier);
   }
   
   @Override
   public int hashCode() {
      return entier.hashCode();
   }
   
   @Override
   public boolean equals(Object obj) {
      if (obj instanceof MonInteger2) {
         MonInteger2 vInteger = (MonInteger2) obj;
         return entier.equals(vInteger.entier);
      }
      else {
         return false;
      }
   }
}
