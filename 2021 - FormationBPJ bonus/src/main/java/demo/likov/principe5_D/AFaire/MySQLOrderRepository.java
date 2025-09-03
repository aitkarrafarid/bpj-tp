package demo.likov.principe5_D.AFaire;

import demo.likov.MySqlConnection;
import demo.likov.Order;

public class MySQLOrderRepository implements OrderRepository {
   @Override
   public boolean save (Order order) {
      MySqlConnection connection = new MySqlConnection("database.url");
      // Save the order in the database

      return true;
   }
}
