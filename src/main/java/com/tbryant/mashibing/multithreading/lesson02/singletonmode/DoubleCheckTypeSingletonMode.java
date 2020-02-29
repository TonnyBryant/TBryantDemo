package com.tbryant.mashibing.multithreading.lesson02.singletonmode;

// 双重检查式单例模式
public class DoubleCheckTypeSingletonMode {
    // 不加volatile会有DCL问题
    private static /*volatile*/ DoubleCheckTypeSingletonMode INSTANCE;

    private DoubleCheckTypeSingletonMode() {
    }

    public static DoubleCheckTypeSingletonMode getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckTypeSingletonMode.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckTypeSingletonMode();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(DoubleCheckTypeSingletonMode.getInstance().hashCode());
            }).start();
        }
    }
}