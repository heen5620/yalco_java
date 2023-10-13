package chpater7.ex1;

import javax.swing.Spring;

public class Button {
    private String name;
    private String mode;
    private int spaces;

    public enum Mode{
        Full("full light"), Medium("medium light"), Lower("Lower light");
        String indicator;
        Mode(String indicator) {
            this.indicator = indicator;}

        public String getIndicator(){
            return indicator;
        }
    }

    public Button(String name, String mode, int spaces) {
        this.name = name;
        this.mode = mode;
        this.spaces = spaces;
    }

    @Override
    public String toString() {
        return "Button{" +
                "name='" + name + '\'' +
                ", mode=" + mode +
                ", spaces=" + spaces +
                '}';
    }
}
