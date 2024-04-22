package com.example.harkkatyo;

import java.io.Serializable;

public class EmploymentData implements Serializable {

    private String name;
    private int year;
    private Float employmentRate;

    public EmploymentData(String n, int y, Float er) {
        name = n;
        year = y;
        employmentRate = er;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Float getEmploymentRate() {
        return employmentRate;
    }
}
