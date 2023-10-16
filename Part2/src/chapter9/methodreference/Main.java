package chapter9.methodreference;

import java.util.TreeSet;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        //  클래스의 클래스 메소드에 인자 적용하여 실행
        Function<Integer, String> intToStrLD = String::valueOf;
        System.out.println(intToStrLD.apply(13));

        UnaryOperator<String> toLowerCase = String::toLowerCase;
        System.out.println(toLowerCase.apply("GOrila"));

        Function<String, Button> strToButton = Button::new;
        strToButton.apply("Dog");

        BiFunction<String, String, Button> twoPramToButton = Button::new;
        Button by = twoPramToButton.apply("고양이", "야옹야옹");
        by.onClick();


        System.out.println("인스턴스 메소드 참조");
        Runnable catCryD = by::onClick;
        catCryD.run();

        //  💡 임의의 인스턴스의 메소드 참조
        TreeSet<String> treeSetLD = new TreeSet<>((s1, s2) -> s1.compareTo(s2));
        TreeSet<String> treeSetMD = new TreeSet<>(String::compareTo);
        treeSetMD.add("b");
        treeSetMD.add("a");
        treeSetMD.add("c");

        treeSetMD.comparator();
    }
}
