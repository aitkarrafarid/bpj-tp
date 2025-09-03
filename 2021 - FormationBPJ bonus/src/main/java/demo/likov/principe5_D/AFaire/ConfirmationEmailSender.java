package demo.likov.principe5_D.AFaire;

import demo.likov.Order;

public class ConfirmationEmailSender implements MailSender {
   @Override
   public void sendConfirmationEmail (Order order) {
      String name = order.getCustomerName();
      String email = order.getCustomerEmail();

      // Send an email to the customer
   }
}
