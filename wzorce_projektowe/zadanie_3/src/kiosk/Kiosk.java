package kiosk;

import command.*;
import order.Order;
import order.discounts.FirstDiscount;
import order.discounts.SecondDiscount;
import kitchen.Observer;

import java.util.LinkedList;
import java.util.List;

public class Kiosk implements Subject {
    private List<Observer> observers = new LinkedList<>();
    private Order order = null;
    private AddCheeseburgerCommand addCheeseburgerCommand = null;
    private RemoveCheeseburgerCommand removeCheeseburgerCommand = null;
    private AddHamburgerCommand addHamburgerCommand = null;
    private RemoveHamburgerCommand removeHamburgerCommand = null;
    private AddFriesCommand addFriesCommand = null;
    private RemoveFriesCommand removeFriesCommand = null;
    private AddSodaCommand addSodaCommand = null;
    private RemoveSodaCommand removeSodaCommand = null;

    public void startOrder() {
        order = new Order();
        addCheeseburgerCommand = new AddCheeseburgerCommand(order);
        removeCheeseburgerCommand = new RemoveCheeseburgerCommand(order);
        addHamburgerCommand = new AddHamburgerCommand(order);
        removeHamburgerCommand = new RemoveHamburgerCommand(order);
        addFriesCommand = new AddFriesCommand(order);
        removeFriesCommand = new RemoveFriesCommand(order);
        addSodaCommand = new AddSodaCommand(order);
        removeSodaCommand = new RemoveSodaCommand(order);

    }

    public void chooseFirstDiscount() {
        order.chooseDiscount(new FirstDiscount());
    }

    public void chooseSecondDiscount() {
        order.chooseDiscount(new SecondDiscount());
    }

    public void addCheeseburger() {
        addCheeseburgerCommand.execute();
    }

    public void removeCheeseburger() {
        removeCheeseburgerCommand.execute();
    }

    public void addHamburger() {
        addHamburgerCommand.execute();
    }

    public void removeHamburger() {
        removeHamburgerCommand.execute();
    }

    public void addFries() {
        addFriesCommand.execute();
    }

    public void removeFries() {
        removeFriesCommand.execute();
    }

    public void addSoda() {
        addSodaCommand.execute();
    }

    public void removeSoda() {
        removeSodaCommand.execute();
    }

    public void finishOrder() {
        notifyObservers();
        order = null;
        addCheeseburgerCommand = null;
        removeCheeseburgerCommand = null;
        addHamburgerCommand = null;
        removeHamburgerCommand = null;
        addFriesCommand = null;
        removeFriesCommand = null;
        addSodaCommand = null;
        removeSodaCommand = null;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }
}