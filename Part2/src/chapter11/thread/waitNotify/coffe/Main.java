package chapter11.thread.waitNotify.coffe;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CoffeMachine coffeMachine = new CoffeMachine();

        Arrays.stream("철수,영희,돌준,병미,핫훈,짱은,밥태".split(","))
                .forEach(s -> new Thread(
                        new Customer(s, coffeMachine)
                ).start());

        new Thread(new Mannager(coffeMachine)).start();
    }
}
