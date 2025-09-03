package demo.likov.principe5_D.AFaire;

import demo.likov.Order;

/**
 * Nous avons fait le travail préparatoire pour que notre OrderProcessorclasse repose, non sur des détails concrets, 
 * mais sur des abstractions. 
 * Nous changeons en ajoutant nos dépendances au constructeur de classe
 */
public class OrderProcessor {

   private MailSender mailSender;
   private OrderRepository repository;

   public OrderProcessor(MailSender mailSender, OrderRepository repository) {
      this.mailSender = mailSender;
      this.repository = repository;
   }

   public void process (Order order) {
      if (order.isValid() && repository.save(order)) {
         mailSender.sendConfirmationEmail(order);
      }
   }
}
