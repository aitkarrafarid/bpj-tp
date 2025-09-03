package tp.interfaces.couche_persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
   private static Connection maConnection;
   private final static String URL = "jdbc:hsqldb:mem:dbpersonnes";
   private final static String DRIVER = "org.hsqldb.jdbcDriver";

   // dans la vraie vie cette calsse serait un singleton, ici une version plus
   // simple via des methodes statiques

   public static Connection getConnexion() throws ClassNotFoundException, SQLException {
      // dans cette version on ne propage l'exception, on se contente
      // d'afficher la trace en cas d'erreur
      if (maConnection != null)
         return maConnection;
      // sollicitation du driver Hsql
      Class.forName(DRIVER);
      // obtention d'une connection
      maConnection = DriverManager.getConnection(URL);
      return maConnection;
   }

   public static void close() throws SQLException {
      if (maConnection != null) {
         maConnection.close();
         maConnection = null;
      }
   }
}
