package com.tbryant.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class Application {
    public static void main(String[] args) {
        BloomFilter bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 10000, 0.03);
        for (int i = 0; i < 10000; i++) {
            bloomFilter.put("TBryant" + i);
        }
        // 测试错误率
        int j = 0;
        for (int i = 0; i < 10001; i++) {
            if (bloomFilter.mightContain("E-Ting" + i)) {
                j++;
            }
        }
        System.out.println("10000行数据误差" + j + "行");
    }
}
