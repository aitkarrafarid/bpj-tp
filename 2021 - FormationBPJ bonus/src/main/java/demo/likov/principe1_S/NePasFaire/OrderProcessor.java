package demo.likov.principe1_S.NePasFaire;

import demo.likov.MySqlConnection;
import demo.likov.Order;

/**
 * Ce module pourrait changer pour trois raisons. Premi�rement, la logique de traitement des commandes peut changer. Deuxi�mement, 
 * la fa�on dont les commandes sont enregistr�es (type de base de donn�es) peut changer. Troisi�mement, la fa�on dont la confirmation est envoy�e peut changer 
 * (par exemple, supposons que nous devions envoyer un SMS plut�t qu'un e-mail).
 * Le principe de responsabilit� unique implique que les trois aspects de ce probl�me sont en r�alit� trois responsabilit�s diff�rentes. 
 * Cela signifie qu'ils doivent �tre dans des classes ou des modules diff�rents. Combiner plusieurs entit�s qui peuvent changer � des moments diff�rents 
 * et pour des raisons diff�rentes est consid�r� comme une mauvaise d�cision de conception.
 * 
 * Il est pr�f�rable de diviser ce module 'OrderProcessor' en trois modules distincts, chacun remplissant une seule fonction : 
 *    - ConfirmationEmailSender : gestion de l'envoie d'email
 *    - MySQLOrderRepository : les int�ractions avec la BdD
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
