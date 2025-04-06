package com.example.myapplication;

public class Employe {
    private int sno;
    private String name;
    private String dept;

    public Employe(int sno, String name, String dept) {
        this.sno = sno;
        this.name = name;
        this.dept = dept;
    }

    public int getSno() {
        return sno;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }
}
