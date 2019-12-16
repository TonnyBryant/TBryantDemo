package com.tbryant.redisdatastructure;

public class zskiplistNode {
    zskiplistLevel[] level;
    zskiplistNode backward;
    double score;
    Object obj;
}

class zskiplistLevel {
    zskiplistNode forward;
    int span;
}
