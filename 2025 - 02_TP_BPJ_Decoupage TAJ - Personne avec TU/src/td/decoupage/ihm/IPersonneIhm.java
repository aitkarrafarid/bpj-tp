package td.decoupage.ihm;

import java.util.List;

import td.decoupage.metier.Personne;

public interface IPersonneIhm {

   /**
    * Création d'une note.
    * 
    * @return La note saisie.
    */
   abstract public Personne obtenirPersonneSaisie() throws Exception;

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
