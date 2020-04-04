package command;

import order.Order;
import order.products.Hamburger;

public class AddHamburgerCommand implements Command {
    private Order order;

    public AddHamburgerCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        if (order != null) {
            order.addProduct(new Hamburger());
        }
    }
}
