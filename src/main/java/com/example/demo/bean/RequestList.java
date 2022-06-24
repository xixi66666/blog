package com.example.demo.bean;


import lombok.Data;


public class RequestList {

    private int id;
    private int reciver;
    private int sponsor_id;

    public RequestList() {
    }

    public RequestList(int id, int reciver, int sponsor_id) {
        this.id = id;
        this.reciver = reciver;
        this.sponsor_id = sponsor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReciver() {
        return reciver;
    }

    public void setReciver(int reciver) {
        this.reciver = reciver;
    }

    public int getSponsor_id() {
        return sponsor_id;
    }

    public void setSponsor_id(int sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    @Override
    public String toString() {
        return "RequestList{" +
                "id=" + id +
                ", reciver=" + reciver +
                ", sponsor_id=" + sponsor_id +
                '}';
    }
}
