package kitchen;

import order.Order;

public interface Observer {
    void update(Order order);
}
