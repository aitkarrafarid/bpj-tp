package demo.likov.principe3_L.AFaire;

import demo.likov.Item;
import demo.likov.Order;

public class OrderStockAndPackValidator extends OrderStockValidator {

   @Override
   public boolean isValid (Order order) {
      for (Item item : order.getItems()) {
         if (!item.isInStock() || !item.isPacked()) {
            throw new IllegalStateException(
                  String.format("Order %d is not valid!", order.getId()));
         }
      }

      return true;
   }
}
