package chapter9.lamda;

@FunctionalInterface
public interface Add {

   default void print(){
       System.out.println("this is default method");
   }

  static void printStatic(){
       System.out.println("This is static method");
   }

    int add(int a, int b);
}
