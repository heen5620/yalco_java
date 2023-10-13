package chpater7.ex2;

public class Main {
    public static void main(String[] args) {
        Click click = new Click(123, 456, 123123);
        Click click1 = new Click(123, 456, 123123);
        Click click2 = new Click(123, 456, 534543);
        Click click3 = new Click(234, 567, 53634);

        boolean boo1 = click == click1;
        boolean bool2 = click1 == click2;
        boolean bool3 = click1 == click3;

        boolean aa = click.equals(click1);
        boolean a = click1.equals(click1);
        boolean b = click1.equals(click2);
        boolean c = click2.equals(click3);

        int hash0 = click.hashCode();
        int hash1 = click1.hashCode();
    }
}
