package chapter9.lamda;


import java.util.*;
import java.util.function.Predicate;

public class printNumber {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("진행 횟수 입력 : ");
        int count  = sc.nextInt();


        for (int i = 1; i <= count; i++) {
            System.out.printf("%d 번째 숫자 : ", i);
            list.add(sc.nextInt());
        }

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isOdd = x -> x % 2 != 0;

        System.out.println("Even number");
        list.forEach(num -> {
            if(isEven.test(num)){
                System.out.println(num);
            }
        });

        System.out.println("Odd num");
        list.forEach(num -> {
            if(isOdd.test(num)){
                System.out.println(num);
            }
        });
    }
}