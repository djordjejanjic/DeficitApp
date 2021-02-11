/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Djordje Janjic
 */
public class Entry implements Serializable{
    private long idEntry;
    private double kcalAmount;
    private Date entryDate;

    public Entry() {
    }

    public Entry(long idEntry, double kcalAmount, Date entryDate) {
        this.idEntry = idEntry;
        this.kcalAmount = kcalAmount;
        this.entryDate = entryDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public long getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(long idEntry) {
        this.idEntry = idEntry;
    }

    public double getKcalAmount() {
        return kcalAmount;
    }

    public void setKcalAmount(double kcalAmount) {
        this.kcalAmount = kcalAmount;
    }
    
     
}
