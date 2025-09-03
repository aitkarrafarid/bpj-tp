package td.decoupage.persistance;

import java.sql.Connection;
import java.sql.SQLException;

public class AbstractDao {
   public Connection getConnexion() throws ClassNotFoundException, SQLException {
      return MaConnexion.getConnexion();
   }

   public void closeDao() throws Exception {
      // RAS
   }
}
