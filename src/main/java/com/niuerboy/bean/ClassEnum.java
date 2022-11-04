package com.niuerboy.bean;

public enum ClassEnum {
    One("高一一班",1),Two("高一二班",2),Three("高一三班",3),
    Four("高二一班",4),Five("高二二班",5),Six("高二三班",6),
    Seven("高三一班",5),Eight("高三二班",8),Nine("高三三班",9);
    private String name;
    private int index;
    // 构造方法
    ClassEnum(String name,int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
