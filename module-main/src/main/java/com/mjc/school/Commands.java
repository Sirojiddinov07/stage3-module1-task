package com.mjc.school;

public enum Commands {
    GET_ALL(1, "Get all news"),
    GET_BY_ID(2, "Get all news"),
    CREATE(3, "Get all news"),
    UPDATE(4, "Get all news"),
    REMOVE_BY_ID(5, "Get all news"),
    EXIT(0, "Get all news"),
    ;


    public final int i;

    public  final String  desc;
    Commands(int i, String desc) {
        this.i = i;
        this.desc = desc;
    }
}
