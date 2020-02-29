package com.tbryant.mashibing.multithreading.lesson02.singletonmode;

// 登记式/内部静态类单例模式
public class RegistrationTypeSingletonMode {
    private static class RegistrationTypeSingletonModeHolder {
        private static final RegistrationTypeSingletonMode INSTANCE = new RegistrationTypeSingletonMode();
    }

    private RegistrationTypeSingletonMode() {
    }

    public static final RegistrationTypeSingletonMode getInstance() {
        return RegistrationTypeSingletonModeHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(RegistrationTypeSingletonMode.getInstance().hashCode());
            }).start();
        }
    }
}
