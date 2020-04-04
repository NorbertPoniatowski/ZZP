package order.products;

public class Cheeseburger extends Product {
    public Cheeseburger() {
        super(12);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        return obj instanceof Cheeseburger;
    }
}
