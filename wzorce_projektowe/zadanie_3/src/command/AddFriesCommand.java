package command;

import order.Order;
import order.products.Fries;

public class AddFriesCommand implements Command {
    private Order order;

    public AddFriesCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.addProduct(new Fries());
        }
    }
}
