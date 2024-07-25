/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;


import com.netsys.entity.mayTinh;
import com.netsys.utlis.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nam
 */
public class MayTinhDao extends NETSYSDAO<mayTinh, String>{
    final  String INSERT_SQL="INSERT INTO maytinh(mamt,tenmt,status,tientheogio) VALUES(?,?,?,?)";
    final String UPDATE_SQL="UPDATE maytinh SET tenmt=?,status=?,tientheogio=? Where mamt=?";
    final String DELETE_SQL="DELETE FROM maytinh WHERE makh=?";
    final String SELECT_ALL_SQL="SELECT * FROM maytinh";
    final String SELECT_BY_ID_SQL="SELECT * FROM maytinh WHERE mamt=?";
    @Override
    public void insert(mayTinh entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMamt(),entity.getTenmt(),entity.getStatus(),entity.getTientheogio());
    }

    @Override
    public void update(mayTinh entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getTenmt(),entity.getStatus(),entity.getTientheogio(),entity.getMamt());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<mayTinh> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public mayTinh selectByid(String id) {
    List<mayTinh> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<mayTinh> selectBySql(String sql, Object... args) {
       List<mayTinh> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                mayTinh entity = new mayTinh();
                entity.setMamt(rs.getString("mamt"));
                entity.setTenmt(rs.getString("tenmt"));
                entity.setStatus(rs.getString("status"));
                entity.setTientheogio(rs.getFloat("tientheogio"));
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
