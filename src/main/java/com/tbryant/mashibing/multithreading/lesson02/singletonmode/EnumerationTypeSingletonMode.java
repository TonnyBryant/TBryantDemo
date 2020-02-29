package com.tbryant.mashibing.multithreading.lesson02.singletonmode;

// 枚举式单例模式
// 防止反射攻击
// 解决序列化产生多例问题
public enum EnumerationTypeSingletonMode {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(EnumerationTypeSingletonMode.INSTANCE.hashCode());
            }).start();
        }
    }
}
