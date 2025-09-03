package td.decoupage.ihm;

import td.decoupage.ihm.mock.PersonneIhmMock2;
import td.decoupage.metier.Personne;

/**
 * Obtenir l'instance représentant l'IHM de saisie d'une 'Personne'.
 */
public class PersonneIhmFactory {
   public static final String DATA_TEST_saisirPersonne_CN = "saisirPersonne_CN";

   public static IPersonneIhm getInstance(String nomTest) {
      // TODO JBehave - Changer l'instance - Mock ou Réelle
//		return getInstanceReelle(nomTest);
      return getInstanceMock(nomTest);
   }

   private static IPersonneIhm getInstanceReelle(String nomTest) {
      IPersonneIhm retour = new Application();

      return retour;
   }

   private static IPersonneIhm getInstanceMock(String nomTest) {
      PersonneIhmMock2 retour;

      if (DATA_TEST_saisirPersonne_CN.equals(nomTest)) {
         // Initialiser les données
         retour = new PersonneIhmMock2();
         retour.setTabPersonneSaisie(new Personne[] { new Personne("BONO", "Jean", 30), new Personne("BOLE", "Maggie", 25) });
      }
      else {
         throw new IllegalArgumentException("Cas non prévu pour nomTest=" + nomTest);
      }

      return retour;
   }
}
