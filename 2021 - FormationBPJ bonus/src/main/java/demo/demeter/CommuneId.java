package demo.demeter;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class CommuneId implements Serializable, Cloneable {
   /**
    *
    */
   private static final Logger logger = Logger.getLogger(CommuneId.class);
   private static final long serialVersionUID = -7834712646745452104L;
   private short jeuCommunesId;
   private String departementId;
   private String codeCommune;

   public String getCodeCommune () {
      return codeCommune;
   }

   public void setCodeCommune (String codeCommune) {
      this.codeCommune = codeCommune;
   }

   public String getDepartementId () {
      return departementId;
   }

   public void setDepartementId (String departementId) {
      this.departementId = departementId;
   }

   public short getJeuCommunesId () {
      return jeuCommunesId;
   }

   public void setJeuCommunesId (short jeuCommunesId) {
      this.jeuCommunesId = jeuCommunesId;
   }

   public CommuneId(short jeuCommunesId, String departementId, String codeCommune) {
      super();
      this.jeuCommunesId = jeuCommunesId;
      this.departementId = departementId;
      this.codeCommune = codeCommune;
   }

   public CommuneId() {
      super();
   }

   public String toString () {
      return "jeu=" + jeuCommunesId + ",dep=" + departementId + ",com="
            + codeCommune;
   }

   public CommuneId clone () {
      CommuneId comIdClone = null;
      try {
         comIdClone = (CommuneId) super.clone();
         //attributs tous de type primitif
      }
      catch (CloneNotSupportedException e) {
         logger.error("Probl�me au clonage de l'Id commune " + this.toString());
      }
      return comIdClone;
   }

   @Override
   public boolean equals (Object obj) {
      if (obj instanceof CommuneId) {
         CommuneId other = (CommuneId) obj;

         if (this.jeuCommunesId != other.jeuCommunesId) {
            return false;
         }

         if (this.departementId == null || !this.departementId.equals(other.departementId)) {
            return false;
         }

         if (this.codeCommune == null || !this.codeCommune.equals(other.codeCommune)) {
            return false;
         }

         return true;
      }
      return false;
   }

}
