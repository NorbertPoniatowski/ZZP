package components.decorators;

import components.Light;
import components.enums.Color;
import interfaces.ILightControl;

import java.util.logging.Logger;

public class HomeCinemaLightDecorator implements ILightControl {
    private static final Logger LOGGER = Logger.getLogger(HomeCinemaLightDecorator.class.getName());
    private ILightControl decorated;

    public HomeCinemaLightDecorator(ILightControl decorated) {
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

    public void setColor(Color color) {
        LOGGER.info("Color set to: " + color);
    }

    public void turnOnDynamicLight() {
        LOGGER.info("Dynamic light on");
    }

    public void turnOffDynamicLight() {
        LOGGER.info("Dynamic light off");
    }
}
