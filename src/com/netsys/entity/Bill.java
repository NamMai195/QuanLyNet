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
public class Bill {
    private int mabill;
    private String makh;
    private String manv;
    private Double Tong;
    private Date tglap;
    private boolean trangthai;

    public Bill() {
    }

    public Bill(int mabill, String makh, String manv, Double Tong, Date tglap, boolean trangthai) {
        this.mabill = mabill;
        this.makh = makh;
        this.manv = manv;
        this.Tong = Tong;
        this.tglap = tglap;
        this.trangthai = trangthai;
    }

    public int getMabill() {
        return mabill;
    }

    public void setMabill(int mabill) {
        this.mabill = mabill;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Double getTong() {
        return Tong;
    }

    public void setTong(Double Tong) {
        this.Tong = Tong;
    }

    public Date getTglap() {
        return tglap;
    }

    public void setTglap(Date tglap) {
        this.tglap = tglap;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
    

}
