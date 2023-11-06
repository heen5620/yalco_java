package network;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Quiz03 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        if(args.length > 0){
            host = args[0];
        }
        try {
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.err.println("Port번호가 올바르지 않다");
            System.exit(1);
        }

        try {
            Socket socket = new Socket(host, port);
            System.out.println("서버에 연결되었습니다.");
            socket.getOutputStream().write("HelloWorld".getBytes());

            socket.close();
        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할수 없습니다.");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
