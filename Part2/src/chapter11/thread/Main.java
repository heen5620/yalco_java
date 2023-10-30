package chapter11.thread;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread1(); //thread 상속 방식
        Thread thread2 = new Thread(new MyRunnable()); // Runnable 구현 방식

        // Runnable 익명 클래스 방식
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.print(3);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        for(int i=0; i< 20; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print('M');
        }

    }
}
