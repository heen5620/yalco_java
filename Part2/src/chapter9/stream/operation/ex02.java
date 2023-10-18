package chapter9.stream.operation;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.*;

public class ex02 {
    public static void main(String[] args) {
        String[] names = {
                "강백호", "서태웅", "채치수", "송태섭", "정대만",
                "윤대협", "변덕규", "황태산", "안영수", "허태환",
                "이정환", "전호장", "신준섭", "고민구 ", "홍익현",
                "정우성", "신현철", "이명헌", "최동오", "정성구"
        };

        Stream<String> nameStream = Arrays.stream(names);

        Random random = new Random();
        random.setSeed(4); // 균일한 결과를 위해 지정된 시드값
        var people = nameStream
                .map(name -> new Person(
                        name,
                        random.nextInt(35 - 18) + 18,
                        random.nextDouble() * (190 -160) + 160,
                        random.nextBoolean()
                ))
//                .sorted()
//                .sorted((p1, p2) -> p1.getHeight() > p2.getHeight() ? 1 : -1)
                .sorted((p1, p2) -> Boolean.compare(p1.isMarried(), p2.isMarried()))
                .collect(Collectors.toList());

        var peopleLastNameSet = people.stream()
                .map(p->p.getName().charAt(0))
                .collect(Collectors.toCollection(TreeSet::new));

        var peopleMarried = people.stream()
                .collect(Collectors.groupingBy(Person::isMarried));
        var ismarried = peopleMarried.get(true);

        //키가 180이상인 사람들
        var peopleByHeight = people.stream()
                .collect(Collectors.groupingBy(
                        p -> ((int) p.getHeight() / 10) * 10
                ));
        var over180s = peopleByHeight.get(180);

        IntSummaryStatistics ageStats = people.stream()
                .map(Person::getAge)
                .collect(Collectors.summarizingInt(Integer::intValue));

    }
}
