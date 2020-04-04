package components;

import components.enums.HeatingState;
import interfaces.IHeatControl;

import java.util.logging.Logger;

public class Heater implements IHeatControl {
    private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());
    private HeatingState state = HeatingState.OFF;
    private float constantTemperature = 0;

    private void setState(HeatingState state) {
        this.state = state;
        LOGGER.info("Heater state: " + state);
    }

    private void setConstantTemperature(float constantTemperature) {
        setState(HeatingState.ON);
        this.constantTemperature = constantTemperature;
        LOGGER.info("Heater temperature set to: " + constantTemperature);
    }

    @Override
    public void turnOn() {
        setState(HeatingState.ON);
    }

    @Override
    public void turnOff() {
        setState(HeatingState.OFF);
    }

    @Override
    public void setTemperature(float temperature) {
        setConstantTemperature(temperature);
    }
}
