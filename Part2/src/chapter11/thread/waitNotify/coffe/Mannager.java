package chapter11.thread.waitNotify.coffe;

public class Mannager implements Runnable{
    CoffeMachine coffeMachine;

    public Mannager(CoffeMachine coffeMachine) {
        this.coffeMachine = coffeMachine;
    }

    @Override
    public void run() {
        while (true){
            coffeMachine.fill();
        }
    }
}
