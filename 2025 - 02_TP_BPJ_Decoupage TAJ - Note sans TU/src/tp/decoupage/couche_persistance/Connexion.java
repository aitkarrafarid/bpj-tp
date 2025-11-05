package tp.decoupage.couche_persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
// TODO Faire remonter les exceptions
	private static Connection maConnection;
	private final static String URL = "jdbc:hsqldb:mem:dbpersonnes";
	private final static String DRIVER = "org.hsqldb.jdbcDriver";

	// dans la vraie vie cette calsse serait un singleton, ici une version plus
	// simple via des methodes statiques

	public static Connection getConnexion() {
		// dans cette version on ne propage l'exception, on se contente
		// d'afficher la trace en cas d'erreur
		if (maConnection != null)
			return maConnection;
			// sollicitation du driver Hsql
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // obtention d'une connection
        try {
            maConnection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maConnection;
	}

	public void close() {
		try {
			if (maConnection != null) {
				maConnection.close();
				maConnection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
