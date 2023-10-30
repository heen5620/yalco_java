package chapter11.thread.nhnThread;

public class Sender implements Runnable {
    final Pipe pipe;

    public Sender(Pipe pipe) {
        this.pipe = pipe;
    }

    public void run() {
        // pipe를 통해서 데이터를 전송한다.
        int data = 0;


        while (!pipe.isStop()) {
            pipe.send(data++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
