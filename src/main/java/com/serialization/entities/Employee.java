package com.serialization.entities;

import java.util.Date;
import java.util.List;

public class Employee {

    private int id;

    private String name;

    private long dob;

    private List<String> depts;

    public Employee() {
    }

    public Employee(int id, String name, long dob, List<String> depts) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.depts = depts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public List<String> getDepts() {
        return depts;
    }

    public void setDepts(List<String> depts) {
        this.depts = depts;
    }
}
