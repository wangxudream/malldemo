package com.kataer.mall.portal.log;

import java.util.List;

public class Node {
    private String userId;
    private String name;
    private int subNums;
    private int leftSubNums;
    private List<Node> subs;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getSubs() {
        return subs;
    }

    public void setSubs(List<Node> subs) {
        this.subs = subs;
    }

    public Integer getSubNums() {
        return subNums;
    }

    public void setSubNums(Integer subNums) {
        this.subNums = subNums;
    }

    public void setSubNums(int subNums) {
        this.subNums = subNums;
    }

    public int getLeftSubNums() {
        return leftSubNums;
    }

    public void setLeftSubNums(int leftSubNums) {
        this.leftSubNums = leftSubNums;
    }
}
