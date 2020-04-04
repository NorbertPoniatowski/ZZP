package order.products;

public class Hamburger extends Product {
    public Hamburger() {
        super(10);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        return obj instanceof Hamburger;
    }
}
