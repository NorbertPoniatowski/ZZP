package command;

import order.Order;
import order.products.Soda;

public class RemoveSodaCommand implements Command {
    private Order order;

    public RemoveSodaCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.removeProduct(new Soda());
        }
    }
}
