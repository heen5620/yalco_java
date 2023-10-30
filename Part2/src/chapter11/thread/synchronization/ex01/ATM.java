package chapter11.thread.synchronization.ex01;

import java.util.Random;

public class ATM {
    public int getBalance() {
        return balance;
    }

    private int balance = 0;

    public void addMoney(int amount) {
        balance += amount;
    }

    synchronized public void withDraw(String name, int amount) {
        if (balance < amount) return;
        System.out.printf(
                "💰 %s 인출 요청 (현 잔액 %d)%n",
                name, balance
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance -= amount;
        System.out.printf(
                "✅ %s 인출 완료 (현 잔액 %d)%n",
                name, balance
        );
    }
}

