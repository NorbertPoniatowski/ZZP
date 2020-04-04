package components;

import components.enums.LightState;
import interfaces.ILightControl;

import java.util.logging.Logger;

public class Light implements ILightControl {
    private static final Logger LOGGER = Logger.getLogger(Light.class.getName());
    private LightState state = LightState.OFF;

    private void setState(LightState state) {
        this.state = state;
        LOGGER.info("Light state: " + state);
    }

    @Override
    public void turnOn() {
        setState(LightState.ON);
    }

    @Override
    public void turnOff() {
        setState(LightState.OFF);
    }
}
