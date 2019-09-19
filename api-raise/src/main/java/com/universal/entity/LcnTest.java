package com.universal.entity;

import java.io.Serializable;

public class LcnTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String info;

    public LcnTest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "LcnTest{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
