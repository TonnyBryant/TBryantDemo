package com.tbryant.customjedis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CustomSocket {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public CustomSocket(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 把拼接完的指令发送给redis
    public void send(String cmd) {
        try {
            outputStream.write(cmd.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 接收redis返回的数据
    public String read() {
        byte[] bytes = new byte[1024];// TODO 处理超过1024的返回数据
        int count = 0;
        try {
            count = inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes, 0, count);
    }
}
