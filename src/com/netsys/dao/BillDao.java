/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;

import com.netsys.entity.Bill;
import com.netsys.entity.khachhang;
import com.netsys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class BillDao extends NETSYSDAO<Bill, Integer>{
    final  String INSERT_SQL="INSERT INTO bill(makh,manv,tong,tglap,trangthai) VALUES(?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE bill SET makh=?,manv=?,tong=?,tglap=?,trangthai=? Where mabill=?";
    final String DELETE_SQL="DELETE FROM bill WHERE mabill=?";
    final String SELECT_ALL_SQL="SELECT * FROM bill";
    final String SELECT_BY_ID_SQL="SELECT * FROM bill WHERE mabill=?";
    @Override
    public void insert(Bill entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMakh(),entity.getManv(),entity.getTong(),entity.getTglap(),entity.isTrangthai());
    }

    @Override
    public void update(Bill entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMakh(),entity.getManv(),entity.getTong(),entity.getTglap(),entity.isTrangthai(),entity.getMabill());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<Bill> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Bill selectByid(Integer id) {
    List<Bill> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<Bill> selectBySql(String sql, Object... args) {
       List<Bill> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                Bill entity = new Bill();
                entity.setMabill(rs.getInt("mabill"));
                entity.setMakh(rs.getString("makh"));
                entity.setManv(rs.getString("manv"));
                entity.setTong(rs.getDouble("tong"));
                entity.setTglap(rs.getTimestamp("tglap"));
                entity.setTrangthai(rs.getBoolean("trangthai"));
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
    
}
