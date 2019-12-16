package com.tbryant.iodemo;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 9090);
            while(true){
                Scanner scanner = new Scanner(System.in);
                String next = scanner.next();
                clientSocket.getOutputStream().write(next.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
