package com.example.harkkatyo;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class MunicipalityData implements Serializable {
    private String name;
    private int year;
    private int population;

    public MunicipalityData(String n, int y, int p) {
        name = n;
        year = y;
        population = p;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
