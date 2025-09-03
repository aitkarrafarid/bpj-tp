package demo.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExemplePropertiesFichier {

   /**
    * @param args
    * @throws IOException 
    */
   public static void main (String[] args) throws IOException {

      Properties monproperties = new Properties();
      // TODO demo properties : montrer les autres solutions de localisation
      // du fichier properties en commentant et décommentant les lignes ci-après
      String nomfichierProperties = "parametre.properties";
//		String nomfichierProperties = "/demo/properties/parametre.properties";
//		String nomfichierProperties = "adhoc/parametre.properties";
//		String nomfichierProperties = "/config/parametre.properties";

      InputStream is = null;
      FileInputStream in = null;
      try {
         is = ExemplePropertiesFichier.class.getResourceAsStream(nomfichierProperties);
         monproperties.load(is);
         // NE pas Utiliser ligne ci après si les fichiers sont dans les livrables
//	    String nomfichierProperties2 = "target/demo/properties/parametre.properties";
//			 in = new FileInputStream(nomfichierProperties2);
//			monproperties.load(in);
      }
      finally {
         if (is != null) {
            is.close();
         }
         if (in != null) {
            in.close();
         }
      }

      System.out.println(monproperties.getProperty("type.plateforme"));
      // on peut �galement mettre une valeur par d�faut si pas de cl� de ce
      // type trouv�e dasn les diff�rents fichiers
      System.out.println(monproperties
            .getProperty("type.plateforme", "local"));
   }

}
