package demo.likov.principe1_S.AFaire;

import demo.likov.Order;

public class ConfirmationEmailSender {
   public void sendConfirmationEmail (Order order) {
      String name = order.getCustomerName();
      String email = order.getCustomerEmail();

      // Send an email to the customer
   }
}
