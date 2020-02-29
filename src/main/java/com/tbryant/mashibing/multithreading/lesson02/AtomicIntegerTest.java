package com.tbryant.mashibing.multithreading.lesson02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    //    private static volatile int count = 0;
    private static AtomicInteger count = new AtomicInteger(0);// 代替int

    private static void m() {
        for (int i = 0; i < 10000; i++) {
//            count++;
            count.incrementAndGet();// 代替count++;
        }
    }

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(AtomicIntegerTest::m, "thread-" + i));
        }
        threadList.forEach(Thread::start);
        threadList.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(AtomicIntegerTest.count);
    }
}
