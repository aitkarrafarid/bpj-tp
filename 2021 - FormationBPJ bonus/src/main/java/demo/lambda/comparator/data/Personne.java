// Fichier : Personne.java
package demo.lambda.comparator.data;

public class Personne {
   
   public Personne(Integer id, String nom) {
      super();
      _id = id;
      _nom = nom;
   }

   private Integer _id;
   
   public Integer getId () {
      return _id;
   }

   public void setId (Integer id) {
      _id = id;
   }

   private String _nom;

   public String getNom () {
      return _nom;
   }

   public void setNom (String nom) {
      this._nom = nom;
   }

   @Override
   public String toString () {
      return _nom;
   }
   
}
