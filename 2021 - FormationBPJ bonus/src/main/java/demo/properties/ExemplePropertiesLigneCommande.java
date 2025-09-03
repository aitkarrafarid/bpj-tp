package demo.properties;

public class ExemplePropertiesLigneCommande {

   /**
    * @param args
    */
   public static void main (String[] args) {
      // TODO Ajouter en paramètre VM :
      // -Dtype.plateforme=enLigneDeCommande
      System.out.println(System.getProperty("type.plateforme"));

      StringBuffer sb = new StringBuffer("bonne");
      sb.append(" pratique");
      sb.append(" java");
      System.out.println(sb);
      sb.insert(0, "ajout ");
      System.out.println(sb);

   }
}
