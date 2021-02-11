/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Djordje Janjic
 */
public class Food implements Serializable{
    private long idFood;
    private String name;
    private double kcalPerUnit;
    private List<Entry> entry;

    public Food() {
    }

    public Food(long idFood, String name, double kcalPerUnit, List<Entry> entry) {
        this.idFood = idFood;
        this.name = name;
        this.kcalPerUnit = kcalPerUnit;
        this.entry = entry;
    }

    public double getKcalPerUnit() {
        return kcalPerUnit;
    }

    public void setKcalPerUnit(double kcalPerUnit) {
        this.kcalPerUnit = kcalPerUnit;
    }

    public long getIdFood() {
        return idFood;
    }

    public void setIdFood(long idFood) {
        this.idFood = idFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return name;
    }

}
