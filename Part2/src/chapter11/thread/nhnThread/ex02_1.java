package chapter11.thread.nhnThread;

public class ex02_1 implements Runnable{
    String name;
    int count;

    public ex02_1(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                Thread.sleep(1000);
                System.out.println(this.name + " : " + count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.count++;
        }
    }
}

class Print{
    public static void main(String[] args) {
        Thread thread = new Thread(new ex02_1("CounterRunnable"));
        Thread thread2 = new Thread(new ex02_1("CounterRuunable2"));

        thread.start();
        thread2.start();
    }
}
