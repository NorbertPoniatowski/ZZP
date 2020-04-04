package order.products;

public class Soda extends Product {
    public Soda() {
        super(4);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        return obj instanceof Soda;
    }
}
