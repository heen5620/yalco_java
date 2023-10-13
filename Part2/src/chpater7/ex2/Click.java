package chpater7.ex2;

import java.util.Objects;

public class Click {
    int x;
    int y;
    int timeStamp;

    public Click(int x, int y, int timeStamp) {
        this.x = x;
        this.y = y;
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Click)) return false;
        return this.x == ((Click) o).x && this.y == ((Click) o).y;
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }


}
