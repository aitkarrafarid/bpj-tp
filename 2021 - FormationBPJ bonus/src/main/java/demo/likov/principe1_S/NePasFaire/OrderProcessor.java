package demo.likov.principe1_S.NePasFaire;

import demo.likov.MySqlConnection;
import demo.likov.Order;

/**
 * Ce module pourrait changer pour trois raisons. Premièrement, la logique de traitement des commandes peut changer. Deuxièmement, 
 * la façon dont les commandes sont enregistrées (type de base de données) peut changer. Troisièmement, la façon dont la confirmation est envoyée peut changer 
 * (par exemple, supposons que nous devions envoyer un SMS plutôt qu'un e-mail).
 * Le principe de responsabilité unique implique que les trois aspects de ce problème sont en réalité trois responsabilités différentes. 
 * Cela signifie qu'ils doivent être dans des classes ou des modules différents. Combiner plusieurs entités qui peuvent changer à des moments différents 
 * et pour des raisons différentes est considéré comme une mauvaise décision de conception.
 * 
 * Il est préférable de diviser ce module 'OrderProcessor' en trois modules distincts, chacun remplissant une seule fonction : 
 *    - ConfirmationEmailSender : gestion de l'envoie d'email
 *    - MySQLOrderRepository : les intéractions avec la BdD
 *    - OrderProcessor : la commande
 *    
 * {@link https://codegym.cc/fr/groups/posts/fr.232.solid-cinq-principes-de-base-de-la-conception-de-classes-en-java}
 */
public class OrderProcessor {
   public void process (Order order) {
      if (order.isValid() && save(order)) {
         sendConfirmationEmail(order);
      }
   }

   private boolean save (Order order) {
      MySqlConnection connection = new MySqlConnection("database.url");
      // Save the order in the database

      return true;
   }

   private void sendConfirmationEmail (Order order) {
      String name = order.getCustomerName();
      String email = order.getCustomerEmail();

      // Send an email to the customer
   }
}
