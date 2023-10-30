package chapter11.thread.synchronization.ex01;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.addMoney(5000);

        Thread th1 = new Thread(new CustomerRun("철수", atm, 500));
        Thread th2 = new Thread(new CustomerRun("영희", atm, 300));
        Thread th3 = new Thread(new CustomerRun("재준", atm, 400));

        th1.start();
        th2.start();
        th3.start();
    }
}
