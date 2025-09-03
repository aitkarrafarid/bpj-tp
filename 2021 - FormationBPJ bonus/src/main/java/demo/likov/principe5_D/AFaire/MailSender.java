package demo.likov.principe5_D.AFaire;

import demo.likov.Order;

public interface MailSender {
   abstract public void sendConfirmationEmail (Order order);
}
