package demo.likov.principe3_L.AFaire;

import demo.likov.Item;
import demo.likov.Order;

public class OrderStockValidator {

   public boolean isValid (Order order) {
      for (Item item : order.getItems()) {
         if (!item.isInStock()) {
            return false;
         }
      }

      return true;
   }
}
