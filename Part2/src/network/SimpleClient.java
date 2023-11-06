package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        final String serverAddress = "localhost"; // 서버 주소
        final int serverPort = 12345; // 서버 포트 번호

        try {
            // 서버에 연결
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("서버에 연결되었습니다.");

            // 클라이언트와 통신하기 위한 입출력 스트림 설정
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner userInput = new Scanner(System.in);

            while (true) {
                // 사용자로부터 메시지 입력
                System.out.print("메시지 입력 (끝내려면 'exit' 입력): ");
                String message = userInput.nextLine();

                // 서버로 메시지 전송
                out.println(message);

                // 서버로부터 에코된 메시지 받아 출력
                String response = in.nextLine();
                System.out.println("서버로부터 받은 메시지: " + response);

                // 사용자가 'exit'를 입력하면 클라이언트 종료
                if (message.equals("exit")) {
                    break;
                }
            }

            // 클라이언트 종료
            socket.close();
            System.out.println("클라이언트를 종료합니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

