package order.discounts;

import order.products.Cheeseburger;
import order.products.Fries;
import order.products.Hamburger;
import order.products.Product;

import java.util.List;

public class FirstDiscount implements DiscountStrategy {
    @Override
    public float calculateDiscount(List<Product> products) {
        float priceOfCheapestProduct = 1<<30;
        int numberOfFries = 0;
        int numberOfCheeseburgers = 0;
        int numberOfHamburgers = 0;
        for (Product product : products) {
            priceOfCheapestProduct = Math.min(priceOfCheapestProduct, product.getPrice());
            if (product instanceof Fries) {
                numberOfFries++;
            } else if (product instanceof Hamburger) {
                numberOfHamburgers++;
            } else if (product instanceof Cheeseburger) {
                numberOfCheeseburgers++;
            }
        }
        if (numberOfCheeseburgers > 2 || numberOfFries > 2 || numberOfHamburgers > 2) {
            return priceOfCheapestProduct * 0.1f;
        }
        return 0;
    }
}
