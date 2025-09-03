package demo.likov.principe1_S.AFaire;

import demo.likov.Order;

public class OrderProcessor {
   public void process (Order order) {

      MySQLOrderRepository repository = new MySQLOrderRepository();
      ConfirmationEmailSender mailSender = new ConfirmationEmailSender();

      if (order.isValid() && repository.save(order)) {
         mailSender.sendConfirmationEmail(order);
      }
   }
}
