package td.decoupage._sans_couche;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonneIhmTest {
   IPersonneIhm _PersonneIhm = PersonneIhmFactory.getInstance(PersonneIhmFactory.DATA_TEST_saisirPersonne_CN);

   @Before
   public void setup() throws Exception {
      _PersonneIhm.initBdD();
   }

   @After
   public void tearDown() throws Exception {
      try {
         _PersonneIhm.closeIhm();
      }
      catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /**
    * Cas nominal pour saisir des personnes.
    * 
    * @throws Exception
    */
   @Test
   public void saisirPersonnes_CN() throws Exception {
      // Given
      Personne personne;

      int cptSaisieIhm = 0;
      // Simuler la saisie des Personnes
      while ((personne = _PersonneIhm.obtenirPersonneSaisie()) != null) {
         cptSaisieIhm++;
         _PersonneIhm.enregistrerPersonneEnBdD(personne);
      };

      // When
      int nbPersonnes = _PersonneIhm.getNbPersonnesEnBdD();
      // Obtenir la liste de toutes les personnes
      List<Personne> listPersonne = _PersonneIhm.getListComplete();

      System.out.println(listPersonne);
      // Then
      Assert.assertEquals(nbPersonnes, cptSaisieIhm);
      Assert.assertEquals(listPersonne.size(), nbPersonnes);
   }
}
