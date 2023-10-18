package chapter9.stream.operation;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;

public class ex01 {
    public static void main(String[] args) {
        IntStream
                .range(1, 100)
                .filter(i -> i % 2 == 0)
                .skip(10) //맨 앞부터 주어진 개수만큼 스킵한다.
                .limit(10) // 10개만 뽑아옴. 주어진 개수만큼 가져옴
                .map(x -> x * 10)
                .forEach(System.out::println);

        System.out.println("\n- - - - -\n");

        String str1 = "Hello World! Welcome to the world of Java~";

        str1.chars().forEach(System.out::println);


        System.out.println("\n- - - - -\n");

        char str1MaxChar = (char) str1.chars()
//                .max() // OptionalInt 반환 - 이후 배울 것
                .min() // 변경해 볼 것
                .getAsInt();
        System.out.println("result : " + str1MaxChar);

        //  사용되는 모든 알파벳 문자들을 정렬하여 프린트
        str1.chars()
                .sorted()
                .distinct()
                .filter(Character::isLetter)
//                .filter(i -> (i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z'))
                .forEach(i -> System.out.print((char) i));

        System.out.println("\n - - - - \n");


        //대소문자 구분 없이 중복 제거 후 정렬, 쉼표로 구분
        String fromStr1 = str1.chars().boxed()
                //boxed를 사용해 Stream<Integer>로 변환
                .map(i -> String.valueOf((char) i.intValue()))
                .map(String::toUpperCase)
                .filter(s -> Character.isLetter(s.charAt(0)))
                .sorted()
                .distinct()
                .collect(joining(","));

        System.out.println(fromStr1);

        String string = "hello";


        System.out.println("\n- - - - -\n");

        //  💡 peek으로 중간 과정 체크하기
        //  - 스트림이나 요소를 변경하지 않고 특정 작업 수행 - 디버깅에 유용
        var oddSquaresR = IntStream.range(0, 10).boxed()
                .peek(i -> System.out.println("초기값: " + i))
                .filter(i -> i % 2 == 1)
                .peek(i -> System.out.println("홀수만: " + i))
                .map(i -> i * i)
                .peek(i -> System.out.println("제곱: " + i))
                .sorted((i1, i2) -> i1 < i2 ? 1 : -1)
                .peek(i -> System.out.println("역순: " + i))
                .map(String::valueOf)
                .collect(joining(", "));

        System.out.println(oddSquaresR);

        Integer[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean intsMatch = Arrays.stream(arrays)
                .allMatch(i -> i > 0);
        System.out.println("intsMatch : " + intsMatch);

        int intStream = IntStream.rangeClosed(0, 100)
                .filter(x -> (x % 2 == 1) && (x % 3 == 0))
                .sum();
        System.out.println("intStream : "+intStream);
        System.out.println("\n - - - - -\n");

        double doubleSum = DoubleStream.iterate(3.14, x -> x * 2)
                .limit(10)
                .peek(System.out::println)
                .sum();
        System.out.println("doubleSum : "+doubleSum);

        System.out.println("\n- - - - -\n");

        //  💡 reduce : 주어진 BiFunction으로 값을 접어나감
        //  seed 값이 없을 때 : Optional 반환 (빈 스트림일 수 있으므로)
        int intReduce = IntStream.range(1, 10)
                //.filter(i -> i % 2 == 1)
                .reduce((prev, curr) -> {
                    System.out.printf("prev: %d, cur: %d%n", prev, curr);
                    return prev * curr;
                })
                .getAsInt(); // 필요함 초기 값이 없는 경우 stream이 비어있는 상태에서 뱉는걸 방지하기 위해 Optional getAsInt()를 사용.

        System.out.println(intReduce);

        int intReduceWithSeed = IntStream.range(1, 10)
                .reduce(2, (prev, curr) -> prev * curr); //초기값이 2로 설정되어있으니 optional getAsInt() 사용x

        System.out.println(intReduceWithSeed);

        StringStat stringStat = "Hello World! Welcome to the world of Java~"
                .chars()
                .boxed()
                .distinct()
                .reduce(new StringStat(), (ss, i) -> {
                    ss.length++;
                    if(i>= 'A' && i<= 'Z') {ss.upperCases++;}
                    else if(i >= 'a' && i <= 'z') {ss.lowerCases++;}
                    else {ss.nonLetters++;}
                    return ss;
                },(ss1, ss2) -> ss1 //combinerm 병렬 연산,
                        //요소와 다른 타입을 반환하는 오버로드의 필수인자
                );

        IntStream intStream1 = new Random().ints(1, 46);
        Stream<String> lottoStream = intStream1
                .distinct()
                .limit(6)
                .sorted()
                .mapToObj(i -> i + ",");
        lottoStream.forEach(System.out::print);
    }

    //  내부 정적 클래스
    public static class StringStat {
        int length = 0;
        int upperCases = 0;
        int lowerCases = 0;
        int nonLetters = 0;
    }
}
