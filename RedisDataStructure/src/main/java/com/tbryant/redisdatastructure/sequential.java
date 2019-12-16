package com.tbryant.redisdatastructure;

public class sequential {
    int zlbytes;
    int zltail;
    int zlen;
    entry entry1;
//    ...
    entry entryN;
    int zlend;
}

class entry{
    int previous_entry_length;
    String encoding;
    Object content;
}
