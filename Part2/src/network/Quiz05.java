package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Quiz05 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        if (args.length > 0) {
            host = args[0];
        }

        try {
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException ignore) {
            System.err.println("Port번호가 올바르지 않습니다.");
            System.exit(1);
        }

        try {
            Socket socket = new Socket(host, port);
            System.out.println("서버에 연결되었습니다.");

            BufferedInputStream input = new BufferedInputStream(socket.getInputStream());

            int readLength;
            byte[] buffer = new byte[2048];

            while ((readLength = input.read(buffer)) > 0) {
                String recieveData = new String(buffer, 0, readLength).trim();
                System.out.println("서버로 받은 메시지 : " + recieveData);

                if (recieveData.equals("exit")) {
                    break;
                }
            }
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
