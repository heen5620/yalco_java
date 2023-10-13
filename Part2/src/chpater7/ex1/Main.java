package chpater7.ex1;

public class Main {
    public static void main(String[] args) {
        Button button = new Button("엔터", Button.Mode.Full.getIndicator(), 3);
        System.out.println(button);
        System.out.println(Button.Mode.Full.getIndicator());
    }
}
