package com.tbryant.mashibing.multithreading.lesson02.singletonmode;

// 饿汉式单例模式
public class HungryManSingletonMode {
    private static final HungryManSingletonMode INSTANCE = new HungryManSingletonMode();

    private HungryManSingletonMode() {
    }

    public static HungryManSingletonMode getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(HungryManSingletonMode.getInstance().hashCode());
            }).start();
        }
    }
}
