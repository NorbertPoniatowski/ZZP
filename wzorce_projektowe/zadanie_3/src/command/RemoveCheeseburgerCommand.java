package command;

import order.Order;
import order.products.Cheeseburger;

public class RemoveCheeseburgerCommand implements Command {
    private Order order;

    public RemoveCheeseburgerCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.removeProduct(new Cheeseburger());
        }
    }
}
