package com.tbryant.mashibing.multithreading.lesson02;

import java.util.ArrayList;
import java.util.List;

// 这个DEMO证明volatile不能保证原子性
public class VolatileAtomicityTest {
    private static volatile int count = 0;

    // synchronized保证原子性
    private static /*synchronized*/ void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(VolatileAtomicityTest::m, "thread-" + i));
        }
        threadList.forEach(Thread::start);
        threadList.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(VolatileAtomicityTest.count);
    }
}
