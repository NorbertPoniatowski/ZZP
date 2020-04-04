package command;

import order.Order;
import order.products.Cheeseburger;

public class AddCheeseburgerCommand implements Command {
    private Order order;

    public AddCheeseburgerCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.addProduct(new Cheeseburger());
        }
    }
}
