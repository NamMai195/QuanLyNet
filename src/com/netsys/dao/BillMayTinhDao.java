/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;

import com.netsys.entity.bill_pc;
import com.netsys.entity.khachhang;
import com.netsys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class BillMayTinhDao extends NETSYSDAO<bill_pc, Integer>{
    final  String INSERT_SQL="INSERT INTO bill_pc(mabill,mamt,start_time,price,loat) VALUES(?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE bill_pc SET start_time=?,end_time=?,price=?,loat Where mabill=? and mamt=?";
    final String DELETE_SQL="DELETE FROM bill_pc WHERE mabill=? and mamt=?";
    final String SELECT_ALL_SQL="SELECT * FROM bill_pc";
    final String SELECT_BY_ID_SQL="SELECT * FROM bill_pc WHERE mabill=? and mamt=?";
    @Override
    public void insert(bill_pc entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMabill(),entity.getMamt(),entity.getStart(),entity.getPrice(),entity.isLoai());
    }

    @Override
    public void update(bill_pc entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getStart(),entity.getEnd(),entity.getPrice(),entity.isLoai(),entity.getMabill(),entity.getMamt());
    }

    public void delete(Integer id,Integer id2) {
        JdbcHelper.update(DELETE_SQL,id,id2);
    }

    @Override
    public List<bill_pc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public bill_pc selectByid(Integer id) {
    List<bill_pc> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<bill_pc> selectBySql(String sql, Object... args) {
       List<bill_pc> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                bill_pc entity = new bill_pc();
                entity.setMabill(rs.getInt("mabill"));
                entity.setMamt(rs.getString("mamt"));
                entity.setStart(rs.getTimestamp("start_time"));
                entity.setEnd(rs.getTimestamp("end_time"));
                entity.setLoai(rs.getBoolean("loat"));
                list.add(entity);
            }
             rs.getStatement().getConnection().close();
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
//    public  List<NguoiHoc> selectNotInCourse(int makh,String keword){
//        String sql="SELECT * FROM NguoiHoc"
//                + " WHERE HoTen LIKE ? AND"
//                + " MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)";
//        return this.selectBySql(sql,"%"+keword+"%",makh);
//    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
