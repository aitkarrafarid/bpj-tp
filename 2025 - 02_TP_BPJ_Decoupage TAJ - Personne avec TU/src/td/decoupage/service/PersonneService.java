package td.decoupage.service;

import java.sql.SQLException;
import java.util.List;

import td.decoupage.metier.Personne;
import td.decoupage.persistance.MaConnexion;
import td.decoupage.persistance.PersonneDao;

public class PersonneService extends AbstractService {
   /**
    * Constructeur.
    */
   public PersonneService() {
      // Instancier le service avec le DAO de "production" par défaut
      super(new PersonneDao());
   }

   public int initBdD() throws ClassNotFoundException, SQLException {
      return MaConnexion.initBdD();
   }

   public void enregistrerPersonneEnBdD(Personne p) throws Exception {
      getPersonneDao().enregistrerPersonneEnBdD(p);
   }

   public int getNbPersonnesEnBdD() throws Exception {
      return getPersonneDao().getNbPersonnesEnBdD();
   }

   public List<Personne> getListeComplete() throws Exception {
      return getPersonneDao().getListeComplete();
   }

   public List<Personne> recherchePersonneSelonPrenom(String prenom) throws Exception {
      return getPersonneDao().recherchePersonneSelonPrenom(prenom);
   }

   public int nbPersonnesNommees(String prenom) throws Exception {
      List<Personne> personnesDePrenomParam = recherchePersonneSelonPrenom(prenom);
      int nbPersonnesNomRenseigne = 0;
      for (Personne p : personnesDePrenomParam) {
         if (p.getNom() != null) {
            nbPersonnesNomRenseigne++;
         }
      }
      return nbPersonnesNomRenseigne;
   }

   /**
    * Obtenir le DAO de Personne associé au service.
    * 
    * @return L'instance désirée.
    */
   public PersonneDao getPersonneDao() {
      return (PersonneDao) getAbstractDao();
   }

   /**
    * Affecter le DAO de Personne.
    * 
    * @param personneDao L'instance à utiliser dans le service.
    */
   public void setPersonneDao(PersonneDao personneDao) {
      setAbstractDao(personneDao);
   }
}
