package local.kk.cli2048.base;

public abstract class BaseView extends Thread implements IView {
    private volatile boolean doneState = false;

    public synchronized boolean isDoneState() {
        return doneState;
    }

    public synchronized void close() {
        this.doneState = true;
    }

    protected abstract void show();

    public abstract void run();

    public void notifyUpdate() {
        this.show();
    }

}
