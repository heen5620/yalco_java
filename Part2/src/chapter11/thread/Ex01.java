package chapter11.thread;

public class Ex01 {
    public static void main(String[] args) {
        Thread tzrzanThread = new Thread(new TarzanRun(100));

        //thread 이름 붙이기
        tzrzanThread.setName("타잔송");

        tzrzanThread.start();
    }
}
