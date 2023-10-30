package chapter11.thread.Mart;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Store {
    private Semaphore shopMax;
    private int product;
    private final int PRODUCT_MAX = 10;

    public Store() {
        this.shopMax = new Semaphore(5);
        this.product = PRODUCT_MAX;
    }

    public void enter() {
        try {
            shopMax.acquire();
            System.out.printf("손님이 입장 했습니다...%n");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void exit() {
        System.out.println("손님이 퇴장 했습니다..");
        shopMax.release();
    }

    /*
    //buyer가 찾는 상품이 없으면 이라는 조건을 걸어야됌. ex) List가 있으면
    1. buy메소드의 wait 조건은 buyer가 사려는 물건이 매대에 없어야, wait
    2. 그리고 매대에는 사과가 빠져있는데, 배를 사려는 사람도 wait해야 하는건가? 아니다 -> 그러면, 따로 따로 wait 조건? 을 걸어야 하는건가
    int random = ThreadLocalRandom.current().nextInt()
     */
    public synchronized void buy(Buyer buyer) {
        while (product == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("[%d] 💵 구매 완료! %s 구매함.%n", product, buyer.name);
        product--;
        notifyAll();
    }

    public synchronized void sell() {
        while (product >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("[현재 개수: %d] 매대가 비었다.%n", product);
        product = PRODUCT_MAX;
        System.out.printf("[현재 개수: %d] ✅ 물건을 채워넣었습니다.%n", product);
        notifyAll();
    }
}