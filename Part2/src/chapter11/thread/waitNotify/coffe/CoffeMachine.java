package chapter11.thread.waitNotify.coffe;


public class CoffeMachine {
    final int CUP_MAX = 10;
    int cups = CUP_MAX;

    synchronized public void takeout(Customer customer){
        if(cups < 1){
            System.out.printf(
                    "[%d] 😭 %s 커피 없음%n", cups, customer.name
            );
        }else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf(
                    "[%d] ☕️ %s 테이크아웃%n", cups, customer.name
            );
            cups--;
        }

        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized public void fill(){
        if(cups > 3){
            System.out.printf(
                    "[%d] 👌 재고 여유 있음...%n", cups
            );
        }else{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf(
                    "[%d] ✅ 커피 채워넣음%n", cups
            );
            cups = CUP_MAX;
        }
        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
