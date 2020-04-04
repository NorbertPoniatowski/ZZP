package facade;

import components.Door;
import components.Heater;
import components.Light;
import components.decorators.EntryGateDecorator;
import interfaces.IDoorControl;
import interfaces.IHeatControl;
import interfaces.ILightControl;

import java.util.logging.Logger;

public class Facade implements IFacade {
    private static final Logger LOGGER = Logger.getLogger(Facade.class.getName());
    private IDoorControl entryGate = new EntryGateDecorator(new Door(), new Light());
    private IDoorControl garageDoor = new Door();
    private ILightControl garageLight = new Light();
    private IHeatControl centralHeating = new Heater();

    @Override
    public void arriveAtHouse() {
        LOGGER.info("Arrive at house");
        centralHeating.setTemperature(22.0f);
        ((EntryGateDecorator)entryGate).turnOnLight();
        garageLight.turnOn();
        entryGate.unlock();
        entryGate.open();
        garageDoor.unlock();
        garageDoor.open();
        entryGate.close();
        entryGate.lock();
        ((EntryGateDecorator)entryGate).turnOffLight();
        garageDoor.close();
        garageDoor.lock();
        garageLight.turnOff();
    }

    @Override
    public void lockAllDoors() {
        LOGGER.info("Lock all doors");
        entryGate.lock();
        garageDoor.lock();
    }

    @Override
    public void leaveHouse() {
        LOGGER.info("Leave house");
        centralHeating.turnOff();
        garageLight.turnOn();
        ((EntryGateDecorator)entryGate).turnOnLight();
        garageDoor.unlock();
        garageDoor.open();
        entryGate.unlock();
        entryGate.open();
        garageDoor.close();
        garageDoor.lock();
        garageLight.turnOff();
        entryGate.close();
        entryGate.lock();
        ((EntryGateDecorator)entryGate).turnOffLight();
    }
}
