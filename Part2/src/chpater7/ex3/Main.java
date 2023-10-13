package chpater7.ex3;

public class Main {
    public static void main(String[] args) {
        ShallowCopied shallowCopied = new ShallowCopied(
                "클릭들 1", 1, new int[] {1, 2, 3},
                new Click(12, 34),
                new Click[] { new Click(12, 34), new Click(56, 78) }
        );

        ShallowCopied clone2 = null;
        try {
            clone2 = (ShallowCopied) shallowCopied.clone();
        } catch (CloneNotSupportedException e) {
            //  오류가 나지 않으므로 실행되지 않음
            System.out.printf("⚠️ 복제중 오류 발생 : %s%n", shallowCopied);
        }

        shallowCopied.title = "제목 바뀜";
        shallowCopied.no = 2;
        //  ⚠️ 참조 타입들은 완전히 복사되지 않음 (주소만 복사)
        shallowCopied.numbers[0] = 0;
        shallowCopied.click.x = 99;
        shallowCopied.clicks[0].x = 99;
        shallowCopied.clicks[1].y = 0;
    }
}
