import kiosk.Kiosk;
import kitchen.Kitchen;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk1 = new Kiosk();
        Kiosk kiosk2 = new Kiosk();
        Kitchen kitchen = new Kitchen();
        kiosk1.register(kitchen);
        kiosk2.register(kitchen);

        kiosk1.startOrder();

        kiosk1.addCheeseburger();
        kiosk1.addHamburger();
        kiosk1.addHamburger();
        kiosk1.addHamburger();
        kiosk1.addFries();
        kiosk1.addSoda();
        kiosk1.chooseFirstDiscount();

        kiosk1.finishOrder();

        kiosk2.startOrder();

        kiosk2.addCheeseburger();
        kiosk2.removeCheeseburger();
        kiosk2.addHamburger();
        kiosk2.addHamburger();
        kiosk2.addHamburger();
        kiosk2.addFries();
        kiosk2.addSoda();
        kiosk2.chooseSecondDiscount();

        kiosk2.finishOrder();
    }
}
