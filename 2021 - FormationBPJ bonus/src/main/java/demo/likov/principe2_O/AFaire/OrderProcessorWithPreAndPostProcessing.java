package demo.likov.principe2_O.AFaire;

import demo.likov.Order;
import demo.likov.principe1_S.AFaire.OrderProcessor;

public class OrderProcessorWithPreAndPostProcessing extends OrderProcessor {

   @Override
   public void process (Order order) {
      beforeProcessing();
      super.process(order);
      afterProcessing();
   }

   private void beforeProcessing () {
      // Take some action before processing the order
   }

   private void afterProcessing () {
      // Take some action after processing the order
   }
}
