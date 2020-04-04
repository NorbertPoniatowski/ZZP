package kitchen;

import order.Order;

public class Kitchen implements Observer {
    @Override
    public void update(Order order) {
        order.show();
    }
}
