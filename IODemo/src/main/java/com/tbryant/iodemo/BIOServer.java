package com.tbryant.iodemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    static byte[] bytes = new byte[1024];

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                System.out.println("BIO-----等待client连接");
                Socket clientSocket = serverSocket.accept();
                System.out.println("BIO-----client连接成功");
                System.out.println("BIO-----等待client发送数据");
                clientSocket.getInputStream().read(bytes);
                System.out.println("BIO-----server数据接收成功：" + new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
