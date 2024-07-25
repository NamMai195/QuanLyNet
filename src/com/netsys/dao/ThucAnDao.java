/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;


import com.netsys.entity.nhanVien;
import com.netsys.entity.thuan;
import com.netsys.utlis.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Nam
 */
public class ThucAnDao extends NETSYSDAO<thuan, String>{
    final  String INSERT_SQL="INSERT INTO thucan(mata,tenta,gia,hinh,soluong,loai) VALUES(?,?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE thucan SET tenta=?,gia=?,hinh=?,soluong=?,loai=? Where mata=?";
    final String DELETE_SQL="DELETE FROM NhanVien WHERE MaNV=?";
    final String SELECT_ALL_SQL="SELECT * FROM thucan";
    final String SELECT_BY_ID_SQL="SELECT * FROM thucan WHERE mata=?";
    @Override
    public void insert(thuan entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMata(),entity.getTenta(),entity.getGia(),entity.getHinh(),entity.getSoLuong(),entity.isLoai());
    }

    @Override
    public void update(thuan entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getTenta(),entity.getGia(),entity.getHinh(),entity.getSoLuong(),entity.isLoai(),entity.getMata());
    }

    @Override
    public void delete(String id) {
         JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<thuan> selectAll() {
         return this.selectBySql(SELECT_ALL_SQL);

    }

    @Override
    public thuan selectByid(String id) {
        List<thuan> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<thuan> selectBySql(String sql, Object... args) {
       List<thuan> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                thuan entity = new thuan();
                entity.setMata(rs.getString("mata"));
                
                entity.setTenta(rs.getString("tenta"));
                entity.setGia(rs.getDouble("gia"));
                entity.setHinh(rs.getString("hinh"));
                entity.setSoLuong(rs.getInt("soluong"));
                entity.setLoai(rs.getBoolean("loai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
       
    }


    
}
