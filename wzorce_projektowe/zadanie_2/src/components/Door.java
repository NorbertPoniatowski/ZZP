package components;

import components.enums.DoorState;
import components.enums.LockState;
import interfaces.IDoorControl;

import java.util.logging.Logger;

public class Door implements IDoorControl {
    private static final Logger LOGGER = Logger.getLogger(Door.class.getName());
    private DoorState state = DoorState.CLOSED;
    private LockState lockState = LockState.UNLOCKED;

    private boolean setState(DoorState state) {
        if (lockState == LockState.UNLOCKED || state == DoorState.CLOSED) {
            this.state = state;
            LOGGER.info("Door state: " + state);
            return true;
        }
        LOGGER.info("Door locked");
        return false;
    }

    private void setLockState(LockState lockState) {
        this.lockState = lockState;
        LOGGER.info("Door lock state: " + state);
    }

    @Override
    public boolean open() {
        return setState(DoorState.OPENED);
    }

    @Override
    public boolean close() {
        return setState(DoorState.CLOSED);
    }

    @Override
    public void lock() {
        setLockState(LockState.LOCKED);
    }

    @Override
    public void unlock() {
        setLockState(LockState.UNLOCKED);
    }
}
