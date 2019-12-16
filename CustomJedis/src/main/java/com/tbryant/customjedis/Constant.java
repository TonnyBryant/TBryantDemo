package com.tbryant.customjedis;

public class Constant {
    public static final String START = "*";// 开始符
    public static final String LENGTH = "$";// 指令长度符
    public static final String LINE = "\r\n";// 换行符

    public enum command {
        SET,
        GET,
        INCR
    }
}
