package chapter11.thread.nhnThread;

/*
1초마다 횟수를 1씩 증가하는 Counter class를 정의하고 실행 후 출력.
 */

public class quiz01 implements Runnable{
    private int count;
    private String name;
    public static void main(String[] args) {
        quiz01 quiz = new quiz01();
        quiz.run();
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            name = "count";
            try {
                Thread.sleep(1000);
                System.out.println(name +" :"+ this.count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(this.count == 10){
                break;
            }
            this.count++;
        }
    }
}
