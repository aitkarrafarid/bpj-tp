package tp.pmd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Affichage de la fenêtre
public class Fenetre extends JFrame implements ActionListener {

   /**
    * 
    */
   private static final long serialVersionUID = 5265376322133340293L;

   Arbre a =
      new Arbre(Arbre.demilargeur
         * Arbre.profmax, Arbre.demilargeur
            * Arbre.profmax, null, null, null, null, 0, 2);

   public Grille panneau = new Grille(a);
   private JButton bouton = new JButton("Lancement");

   public Fenetre() {
      this.setTitle("Problème à N corps");
      this.setSize(1000, 700);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BorderLayout());

      JPanel south = new JPanel();
      south.add(bouton);
      bouton.addActionListener(this);
      this.getContentPane().add(south, BorderLayout.SOUTH);
      this.getContentPane().add(panneau, BorderLayout.CENTER);

      // Création de la fenêtre et de la répartition de planètes
      Arbre.insereCorpsAleatoire(
         a,
         40,
         80,
         200,
         2
            * Math.pow(10, 45),
         6
            * Math.pow(10, 24),
         6
            * Math.pow(10, 12),
         512);
      this.setVisible(true);
      go();
   }

   // Boucle permettant le fonctionnement du programme jusqu'à arrêt par
   // l'utilisateur
   private void go() {
      for (;;) {
         Arbre b = new Arbre(a.x, a.y, null, null, null, null, 0, 2);
         panneau.a.calculToutesVitesses(panneau.a);
         panneau.a.nouvellePosition(b);
         panneau.a = b;
         panneau.repaint();
         try {
            Thread.sleep(50);
         }
         catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   // Fonction lancée lors de l'appui sur le bouton
   public void actionPerformed(ActionEvent arg0) {
      Arbre b = new Arbre(a.x, a.y, null, null, null, null, 0, 2);
      panneau.a.calculToutesVitesses(panneau.a);
      panneau.a.nouvellePosition(b);
      panneau.a = b;
      panneau.repaint();
   }

   public static void main(String[] args) {
      new Fenetre();
   }
}
