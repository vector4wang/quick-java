package com.feature.learn.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
    private Object service;

    public ServerThread(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            //获取服务调用的方法
            String methodName = input.readUTF();
            //获取服务调用的参数类型
            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
            //获取服务调用的参数
            Object[] arguments = (Object[]) input.readObject();
            //获取输出响应结果流
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            try {
                Method method;
                //利用反射调用服务
                method = service.getClass().getMethod(methodName, parameterTypes);
                Object result = method.invoke(service, arguments);
                //返回调用结果
                output.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            }

            input.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}