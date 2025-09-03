package td.decoupage._sans_couche;

import java.util.List;

public interface IPersonneIhm {

   /**
    * Créer la personne.
    * 
    * @return La personnesaisie.
    */
   abstract public Personne obtenirPersonneSaisie();

   /**
    * Fermer le flux de saisie.
    */
   abstract public void closeIhm() throws Exception;

   /**
    * Initialiser la BdD.
    * 
    * @return
    */
   abstract public int initBdD() throws Exception;

   /**
    * Enregistrer en BdD.
    */
   abstract public void enregistrerPersonneEnBdD(Personne p) throws Exception;

   /**
    * Obtenir le nombre de personnes en BdD.
    * 
    * @return Le nombre dans la table personne.
    */
   abstract public int getNbPersonnesEnBdD() throws Exception;

   /**
    * Obtenir la liste des personnes.
    * 
    * @return La liste désirée.
    */
   abstract public List<Personne> getListComplete() throws Exception;
}
