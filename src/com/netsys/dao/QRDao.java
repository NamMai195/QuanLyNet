/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netsys.dao;


import com.netsys.entity.QR;
import com.netsys.entity.nhanVien;
import com.netsys.utlis.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Nam
 */
public class QRDao extends NETSYSDAO<QR, String>{
    final  String INSERT_SQL="INSERT INTO ma_qr(makh,qr_path) VALUES(?,?)";
    final String UPDATE_SQL="UPDATE ma_qr SET qr_path=? Where makh=?";
    final String DELETE_SQL="DELETE FROM ma_qr WHERE makh=?";
    final String SELECT_ALL_SQL="SELECT * FROM ma_qr";
    final String SELECT_BY_ID_SQL="SELECT * FROM ma_qr WHERE makh=?";
    @Override
    public void insert(QR entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMakh(),entity.getDuongdan());
    }

    @Override
    public void update(QR entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getDuongdan(),entity.getMakh());
    }

    @Override
    public void delete(String id) {
         JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<QR> selectAll() {
         return this.selectBySql(SELECT_ALL_SQL);

    }

    @Override
    public QR selectByid(String id) {
        List<QR> list= selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QR> selectBySql(String sql, Object... args) {
       List<QR> list= new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                QR entity = new QR();
                entity.setMakh(rs.getString("makh"));
                
                entity.setDuongdan(rs.getString("qr_path"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
       
    }


    
}
