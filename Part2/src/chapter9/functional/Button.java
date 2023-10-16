package chapter9.functional;

import java.util.BitSet;

public class Button {
    private String text;
    public Button(String text){
        this.text = text;
    }

    public String getText() {return text;}

    public Runnable onClickListener;

    public void setOnClickListener(Runnable onClickListener){
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        onClickListener.run();
    }
}
