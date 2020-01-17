package com.tbryant.redisdatastructure;

import java.util.Date;

public class redisServer {
    int dbnum;// 当前redis节点内数据库数量，默认16
    redisDb[] db;// 数组，保存数据库信息
    redisClient clients;// 链表，保存客户端信息
    int cronloops;// serverCron函数计数器
    // 持久化相关
    String rdb_child_pid;// 执行BGSAVE子进程ID，-1表示未执行
    String aof_child_pid;// 执行BGREWRITEAOF子进程ID，-1表示未执行
    long dirty;// 修改计数器
    Date lastsave;// 上次BGSAVE时间
    sdshdr aof_buf;// AOF缓冲区
    // 慢查询相关
    long slowlog_entry_id;// 下一条慢查询日志ID
    Object slowlog;// 慢查询日志链表
    long slowlog_log_slower_than;// 超出该属性值则为慢查询，单位微秒
    long slowlog_max_len;// 慢查询日志保存数量
}

class redisDb{
    dict dict;// 保存键值对
    dict expires;// 保存设置过期时间的键和过期时间
    dict watched_keys;// 保存被WATCH监视的键
}

class redisClient{
    redisDb db;// 当前客户端正在使用的数据库
    sdshdr querybuf;// 输入缓冲区
}