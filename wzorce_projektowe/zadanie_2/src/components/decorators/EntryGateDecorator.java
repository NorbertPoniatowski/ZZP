package components.decorators;

import interfaces.IDoorControl;
import interfaces.ILightControl;

public class EntryGateDecorator implements IDoorControl {
    private IDoorControl decorated;
    private ILightControl gateLight;

    public EntryGateDecorator(IDoorControl decorated, ILightControl lightControl) {
        this.decorated = decorated;
        this.gateLight = lightControl;
    }

    @Override
    public boolean open() {
        return decorated.open();
    }

    @Override
    public boolean close() {
        return decorated.close();
    }

    @Override
    public void lock() {
        decorated.lock();
    }

    @Override
    public void unlock() {
        decorated.unlock();
    }

    public void turnOnLight() {
        gateLight.turnOn();
    }

    public void turnOffLight() {
        gateLight.turnOff();
    }
}
