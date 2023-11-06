package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class Quiz04 {
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
            System.err.println("Port번호가 올바르지 않다");
            System.exit(1);
        }

        try {
            Socket socket = new Socket(host, port);
            System.out.println("서버에 연결되었습니다.");

            OutputStream ouput = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String line = br.readLine();
                if (line.equals("exit")) {
                    break;
                }

                ouput.write(line.getBytes());
                ouput.write("\n".getBytes());
                ouput.flush();
            }
            socket.close();

        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
