package unit4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessingGame {
    static void playGame() throws IOException {
        int computersNumber;
        int userGuessNumber;
        int guessCount = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computersNumber = (int) (100 * Math.random()) + 1;
        System.out.println();

        System.out.println("첫 번째 추측은 무엇입니까?");
        while (true){
            userGuessNumber = Integer.parseInt(br.readLine());
           guessCount++;
           if(userGuessNumber == computersNumber){
               System.out.println("다음" + guessCount
               + " 번의 추측으로 맞췄네요! 나의 숫자는 " + computersNumber);
               break;
           }
           if(guessCount == 6){
               System.out.println("6번의 추측으로 숫자를 얻지 못했군요!");
               System.out.println("게임에서 졌습니다. 나의 숫자는 " + computersNumber);
               break;
           }

            if (userGuessNumber < computersNumber) {
                System.out.println("이는 너무 낮습니다. 다시 시도하세요");
            }
            else if(userGuessNumber > computersNumber){
                System.out.println("이는 너무 높습니다 다시 시도하세요");
            }
        }
        System.out.println();

    }

    static void doTimes(Runnable task, int repCount) {
        for (int i = 0; i < repCount; i++) {
            task.run();
        }
    }


    public static void main(String[] args) throws IOException {
//        doTimes(() -> System.out.println("Hello world"), 10);
        doTimes(() -> {
            int count = 5 + (int) (21 * Math.random());
            for (int i = 1; i <= count; i++) {
                System.out.println(i + " ");
            }
            System.out.println();
        }, 5);
    }
}
