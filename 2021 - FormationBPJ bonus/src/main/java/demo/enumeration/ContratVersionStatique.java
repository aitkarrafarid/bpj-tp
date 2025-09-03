package demo.enumeration;

import java.util.List;

public class ContratVersionStatique {

   public final static int CONTRAT_CODE_ENCOURS = 1, CONTRAT_CODE_VALIDE = 2,
         CONTRAT_CODE_CLOTURE = 3;
   public final static String CONTRAT_LIBELLE_ENCOURS = "en cours",
         CONTRAT_LIBELLE_VALIDE = "valide",
         CONTRAT_LIBELLE_CLOTURE = "clotur�";
   // classe coeur de m�tier
   // un certain nombre d'attributs
   // ....
   private TypeContrat typeContrat;

   // et un certain nombre de m�thodes
   // ....

   static public void cloturerValides (List<Contrat> contrats) {
      for (Contrat c : contrats) {
         if (c.getTypeContrat().getCode() == CONTRAT_CODE_VALIDE) {
            // appel du traitement de cloture des contrats valides
         }
         else if (c.getTypeContrat().getCode() == CONTRAT_CODE_ENCOURS) {
            // ne rien faire
         }
         else if (c.getTypeContrat().getCode() == CONTRAT_CODE_CLOTURE) {
            // ne rien faire
         }
         else {
            // ne rien faire
         }
      }
   }

   public TypeContrat getTypeContrat () {
      return typeContrat;
   }

}
