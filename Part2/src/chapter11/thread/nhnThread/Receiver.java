package chapter11.thread.nhnThread;


import java.time.LocalDateTime;
public class Receiver implements Runnable {
    final Pipe pipe;
    int endData;

    public Receiver(Pipe pipe, int endData) {
        this.pipe = pipe;
        this.endData = endData;
    }

    public void run() {
        while (true) {
            int receivedData = pipe.receive();
            if (receivedData == endData) {
                break;
            } else {
                try {
                    Thread.sleep(1000);
                    System.out.println("[ " + LocalDateTime.now() + " ]" + " Data : "+receivedData);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        pipe.setStop(true);
    }
}
