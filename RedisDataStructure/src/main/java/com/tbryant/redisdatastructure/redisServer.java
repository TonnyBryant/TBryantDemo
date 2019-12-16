package com.tbryant.redisdatastructure;

public class redisServer {
    int dbnum;// 当前redis节点内数据库数量，默认16
    redisDb[] db;// 数组，保存数据库信息
    redisClient clients;// 链表，保存客户端信息
}

class redisDb{
    dict dict;// 保存键值对
    dict expires;// 保存设置过期时间的键和过期时间
    dict watched_keys;// 保存被WATCH监视的键
}

class redisClient{
    redisDb db;// 当前客户端正在使用的数据库

}