package tp_lambda.comparator.data;

public class Personne {
//public class Personne implements java.io.Serializable {
   
   public Personne(Integer id, String nom) {
      super();
      _Id = id;
      _Nom = nom;
   }

   private Integer _Id;
   
   public Integer getId () {
      return _Id;
   }

   public void setId (Integer id) {
      _Id = id;
   }

   private String _Nom;

   public String getNom () {
      return _Nom;
   }

   public void setNom (String nom) {
      this._Nom = nom;
   }

   @Override
   public String toString () {
      return _Nom;
   }
   
}
