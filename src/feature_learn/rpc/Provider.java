package feature_learn.rpc;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务提供者，提供service的具体实现内容
 */
public class Provider {
    public static void export(final Object service, int port) throws Exception {
        //服务校验
        if (service == null) {
            throw new IllegalArgumentException("service must not be null");
        }
        //端口校验
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port:" + port + "a valid port must between 0 and 65535");
        }
        //向操作系统注册服务
        ServerSocket serverSocket = new ServerSocket(port);
        //循环启动监听
        while (true) {
            Socket socket = serverSocket.accept();
            //开启独立的线程处理服务调用
            new ServerThread(socket, service).start();
        }
    }

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        export(service, 1234);
    }
}