package td.decoupage._sans_couche;

import java.util.ArrayList;
import java.util.List;

/**
 * Bouchon sur toutes les couches : présentation à persistance.
 */
public class PersonneIhmMock1 implements IPersonneIhm {
   /** Les personnes saisies */
   private Personne[] _tabPersonneSaisie;
   /** Pour simuler la persistance */
   private List<Personne> _listPersonneEnBdD = new ArrayList<Personne>();
   private int _rang = -1;

   @Override
   public Personne obtenirPersonneSaisie() {
      Personne retour;

      if (_rang < _tabPersonneSaisie.length
         - 1) {
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
   public int initBdD() {
      // Simuler l'initialisation la BdD
      _listPersonneEnBdD.clear();
      return 0;
   }

   @Override
   public void enregistrerPersonneEnBdD(Personne p) {
      _listPersonneEnBdD.add(p);
   }

   @Override
   public int getNbPersonnesEnBdD() {
      return _listPersonneEnBdD.size();
   }

   public void setTabPersonneSaisie(Personne[] tabPersonne) {
      _tabPersonneSaisie = tabPersonne;
   }

   @Override
   public List<Personne> getListComplete() throws Exception {
      return _listPersonneEnBdD;
   }

}
