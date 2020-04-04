package components.decorators;

import interfaces.ILightControl;

import java.util.logging.Logger;

public class GardenLightDecorator implements ILightControl {
    private static final Logger LOGGER = Logger.getLogger(GardenLightDecorator.class.getName());
    private ILightControl decorated;

    public GardenLightDecorator(ILightControl decorated) {
        this.decorated = decorated;
    }

    @Override
    public void turnOn() {
        decorated.turnOn();
    }

    @Override
    public void turnOff() {
        decorated.turnOff();
    }

    public void dimLight() {
        LOGGER.info("Light power level set to 50%");
    }
}
