package tp.pmd;

import java.util.ArrayList;

public class Arbre {

   public static double demilargeur = 1; // pas de d�placement
   public static double profmax = 1024; // profondeur maximale de l'arbre
   Planete planete;
   boolean bplanete;
   double masse; // masse du noeud
   double x, y; // position du centre de la case
   boolean estFeuille;
   Arbre so, no, ne, se; // sous-arbres de notre noeud
   double profondeur;

   // Constructeur des feuilles
   Arbre(double x, double y) {
      this.estFeuille = true;
      this.x = x;
      this.y = y;
      this.bplanete = false;
   }

   Arbre(double x, double y, Planete planete) {
      this.estFeuille = true;
      this.x = x;
      this.y = y;
      this.bplanete = true;
      this.planete = planete;
   }

   // Arbre � noeud
   Arbre(double x, double y, Arbre so, Arbre no, Arbre ne, Arbre se, double masse, double profondeur) {
      this.estFeuille = false;
      this.so = so;
      this.no = no;
      this.ne = ne;
      this.se = se;
      this.x = x;
      this.y = y;
      this.masse = masse;
      this.profondeur = profondeur;
   }

   // Cr�ation d'une r�partition al�atoire de plan�tes
   static void insereCorpsAleatoire (Arbre a, int n1, int n2, int n3, double m1, double m2,
         double m3, int maxcoordonnees) {
      // on cr�e n1 planetes de masse m1 � vitesse 0 qu'on met dans une liste
      ArrayList<Planete> listePlanete = new ArrayList<Planete>();
      for (int i = 1; i < n1 + 1; i++) {
         Planete planete = new Planete(m1, new Vecteur(0, 0), new Vecteur(0, 0));
         listePlanete.add(planete);
      }
      // on cr�e n2 planetes de masse m2 � vitesse 0 qu'on met dans la meme
      // liste � la suite
      for (int i = 1; i < n2 + 1; i++) {
         Planete planete = new Planete(m2, new Vecteur(0, 0), new Vecteur(0, 0));
         listePlanete.add(planete);
      }
      // idem m3 et n3
      for (int i = 1; i < n3 + 1; i++) {
         Planete planete = new Planete(m3, new Vecteur(0, 0), new Vecteur(0, 0));
         listePlanete.add(planete);
      }
      // on parcourt la liste de planete et on l'insere dans l'arbre avec x et
      // y al�atoire
      for (Planete p : listePlanete) {
         // pour x on tire un nombre entre entre 1 et maxcoordonnees = 512
         // par exemple
         double xAlea = Math.random();
         // j'obtiens un nombre al�atoire entre 0 et 1
         double xAleamaxcoordonnees = xAlea * maxcoordonnees;
         // j'obtiens un nombre d�cimal al�atoire entre 0 et maxcoordonnees
         double x = Math.round(xAleamaxcoordonnees);
         // j'obtiens un nombre entier al�atoire entre 0 et maxcoordonnees
         // idem pour y, on relance Math.random() pour retirer un autre nb
         // aleatoire
         double yAlea = Math.random();
         double yAleaMaxCoordonnees = yAlea * maxcoordonnees;
         double y = Math.round(yAleaMaxCoordonnees);
         Arbre.insereCorps(2 * Arbre.demilargeur * x + 1, 2 * Arbre.demilargeur * y + 1, p, a);
      }
   }

   // Insertion d'un corps dans un arbre
   static Arbre insereCorps (double x, double y, Planete planete, Arbre a) {

      if (a.x == x && a.y == y) { // la position correspond � celle voulue
         System.out.println("Bingo x=x et y=y pour " + x + " " + y);
         a.estFeuille = true;
         a.bplanete = true;
         a.planete = planete;
         return a;
      }
      else {
         // Distinction des cas suivant la position actuelle et la position voulue
         if (x > a.x) {

            if (y > a.y) {
               if (a.se == null) {
                  Arbre b = new Arbre(a.x + (profmax * 2 * demilargeur) / (Math.pow(2, a.profondeur)),
                        a.y + (profmax * 2 * demilargeur) / (Math.pow(2, a.profondeur)), null, null, null,
                        null, 0, a.profondeur + 1);
                  a.se = b;
                  return insereCorps(x, y, planete, a);

               }
               else {
                  // Insertion noued fictif qui sera remplac� par la suite
                  return insereCorps(x, y, planete, a.se);
               }
            }
            else if (y < a.y) {
               if (a.ne == null) {
                  Arbre b = new Arbre(a.x + (profmax * 2 * demilargeur) / (Math.pow(2, a.profondeur)),
                        a.y - (profmax * 2 * demilargeur) / (Math.pow(2, a.profondeur)), null, null, null,
                        null, 0, a.profondeur + 1);
                  a.ne = b;
                  return insereCorps(x, y, planete, a);
               }
               else {
                  return insereCorps(x, y, planete, a.ne);
               }
            }

         }
         else if (x < a.x) {

            if (y > a.y) {
               if (a.so == null) {
                  Arbre b = new Arbre(a.x - (profmax * 2 * demilargeur) / (Math.pow(2, a.profondeur)),
                        a.y + (profmax * 2 * demilargeur) / (Math.pow(2, a.profondeur)), null, null, null,
                        null, 0, a.profondeur + 1);
                  a.so = b;
                  return insereCorps(x, y, planete, a);
               }
               else {
                  return insereCorps(x, y, planete, a.so);
               }
            }
            else if (y < a.y) {
               if (a.no == null) {
                  Arbre b = new Arbre(a.x - (profmax * 2 * demilargeur) / (Math.pow(2, a.profondeur)),
                        a.y - (profmax * 2 * demilargeur) / (Math.pow(2, a.profondeur)), null, null, null,
                        null, 0, a.profondeur + 1);
                  a.no = b;
                  return insereCorps(x, y, planete, a);
               }
               else {
                  return insereCorps(x, y, planete, a.no);
               }
            }
         }
      }

      System.out.println("pas normal x=" + a.x + " y=" + a.y);
      return a;
   }

