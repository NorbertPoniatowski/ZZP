package command;

import order.Order;
import order.products.Soda;

public class AddSodaCommand implements Command {
    private Order order;

    public AddSodaCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.addProduct(new Soda());
        }
    }
}
