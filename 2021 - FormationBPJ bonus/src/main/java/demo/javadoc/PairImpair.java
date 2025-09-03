package demo.javadoc;

import java.util.ArrayList;
import java.util.List;

/**
 * <br>
 * Cette classe est utilis�e pour montrer l'�criture de Javadoc lors d'une
 * formation � l'IGPDE </br>
 * 
 * @version 1 (utiliser de pr�f�rence le versionning du gestionnaire de version)
 * 
 * @author Bruno Berlemont :
 * 
 */
public class PairImpair {
   /**
    * la liste d'entier qui fait l'objet des diffrents type de comptage
    */
   private List<Integer> mesEntiers = new ArrayList<Integer>();

   public PairImpair(List<Integer> mesEntiers) {
      super();
      this.mesEntiers = mesEntiers;
   }

   /**
    * 
    * @return le nombre d'entiers pairs et z�ro si la liste est vide ou
    *         n'existe pas
    */
   public int donneNbEntiersPairs () {
      int retour = 0;
      for (int i : mesEntiers) {
         if (i % 2 == 0) { // penser � g�n�raliser en param�trant si
                          // n�cessaire
            retour++;
         }
      }
      return retour;
   }

   /**
    * @deprecated utiliser dor�navant la taille de la liste combin�e avec
    *             donneNbEntiersPairs()
    * @see PairImpair
    * @return le nombre d'entiers impairs et z�ro si la liste est vide ou
    *         n'existe pas
    */
   public int donneNbEntiersImpairs () {
      int retour = 0;
      for (int i : mesEntiers) {
         if (i % 2 == 1) {
            retour++;
         }
      }
      return retour;
   }

}
