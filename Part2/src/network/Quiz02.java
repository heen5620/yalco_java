package network;

import java.io.IOException;
import java.net.Socket;

public class Quiz02 {
    public static void main(String[] args) {
        int startPort = 0;
        int endPort = 65535;

        if (args.length < 2) {
            System.err.println("검색할 포트의 범위 지정이 필요합니다");
        }

        try {
            startPort = Integer.parseInt(args[0]);
            endPort = Integer.parseInt(args[1]);

            if (endPort < startPort) {
                int temp = startPort;
                startPort = endPort;
                endPort = temp;
            }
        } catch (NumberFormatException e) {
            System.err.println("포트 번호가 올바르지 않습니다");
        }
        for (int i = startPort; i < endPort; i++) {
            try (Socket socket = new Socket("localhost", i)) {
                System.out.println("Port" + i + " 열려있습니다.");
            } catch (IOException e) {

            }
        }
    }

}
