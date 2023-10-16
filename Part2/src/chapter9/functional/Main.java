package chapter9.functional;

import java.lang.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Runnable dogButtonFunc = () -> System.out.println("멍멍");
        Runnable catButtonFunc = () -> System.out.println("야옹");
        Runnable cowButtonFunc = () -> System.out.println("음메");

        dogButtonFunc.run();
        catButtonFunc.run();
        cowButtonFunc.run();

        System.out.println("\n- - - - -\n");

        Button dogButton = new Button("강아지");
        dogButton.setOnClickListener( () -> {
            System.out.println("------------");
            System.out.println(dogButton.getText() +"울음 소리 : 이중민 바보");
        });

        Button catButton = new Button("고양이");
        catButton.setOnClickListener(() -> {
            System.out.println("- - - - -");
            System.out.println(catButton.getText() + " 울음소리: 야옹야옹");
            System.out.println("- - - - -");
        });

        dogButton.onClick();
        catButton.onClick();

        Supplier<String> appName = () -> "알콜오피스";
        Supplier<Double> rand = () -> Math.random() * 10;
        Supplier<Boolean> boo = () -> Math.random() > 0.4;

        var sup1 = appName.get();
        var sup2 = rand.get();
        var sup3 = boo.get();


        System.out.println("\n- - - - -\n");

        Consumer<Integer> sayOddEven = i -> System.out.printf(
                "%d은 %c수입니다.%n", i, "짝홀".charAt(i % 2)
        );

        Consumer<Button> clickButton = b -> b.onClick();

        BiConsumer<Button, Integer> clickButtonNTimes = (b, n) -> {
            for (var i = 0; i < n; i++) { b.onClick(); }
        };

        sayOddEven.accept(3);
        sayOddEven.accept(4);
        clickButton.accept(dogButton);
        clickButton.accept(catButton);
        clickButtonNTimes.accept(dogButton, 5);

        new ArrayList<>(
                Arrays.asList("하나", "둘", "삼")
        ).forEach(str-> System.out.println(str));

    }
}
