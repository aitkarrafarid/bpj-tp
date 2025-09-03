package tp.pmd;

import java.awt.Color;

public class Planete {

   public static double G = 0.000000000067;
   double masse;

   Vecteur vitesse; // Correspond à la vitesse de la planète
   Vecteur acc; // accélération de la planete
   Color col;

   Planete(double masse, Vecteur vitesse, Vecteur acc) {
      this.masse = masse;
      this.vitesse = vitesse;
      this.acc = acc;
   }

   // Donne la couleur suivant la masse de la planète
   public Color couleur() {
      if (this.masse == 2
         * Math.pow(10, 45)) {
         return col = Color.red;
      }
      else if (this.masse == 6
         * Math.pow(10, 12)) {
         return col = Color.green;
      }
      else {
         return col = Color.blue;
      }
   }

   // Calcul la force de gravitation à laquelle est soumise une planète dans
   // l'arbre
   public void gravitation(Arbre a, double x, double y) {
      if (a.estFeuille
         && a.bplanete) {
         if (a.x != x
            || a.y != y) {
            Vecteur v =
               new Vecteur(x
                  - a.x, y
                     - a.y);
            this.acc.x =
               this.acc.x
                  - (G
                     * a.planete.masse
                     * (x
                        - a.x))
                     * Math.pow(10, -23)
                     / (v.norme()
                        * v.norme()
                        * v.norme());
            this.acc.y =
               this.acc.y
                  - (G
                     * a.planete.masse
                     * (y
                        - a.y))
                     * Math.pow(10, -23)
                     / (v.norme()
                        * v.norme()
                        * v.norme());
         }
      }
      else { // Parcours de l'arbre si on a rencontré un noeud
         if (a.so != null) {
            this.gravitation(a.so, x, y);
         }
         if (a.ne != null) {
            this.gravitation(a.ne, x, y);
         }
         if (a.no != null) {
            this.gravitation(a.no, x, y);
         }
         if (a.se != null) {
            this.gravitation(a.se, x, y);
         }
      }
   }

   // Donne la nouvelle vitesse des planètes suivant leur ancienne et
   // l'accélération actuelle
   public void nouvelleVitesse() {
      this.vitesse.x =
         this.vitesse.x
            + this.acc.x;
      this.acc.x = 0;
      this.vitesse.y =
         this.vitesse.y
            + this.acc.y;
      this.acc.y = 0;
   }

}
