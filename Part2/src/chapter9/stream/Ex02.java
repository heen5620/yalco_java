package chapter9.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        //  💡 배열로부터 생성
        Integer[] integerAry = {1, 2, 3, 4, 5};
        Stream<Integer> fromArray = Arrays.stream(integerAry);
        var fromArray_Arr = fromArray.toArray();

        //  ⚠️ 런타임 에러
        //  - 스트림은 한 번 사용하면 끝 (흘러가버린 물)
        //var ifReuse = fromArray.toArray();


        Stream.Builder<Character> builder = Stream.builder();
        builder.accept('스');
        builder.accept('트');
        builder.accept('림');
        builder.accept('빌');
        builder.accept('더');
        Stream<Character> withBuilder = builder.build();
        var arr = withBuilder.toArray();


        Stream<Integer> withIter1 = Stream.iterate(0, i -> i + 2).limit(10);
        var withIter1Arr = withIter1.toArray();

        Stream<String> withIter2 = Stream.iterate("홀", s -> s + (s.endsWith("홀") ? "짝" : "홀"))
                .limit(8);

        var with_arr = withIter2.toArray();
        System.out.println(with_arr.toString());

        //  💡 파일로부터 생성
        //  - File I/O : 이후 배울 것
        Stream<String> fromFile;
        Path path = Paths.get("/Users/hyunmyeong/Desktop/yalco_java/Part2/src/chapter9/stream/turtle.txt");
        try {
            fromFile = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var fromFile_Arr = fromFile.toArray();

    }

}
