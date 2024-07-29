/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.utlis;

import com.netsys.entity.Bill;
import com.netsys.entity.nhanVien;

/**
 *
 * @author Nam
 */
public class LuuBill {
//   doi tuong chua bill khi nguoi dung 
    public static Bill bill=null;
//    clear thong tin khi dang xuat
    public static void clear(){
        LuuBill.bill=null;
    }
//    KT dang nhap hay chua
   public static boolean KTBILL(){
       return LuuBill.bill !=null;
   }
//   public static boolean isManager(){
//       return LuuBill.KTBILL()&& LuuBill.();
//   }
}
