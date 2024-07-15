/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.entity;
import java.time.LocalDateTime;
/**
 *
 * @author Nam
 */
public class bill_pc {
    private int mabill;
    private int mamt;
    private LocalDateTime start;
    private LocalDateTime end;
    private Double price;

    public int getMabill() {
        return mabill;
    }

    public void setMabill(int mabill) {
        this.mabill = mabill;
    }

    public int getMamt() {
        return mamt;
    }

    public void setMamt(int mamt) {
        this.mamt = mamt;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}
