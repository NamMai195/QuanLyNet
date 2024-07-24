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
public class NhanVienDAO extends NETSYSDAO<nhanVien, String>{
    final  String INSERT_SQL="INSERT INTO NhanVien(manv,tennv,pass,role,sdt,hinh) VALUES(?,?,?,?,?,?)";
    final String UPDATE_SQL="UPDATE NhanVien SET tennv=?,pass=?,role=?,sdt=?,hinh=? Where manv=?";
    final String DELETE_SQL="DELETE FROM NhanVien WHERE MaNV=?";
    final String SELECT_ALL_SQL="SELECT * FROM NhanVien";
    final String SELECT_BY_ID_SQL="SELECT * FROM NhanVien WHERE MaNV=?";
    @Override
    public void insert(nhanVien entity) {
        JdbcHelper.update(INSERT_SQL,entity.getManv(),entity.getTennv(),entity.getPass(),entity.isRole(),entity.getSdt(),entity.getHinh());
    }

    @Override
    public void update(nhanVien entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getTennv(),entity.getPass(),entity.isRole(),entity.getSdt(),entity.getHinh(),entity.getManv());
    }

    @Override
    public void delete(String id) {
         JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<nhanVien> selectAll() {
         return this.selectBySql(SELECT_ALL_SQL);

    }

    @Override
    public nhanVien selectByid(String id) {
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
                entity.setManv(rs.getString("manv"));
                
                entity.setTennv(rs.getString("tennv"));
                entity.setPass(rs.getString("pass"));
                entity.setRole(rs.getBoolean("role"));
                entity.setSdt(rs.getString("sdt"));
                entity.setHinh(rs.getString("hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
       
    }


    
}
