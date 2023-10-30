package chapter11.thread.waitNotify.coffe;

public class Customer implements Runnable{
    String name;
    CoffeMachine coffeMachine;

    public Customer(String name, CoffeMachine coffeMachine) {
        this.name = name;
        this.coffeMachine = coffeMachine;
    }


    @Override
    public void run() {
        while (true){
            coffeMachine.takeout(this);
        }
    }
}
