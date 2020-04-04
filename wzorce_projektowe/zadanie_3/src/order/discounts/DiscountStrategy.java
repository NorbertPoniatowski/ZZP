package order.discounts;

import order.products.Product;

import java.util.List;

public interface DiscountStrategy {
    float calculateDiscount(List<Product> products);
}
