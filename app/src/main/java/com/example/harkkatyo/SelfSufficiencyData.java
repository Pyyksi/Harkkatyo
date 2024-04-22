package com.example.harkkatyo;

import java.io.Serializable;

public class SelfSufficiencyData implements Serializable {

    private String name;
    private int year;
    private Float selfSufficiency;

    public SelfSufficiencyData(String n, int y, Float self) {
        name = n;
        year = y;
        selfSufficiency = self;
    }

    public Float getSelfSufficiency() {
        return selfSufficiency;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
