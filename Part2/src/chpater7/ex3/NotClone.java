package chpater7.ex3;

public class NotClone {
    String title;
    int no;

    int[] numbers;
    Click click;

    Click[] clicks;

    public NotClone(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
