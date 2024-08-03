/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.entity;

/**
 *
 * @author Nam
 */
public class QR {
    String makh;
    String duongdan;

    public QR(String makh, String duongdan) {
        this.makh = makh;
        this.duongdan = duongdan;
    }

    public QR() {
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getDuongdan() {
        return duongdan;
    }

    public void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }
    
}
