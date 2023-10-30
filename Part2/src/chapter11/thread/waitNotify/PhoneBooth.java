package chapter11.thread.waitNotify;

public class PhoneBooth {
    synchronized public void phonecCall (SoldierRun soldier){
        System.out.println(String.format("☎️ %s 전화 사용중...", soldier.title));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format(" \uD83D\uDC4D %s 전화 사용 완료", soldier.title));

        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
