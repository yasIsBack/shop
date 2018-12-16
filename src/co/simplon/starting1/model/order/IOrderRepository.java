package co.simplon.starting1.model.order;

import java.util.List;

public interface IOrderRepository {

    void saveOrder(Order cmd);

    Order findById(String id);

    void deleteOrder(Order cmd);

    List<Order> listAllOrder();

}
