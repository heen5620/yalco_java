package chapter11.thread.nhnThread;

public class Pipe {
    private int data;
    private boolean empty = true;

    private boolean isStop = false;

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }

    public synchronized int receive() {
        // 파이프가 비워져 있는 동안 기다린다.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int receivedData = this.data;
        empty = true;

        notify();

        return receivedData;
    }

    public synchronized void send(int data) {
        // 파이프가 채워져 있는 동안 기다린다.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        this.data = data;
        empty = false;

        notify();
    }


}

