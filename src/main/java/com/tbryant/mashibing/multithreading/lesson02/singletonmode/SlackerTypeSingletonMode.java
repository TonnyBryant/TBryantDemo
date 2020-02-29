package com.tbryant.mashibing.multithreading.lesson02.singletonmode;

// 懒汉式单例模式
public class SlackerTypeSingletonMode {
    private static SlackerTypeSingletonMode INSTANCE;

    private SlackerTypeSingletonMode() {
    }

    // 不加synchronized线程不安全
    public static /*synchronized*/ SlackerTypeSingletonMode getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SlackerTypeSingletonMode();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(SlackerTypeSingletonMode.getInstance().hashCode());
            }).start();
        }
    }
}
