package td.decoupage._sans_couche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexion {
   private static Connection maConnection;
//	private final static String DRIVER = "org.hsqldb.jdbcDriver"; // HSQL
//	private final static String URL = "jdbc:hsqldb:mem:dbpersonnes";

   private final static String DRIVER = "org.h2.Driver"; // H2
   private final static String URL = "jdbc:h2:c:/temp/dbpersonnes.h2.db";

   // dans la vraie vie cette calsse serait un singleton, ici une version plus
   // simple via des methodes statiques

   public static Connection getConnexion() throws ClassNotFoundException, SQLException {
      Connection retour;
      // dans cette version on ne propage l'exception, on se contente
      // d'afficher la trace en cas d'erreur
      if (maConnection != null) {
         retour = maConnection;
      }
      else {
         // sollicitation du driver Hsql
         Class.forName(DRIVER);
         // obtention d'une connection
         maConnection = DriverManager.getConnection(URL, "sa", null);
         retour = maConnection;
      }

      return retour;
   }

   public static void close() throws SQLException {
      if (maConnection != null) {
         maConnection.commit();
         maConnection.close();
         maConnection = null;
      }
   }
}
