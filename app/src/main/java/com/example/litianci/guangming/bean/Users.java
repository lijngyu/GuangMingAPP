package com.example.litianci.guangming.bean;

/**
 *
 * 通信录界面上使用过的排序 用户内容
 *@author ZJP
 *created at 16/8/15 上午10:34
 *
 */
public class Users {
    public String name;
    public int power;

    public Users(String name, int i) {
        this.name=name;
        this.power=i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
