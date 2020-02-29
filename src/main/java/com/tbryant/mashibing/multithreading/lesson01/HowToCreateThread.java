package com.tbryant.mashibing.multithreading.lesson01;

public class HowToCreateThread {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"---Hello MyThread");
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"---Hello MyRunnable");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRunnable()).start();
        // 第三种同第二种，只是语法不同
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"---Hello Lambda");
        }).start();
    }
}
