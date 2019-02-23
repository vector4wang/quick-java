package feature_learn.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author vector
 * @date: 2019/1/23 0023 14:54
 */
public class Server {
    public static void main(String[] args) {
        int port = 8919;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            Reader reader =new InputStreamReader(socket.getInputStream());
            char[] chars = new char[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(chars)) != -1) {
                sb.append(new String(chars, 0, len));
            }
            System.out.println("Receive from client msg = : " + sb);
            reader.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
