package order.discounts;

import order.products.Product;
import order.products.Soda;

import java.util.List;

public class SecondDiscount implements DiscountStrategy {
    @Override
    public float calculateDiscount(List<Product> products) {
        float totalPrice = 0;
        boolean sodaOrdered = false;
        float sodaPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
            if (product instanceof Soda) {
                sodaOrdered = true;
                sodaPrice = product.getPrice();
            }
        }
        if (sodaOrdered && totalPrice > 30) {
            return sodaPrice - 0.01f;
        }
        return 0;
    }
}
