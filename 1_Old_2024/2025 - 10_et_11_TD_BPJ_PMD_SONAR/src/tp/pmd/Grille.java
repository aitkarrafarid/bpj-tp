package tp.pmd;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

// Fonction d'affichage graphique de l'univers
public class Grille extends JPanel {

   /**
    * 
    */
   private static final long serialVersionUID = 2227594564885569945L;
   int diametre = 8;
   public Arbre a;

   Grille(Arbre a) {
      this.a = a;
   }

   public void paintComponent(Graphics g) {
      // Les lignes de la grille
      // int dim = 10; // dimension d'une case de la grille
      // int larg = getWidth();
      // int haut = getHeight();
      //
      // for (int i = 0; i < 7 * dim + 1; i += dim) {
      // g.drawLine(i, 0, i, haut); // Les lignes verticales de la grille
      // g.drawLine(0, i, larg, i); // Les lignes horizontales de la grille
      // }

      g.setColor(Color.white);

      // On le dessine de sorte qu'il occupe toute la surface pour renouveler le
      // fond
      g.fillRect(0, 0, this.getWidth(), this.getHeight());

      // La grille vide
      g.setColor(Color.BLACK);
      this.parcoursEtAfficheArbre(g, this.a);
   }

   // Permet d'afficher les planètes de l'arbre comme des cercles suivant
   // leurs masses par un parcours de celui-ci
   public void parcoursEtAfficheArbre(Graphics g, Arbre b) {
      if (b != null) {
         if (b.estFeuille
            && b.bplanete == true) {
            g.setColor(b.planete.couleur());
            g.fillOval(
               (int) b.x
                  - diametre
                     / 2,
               (int) b.y
                  - diametre
                     / 2,
               diametre,
               diametre);
         }
         else {
            // Lecture de bas gauche à bas droite en rotation (parcours
            // préfixe)
            this.parcoursEtAfficheArbre(g, b.so);
            this.parcoursEtAfficheArbre(g, b.no);
            this.parcoursEtAfficheArbre(g, b.ne);
            this.parcoursEtAfficheArbre(g, b.se);
         }
      }
   }

}