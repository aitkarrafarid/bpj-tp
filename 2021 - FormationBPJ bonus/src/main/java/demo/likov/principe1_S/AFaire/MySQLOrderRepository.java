package demo.likov.principe1_S.AFaire;

import demo.likov.MySqlConnection;
import demo.likov.Order;

public class MySQLOrderRepository {
   public boolean save (Order order) {
      MySqlConnection connection = new MySqlConnection("database.url");
      // Save the order in the database

      return true;
   }
}
