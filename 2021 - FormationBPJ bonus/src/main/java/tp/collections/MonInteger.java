// Fichier : "MonInteger.java"
package tp.collections;

public class MonInteger {

   private Integer entier;

   public MonInteger(Integer entier) {
      super();
      this.entier = entier;
   }

   public Integer getEntier () {
      return entier;
   }

   public void setEntier (Integer entier) {
      this.entier = entier;
   }

   @Override
   public int hashCode () {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((entier == null) ? 0 : entier.hashCode());
      return result;
   }

   @Override
   public boolean equals (Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      MonInteger other = (MonInteger) obj;
      if (entier == null) {
         if (other.entier != null)
            return false;
      }
      else if (!entier.equals(other.entier))
         return false;
      return true;
   }

}
