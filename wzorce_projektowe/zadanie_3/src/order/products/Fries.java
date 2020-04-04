package order.products;

public class Fries extends Product {
    public Fries() {
        super(8);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        return obj instanceof Fries;
    }
}
