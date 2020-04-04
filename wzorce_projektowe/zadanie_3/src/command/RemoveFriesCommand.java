package command;

import order.Order;
import order.products.Fries;

public class RemoveFriesCommand implements Command {
    private Order order;

    public RemoveFriesCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.removeProduct(new Fries());
        }
    }
}
