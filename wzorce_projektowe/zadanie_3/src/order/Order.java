package order;

import order.discounts.DiscountStrategy;
import order.products.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class Order {
    private static final Logger LOGGER = Logger.getLogger(Order.class.getName());
    private List<Product> products = new LinkedList<>();
    private float totalPrice = 0;
    private DiscountStrategy discountStrategy = null;

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        totalPrice -= product.getPrice();
    }

    public void chooseDiscount(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    private float calculateDiscount() {
        return discountStrategy.calculateDiscount(products);
    }

    public void show() {
        if (discountStrategy != null) {
            LOGGER.info("Products: " + products + "\nprice: " + (totalPrice - calculateDiscount()));
        } else {
            LOGGER.info("Products: " + products + "\nprice: " + totalPrice);
        }
    }
}
