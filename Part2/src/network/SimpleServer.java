package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {
    public static void main(String[] args) {
        final int port = 12345; // 사용할 포트 번호

        try {
            // 서버 소켓 생성
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("서버가 " + port + " 포트에서 대기 중...");

            while (true) {
                // 클라이언트 연결 대기
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다.");

                // 클라이언트와 통신하기 위한 입출력 스트림 설정
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                Scanner in = new Scanner(clientSocket.getInputStream());

                // 클라이언트로부터 메시지를 받아 에코
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println("클라이언트로부터 받은 메시지: " + message);
                    out.println("서버에서 에코한 메시지: " + message);
                }

                // 클라이언트와의 연결 종료
                clientSocket.close();
                System.out.println("클라이언트와의 연결을 종료했습니다.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
