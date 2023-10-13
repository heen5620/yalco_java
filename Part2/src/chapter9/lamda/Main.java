package chapter9.lamda;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer() {
            @Override
            public void print() {
                System.out.println("NO lamda");
            }
        };

        Printer printer1 = () -> {
            System.out.println("인자, No lamda");
        };

        Printer printer2 = () -> System.out.println("반환 없을시 {} 생략 가능");


        Printer printer3 = () -> {
            System.out.println("코드가");
            System.out.println("여러줄이면 {}가 필요하다,");
        };

        for (var p : new Printer[] {printer, printer1, printer2, printer3}) {
            p.print();
        }


        Add add = new Add() {
            @Override
            public int add(int a, int b) {
                return a + b; // No lamda
            }
        };

        Add add2 = (x,y) -> x + y;

        for (var i :  new Add[] {add, add2}){
            System.out.println(add.add(1,2));
        }

        add.print();
        Add.printStatic();



        DoubleParam add4 = (x,y) -> x + y;

        DoubleParam multi = (x,y) -> {
            int multiSum = x * y;
            System.out.println(x + " * " + y + " = " + multiSum);
            return multiSum;
        };

        int added = add4.func(2, 3);
        int multiple = multi.func(2, 3);
        System.out.println(added);
        System.out.println(multiple);
    }




}