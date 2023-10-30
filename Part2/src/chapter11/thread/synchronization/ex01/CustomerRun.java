package chapter11.thread.synchronization.ex01;

public class CustomerRun implements Runnable{

    String name;
    ATM atmUse;
    int needed;

    public CustomerRun(String name, ATM atmUse, int needed) {
        this.name = name;
        this.atmUse = atmUse;
        this.needed = needed;
    }

    @Override
    public void run() {
        while (atmUse.getBalance() > needed){
            atmUse.withDraw(name, needed);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
