package chapter9.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class printNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("몇개의 숫자를 확인하겠습니까 : ");
        int loopingNumber = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= loopingNumber; i++) {
            System.out.printf("%d 번째 숫자를 입력해주세요 : ", i);
            list.add(sc.nextInt());
        }

        Predicate<Integer> isEven =  (x)-> x % 2 == 0;
        Predicate<Integer> isOdd = (x) -> x % 2 != 0;

        System.out.println("Even number");
        list.forEach(num -> {
            if(isEven.test(num)){
                System.out.println(num);
            }
        });

        System.out.println("Odd numbner");
        list.forEach(num -> {
            if(isOdd.test(num)){
                System.out.println(num);
            }
        });
    }
}
