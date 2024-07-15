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
public class Bill {
    private int mabillD;
    private int makh;
    private int manv;
    private Double tong;
    private LocalDateTime tglap;

    public int getMabillD() {
        return mabillD;
    }

    public void setMabillD(int mabillD) {
        this.mabillD = mabillD;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public Double getTong() {
        return tong;
    }

    public void setTong(Double tong) {
        this.tong = tong;
    }

    public LocalDateTime getTglap() {
        return tglap;
    }

    public void setTglap(LocalDateTime tglap) {
        this.tglap = tglap;
    }

}
