package chapter9.stream;

import java.util.*;
import java.util.stream.*;

public class Ex01 {
    public static void main(String[] args) {
        List<Integer> int0To9 = new ArrayList<>(
                Arrays.asList(5, 2, 0, 8, 4, 1, 7, 9, 3, 6)
        );

        String result = int0To9.stream()
                .filter(x->x % 2 == 1)
                .sorted(Integer::compare)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println(result);
    }
}