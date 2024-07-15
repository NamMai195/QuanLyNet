/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;

import com.netsys.entity.nhanVien;
import java.util.List;

/**
 *
 * @author Nam
 */
public class main {
    public static void main(String[] args) {
        NhanVienDAO nvdao=new NhanVienDAO();
        nhanVien nv=new nhanVien();
//        nv.setTenNV("mai văn nam");
//        nv.setUsername("maivannam");
//        nv.setPass("123");
//        nv.setRole(true);
//        nvdao.insert(nv);
        List<nhanVien> list=nvdao.selectAll();
       for(nhanVien kh:list){
                System.out.println(kh.getTenNV());
                System.out.println(kh.isRole());
                
            }
        System.out.println("hettt");
      nvdao.delete(5);
      for(nhanVien kh:list){
                System.out.println(kh.getTenNV());
                System.out.println(kh.isRole());
            }
    }
}
sfdsfsdffsd
