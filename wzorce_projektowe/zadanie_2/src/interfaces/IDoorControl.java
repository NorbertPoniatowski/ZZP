package interfaces;

public interface IDoorControl {
    boolean open();
    boolean close();
    void lock();
    void unlock();
}
