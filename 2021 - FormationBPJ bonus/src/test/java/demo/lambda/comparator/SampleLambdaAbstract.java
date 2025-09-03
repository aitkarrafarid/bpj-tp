package demo.lambda.comparator;

import java.util.ArrayList;
import java.util.List;

import demo.lambda.comparator.data.Personne;
import socle.cours.IllustrationCoursAbstract;

public class SampleLambdaAbstract extends IllustrationCoursAbstract {

   public SampleLambdaAbstract(String _Name) {
      super(_Name);
   }

   protected List<Personne> initData_listPersonne () {
      List<Personne> vReturn = new ArrayList<>();
      int i = 1;
      vReturn.add(new Personne(i++, "ZOLA"));
      vReturn.add(new Personne(i++, "DUPONT"));
      vReturn.add(new Personne(i++, "BONO"));
      return vReturn;
   }
}
