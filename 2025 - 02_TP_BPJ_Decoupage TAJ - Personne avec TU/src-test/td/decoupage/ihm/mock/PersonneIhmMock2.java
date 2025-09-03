package td.decoupage.ihm.mock;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import td.decoupage.ihm.IPersonneIhm;
import td.decoupage.metier.Personne;
import td.decoupage.service.PersonneService;

/**
 * Bouchon sur uniquement la couche présentation : accès réel au service et donc à la persistance.
 */
public class PersonneIhmMock2 implements IPersonneIhm {
   /** Les personnes saisies */
   private Personne[] _tabPersonneSaisie;
   private int _rang = -1;

   private PersonneService personneService = new PersonneService();

   @Override
   public Personne obtenirPersonneSaisie() {
      Personne retour;

      if (_rang < _tabPersonneSaisie.length - 1) {
         _rang++;
         retour = _tabPersonneSaisie[_rang];
      }
      else {
         retour = null;
      }

      return retour;
   }

   @Override
   public void closeIhm() {
      // RAS
   }

   @Override
   public int initBdD() throws ClassNotFoundException, SQLException {
      return personneService.initBdD();
   }

   @Override
   public void enregistrerPersonneEnBdD(Personne p) throws Exception {
      personneService.enregistrerPersonneEnBdD(p);
   }

   @Override
   public int getNbPersonnesEnBdD() throws Exception {
      return personneService.getNbPersonnesEnBdD();
   }

   public void setTabPersonneSaisie(Personne[] tabPersonne) {
      _tabPersonneSaisie = tabPersonne;
   }

   @Override
   public List<Personne> getListComplete() throws Exception {
      List<Personne> listPersonne = Arrays.asList(_tabPersonneSaisie);
      return listPersonne;
   }

}