   // Calcul des vitesses des plan�tes de l'arbre
   public void calculToutesVitesses (Arbre a) {
      if (a.estFeuille) {
         a.planete.gravitation(this, a.x, a.y);
         a.planete.nouvelleVitesse();
      }
      else {
         // Lecture de bas gauche � bas droite en rotation de l'arbre (parcours
         // pr�fixe)
         if (a.so != null)
            this.calculToutesVitesses(a.so);
         if (a.no != null)
            this.calculToutesVitesses(a.no);
         if (a.ne != null)
            this.calculToutesVitesses(a.ne);
         if (a.se != null)
            this.calculToutesVitesses(a.se);
      }
   }

   public void nouvellePosition (Arbre a) {
      if (this.estFeuille && this.bplanete) {// si la norme de la vitesse est trop
                                             // faible
         if (this.planete.vitesse.norme() < Math.pow(10, -7)) {
            insereCorps(this.x, this.y, this.planete, a);
         }
         else {
            // Ma Diff�renciation des cas de la vitesse suivant la division
            // de la grille
            if (this.planete.vitesse.x > 0) {
               if (this.planete.vitesse.y > Math.sqrt(2) * this.planete.vitesse.x) {
                  insereCorps(this.x, this.y + 2 * demilargeur, this.planete, a);
               }
               else if ((1 / Math.sqrt(2)) * this.planete.vitesse.x < this.planete.vitesse.y
                     && this.planete.vitesse.y < Math.sqrt(2) * this.planete.vitesse.x) {
                  insereCorps(this.x + 2 * demilargeur, this.y + 2 * demilargeur, this.planete, a);
               }
               else if (-this.planete.vitesse.y > (1 / Math.sqrt(2)) * this.planete.vitesse.x
                     && -this.planete.vitesse.y < Math.sqrt(2) * this.planete.vitesse.x) {
                  insereCorps(this.x + 2 * demilargeur, this.y - 2 * demilargeur, this.planete, a);
               }
               else if (this.planete.vitesse.y < -Math.sqrt(2) * this.planete.vitesse.x) {
                  insereCorps(this.x, this.y - 2 * demilargeur, this.planete, a);
               }
               else {
                  insereCorps(this.x + 2 * demilargeur, this.y, this.planete, a);
               }
            }
            else if (this.planete.vitesse.x < 0) {
               if (this.planete.vitesse.y < Math.sqrt(2) * this.planete.vitesse.x) {
                  insereCorps(this.x, this.y - 2 * demilargeur, this.planete, a);
               }
               else if (-(1 / Math.sqrt(2)) * this.planete.vitesse.x < -this.planete.vitesse.y
                     && -this.planete.vitesse.y < -Math.sqrt(2) * this.planete.vitesse.x) {
                  insereCorps(this.x - 2 * demilargeur, this.y - 2 * demilargeur, this.planete, a);
               }
               else if (this.planete.vitesse.y > -Math.sqrt(2) * this.planete.vitesse.x) {
                  insereCorps(this.x, this.y + 2 * demilargeur, this.planete, a);
               }
               else if (this.planete.vitesse.y > -(1 / Math.sqrt(2)) * this.planete.vitesse.x
                     && this.planete.vitesse.y < -Math.sqrt(2) * this.planete.vitesse.x) {
                  System.out.println("ce casxc ci");
                  insereCorps(this.x - 2 * demilargeur, this.y + 2 * demilargeur, this.planete, a);
               }
               else {
                  insereCorps(this.x - 2 * demilargeur, this.y, this.planete, a);
               }
            }
            else {
               if (this.planete.vitesse.y == 0) {
                  insereCorps(this.x, this.y, this.planete, a);
               }
               else if (this.planete.vitesse.y > 0) {
                  insereCorps(this.x, this.y + 2 * demilargeur, this.planete, a);
               }
               else {
                  insereCorps(this.x, this.y - 2 * demilargeur, this.planete, a);
               }
            }
         }
      }
      else { // on applique ensuite la fonction r�cursivement � tous les
            // sous-arbres d'un noeud
         if (this.so != null) {
            this.so.nouvellePosition(a);
         }
         if (this.ne != null) {
            this.ne.nouvellePosition(a);
         }
         if (this.no != null) {
            this.no.nouvellePosition(a);
         }
         if (this.se != null) {
            this.se.nouvellePosition(a);
         }
      }
   }

}
