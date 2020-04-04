package command;

import order.Order;
import order.products.Cheeseburger;

public class AddProductCommand implements Command {
    private Order order;

    public AddProductCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.addProduct(new Cheeseburger());
        }
    }
}
