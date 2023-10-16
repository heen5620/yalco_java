package chapter9.lamda;

import java.util.*;
import java.util.function.Consumer;

public class stringsort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();


        Scanner sc = new Scanner(System.in);
        System.out.print("반복횟수를 입력 : ");
        int count = sc.nextInt();

        for (int i = 1; i <= count; i++) {
            list.add(sc.nextInt());
        }

        Consumer<Integer> method = x -> {
            System.out.print(x +" ");
        };

        list.forEach(method);
    }
}
