package chapter11.thread.synchronization.ex02;

public class Cache1 {
   static boolean stop = false;

    public static void main(String[] args) {
        new Thread(
                () -> {
                    int i = 0;
                    while (!stop) {
                        i++;
                        System.out.println(i);
                    }
                    System.out.println("쓰레드 종료");
                }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stop = true;
    }
}
