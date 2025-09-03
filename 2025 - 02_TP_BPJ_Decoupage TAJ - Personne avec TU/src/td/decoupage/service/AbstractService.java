package td.decoupage.service;

import java.sql.SQLException;

import td.decoupage.persistance.AbstractDao;
import td.decoupage.persistance.MaConnexion;

/**
 * Service générique racine.
 */
abstract public class AbstractService {
   private AbstractDao abstractDao;

   public AbstractService(AbstractDao abstractDao) {
      this.abstractDao = abstractDao;
   }

   /**
    * Fermeture du service.
    * 
    * @throws SQLException
    */
   public void closeService() throws Exception {
      this.abstractDao.closeDao();
      MaConnexion.close();
   }

   public AbstractDao getAbstractDao() {
      return this.abstractDao;
   }

   public void setAbstractDao(AbstractDao abstractDao) {
      this.abstractDao = abstractDao;
   }

}
