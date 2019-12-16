package com.tbryant.iodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class NIOServer {
    static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    static List<SocketChannel> cachedSocketChannelList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8888);
            serverSocketChannel.bind(socketAddress);
            serverSocketChannel.configureBlocking(false);// 等待client连接的动作 设置为非阻塞
            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept();
                if (clientSocketChannel != null) {
                    System.out.println("NIO-----client连接成功");
                    clientSocketChannel.configureBlocking(false);// 等待client发送数据的动作 设置为非阻塞
                    cachedSocketChannelList.add(clientSocketChannel);
                }
                // 遍历缓存的连接，接收数据
                for (SocketChannel cachedSocketChannel : cachedSocketChannelList) {
                    int read = cachedSocketChannel.read(byteBuffer);
                    if (read > 0) {
                        byteBuffer.flip();// 写模式切换到读模式
                        byte[] bytes = new byte[read];
                        byteBuffer.get(bytes);
                        String content = new String(bytes);
                        System.out.println("NIO-----server数据接收成功：");
                        System.out.println(content);
                        byteBuffer.flip();// 读模式切换到写模式
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
