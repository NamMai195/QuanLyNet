/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;

import com.netsys.entity.khachhang;
import com.netsys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class KhachHangDao extends NETSYSDAO<khachhang, Integer>{
    final  String INSERT_SQL="INSERT INTO khachhang(tenkh,mathekh,tienconlai) VALUES(?,?,?)";
    final String UPDATE_SQL="UPDATE khachhang SET tenkh=?,mathekh=?,tienconlai=? Where maNH=?";
    final String DELETE_SQL="DELETE FROM khachhang WHERE makh=?";
    final String SELECT_ALL_SQL="SELECT * FROM khachhang";
    final String SELECT_BY_ID_SQL="SELECT * FROM khachhang WHERE makh=?";
    @Override
    public void insert(khachhang entity) {
        JdbcHelper.update(INSERT_SQL,entity.getTenkh(),entity.getMathekh(),entity.getTienconlai());
    }

    @Override
    public void update(khachhang entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getTenkh(),entity.getMathekh(),entity.getTienconlai(),entity.getMakh());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<khachhang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public khachhang selectByid(Integer id) {
    List<khachhang> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<khachhang> selectBySql(String sql, Object... args) {
       List<khachhang> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                khachhang entity = new khachhang();
                entity.setMakh(rs.getInt("makh"));
                entity.setTenkh(rs.getString("tenkh"));
                entity.setMathekh(rs.getString("mathekh"));
                entity.setTienconlai(rs.getDouble("tienconlai"));
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
