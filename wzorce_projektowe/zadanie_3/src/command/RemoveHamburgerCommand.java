package command;

import order.Order;
import order.products.Hamburger;

public class RemoveHamburgerCommand implements Command {
    private Order order;

    public RemoveHamburgerCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.removeProduct(new Hamburger());
        }
    }
}
