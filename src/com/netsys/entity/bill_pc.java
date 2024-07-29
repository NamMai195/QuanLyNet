/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.entity;
import java.time.LocalDateTime;
import java.util.Date;
/**
 *
 * @author Nam
 */
public class bill_pc {
    private int mabill;
    private String mamt;
    private Date start;
    private Date end;
    private Double price;
    private boolean loai;

    public boolean isLoai() {
        return loai;
    }

    public void setLoai(boolean loai) {
        this.loai = loai;
    }
    
    public int getMabill() {
        return mabill;
    }

    public void setMabill(int mabill) {
        this.mabill = mabill;
    }

    public String getMamt() {
        return mamt;
    }

    public void setMamt(String mamt) {
        this.mamt = mamt;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}
