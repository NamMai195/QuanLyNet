/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;


import com.netsys.entity.nhanVien;
import com.netsys.utlis.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Nam
 */
public class NhanVienDAO extends NETSYSDAO<nhanVien, Integer>{
    final  String INSERT_SQL="INSERT INTO NhanVien(tennv,username,pass,role) VALUES(?,?,?,?)";
    final String UPDATE_SQL="UPDATE NhanVien SET tennv=?,username=?,pass=?,role=? Where manv=?";
    final String DELETE_SQL="DELETE FROM NhanVien WHERE MaNV=?";
    final String SELECT_ALL_SQL="SELECT * FROM NhanVien";
    final String SELECT_BY_ID_SQL="SELECT * FROM NhanVien WHERE MaNV=?";
    @Override
    public void insert(nhanVien entity) {
        JdbcHelper.update(INSERT_SQL,entity.getTenNV(),entity.getUsername(),entity.getPass(),entity.isRole());
    }

    @Override
    public void update(nhanVien entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getTenNV(),entity.getUsername(),entity.getPass(),entity.isRole(),entity.getManv());
    }

    @Override
    public void delete(Integer id) {
         JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<nhanVien> selectAll() {
         return this.selectBySql(SELECT_ALL_SQL);

    }

    @Override
    public nhanVien selectByid(Integer id) {
        List<nhanVien> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<nhanVien> selectBySql(String sql, Object... args) {
       List<nhanVien> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                nhanVien entity = new nhanVien();
                entity.setManv(rs.getInt("MaNV"));
                
                entity.setTenNV(rs.getString("tennv"));
                entity.setUsername(rs.getString("username"));
                entity.setPass(rs.getString("pass"));
                entity.setRole(rs.getBoolean("role"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
       
    }


    
}
