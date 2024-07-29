/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;


import com.netsys.entity.Bill_food;
import com.netsys.entity.mayTinh;
import com.netsys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class BillTaDao extends NETSYSDAO<Bill_food, String>{
    final  String INSERT_SQL="INSERT INTO maytinh(mamt,tenmt,status,tientheogio) VALUES(?,?,?,?)";
    final String UPDATE_SQL="UPDATE maytinh SET tenmt=?,status=?,tientheogio=? Where mamt=?";
    final String DELETE_SQL="DELETE FROM maytinh WHERE mamt=?";
    final String SELECT_ALL_SQL="SELECT * FROM maytinh";
    final String SELECT_BY_ID_SQL="SELECT * FROM maytinh WHERE mamt=?";
    @Override
    public void insert(Bill_food entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMamt(),entity.getTenmt(),entity.getStatus(),entity.getTientheogio());
    }

    @Override
    public void update(Bill_food entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getTenmt(),entity.getStatus(),entity.getTientheogio(),entity.getMamt());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<Bill_food> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Bill_food selectByid(String id) {
    List<Bill_food> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<Bill_food> selectBySql(String sql, Object... args) {
       List<Bill_food> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                Bill_food entity = new Bill_food();
                entity.setMabill(rs.getInt("mabill"));
                entity.setMata(rs.getString("mata"));
                entity.setSoluong(rs.getInt("soluong"));
                entity.setPrice(rs.getInt("price"));
                entity.setLoai(rs.getBoolean("loai"));
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
