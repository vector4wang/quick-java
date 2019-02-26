package com.feature.learn.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * @author vector
 * @date: 2019/1/23 0023 14:51
 */
public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8919;
        try {
            Socket socket = new Socket(host, port);
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("Hello From Client");
            writer.flush();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
