package fr.igpde;

/**
 * 
 * @author DQ9A1G
 *
 */
public class CheckStyle {
   /**
    * i compteur.
    */
   private int i;
   String chaine = "bb";

   /**
    * 
    * @return code retour
    */
   public final int getI () {
      return i;
   }

   public final void setI (int i) {
      this.i = i;
   }

   /**
    * @param args tableau
    */
   public static void main (final String[] args) {
      // TODO Auto-generated method stub
      CheckStyle cs = new CheckStyle();
      System.out.println(cs.chaine);

   }

}
