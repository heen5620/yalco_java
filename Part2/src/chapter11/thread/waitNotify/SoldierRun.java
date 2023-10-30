package chapter11.thread.waitNotify;

public class SoldierRun implements Runnable{
    String title;
    PhoneBooth phoneBooth;

    public SoldierRun(String title, PhoneBooth phoneBooth) {
        this.title = title;
        this.phoneBooth = phoneBooth;
    }

    @Override
    public void run() {
        while (true){
            phoneBooth.phonecCall(this);
        }
    }
}
