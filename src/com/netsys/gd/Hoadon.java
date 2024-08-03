/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.netsys.gd;

import com.netsys.dao.BillDao;
import com.netsys.dao.BillMayTinhDao;
import com.netsys.dao.BillTaDao;
import com.netsys.dao.KhachHangDao;
import com.netsys.dao.MayTinhDao;
import com.netsys.dao.ThucAnDao;
import com.netsys.entity.Bill;
import com.netsys.entity.Bill_food;
import com.netsys.entity.bill_pc;
import com.netsys.entity.khachhang;
import com.netsys.entity.mayTinh;
import com.netsys.entity.thuan;
import com.netsys.utlis.Auth;
import com.netsys.utlis.LUUKH;
import com.netsys.utlis.LUUMT;
import com.netsys.utlis.LuuBill;
import com.netsys.utlis.QRCODEDJ;
import com.netsys.utlis.TBBOX;
import com.netsys.utlis.XDate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Hoadon extends javax.swing.JDialog {
private int current;
private BillDao dao=new BillDao();
private  List<Bill> listbill=dao.selectAll();
   private List<JButton> but=new ArrayList<>();
   //ham lay so theo ten buton
   private int extractNumber(String text) {
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(text);
    if (matcher.find()) {
        return Integer.parseInt(matcher.group());
    }
    return Integer.MAX_VALUE; // Nếu không tìm thấy số, trả về giá trị lớn nhất
}
   void ADDLIST(){
     for (java.awt.Component component : test.getComponents()) {
            if (component instanceof JButton) {
               
                JButton button = (JButton) component;
                if (button.getText().startsWith("Máy")) {
                    but.add(button);
                    
                }
            }
          
        }

    for (int i = 0; i < but.size() - 1; i++) {
    for (int j = 0; j < but.size() - i - 1; j++) {
        int number1 = extractNumber(but.get(j).getText());
        int number2 = extractNumber(but.get(j + 1).getText());

        if (number1 > number2) {
            // Hoán đổi các nút&
            JButton temp = but.get(j);
            but.set(j, but.get(j + 1));
            but.set(j + 1, temp);
        }
    }
    
   }
     for(JButton b:but){
        System.out.println(b.getText());
    }
   }
   MayTinhDao mtdao=new MayTinhDao();
   List<mayTinh> listmt=mtdao.selectAll();
  private void gangttsk(){
      listmt=mtdao.selectAll();
      for(int i=0;i<but.size();i++){
          if(listmt.size()>i){
              if(listmt.get(i).getStatus().equalsIgnoreCase("trống")){
                  but.get(i).setText(listmt.get(i).getTenmt());
              but.get(i).setEnabled(true);
              }
              else if(listmt.get(i).getStatus().equalsIgnoreCase("đang sử dụng")){
                   but.get(i).setText(listmt.get(i).getTenmt());
              but.get(i).setEnabled(false);
              }
              else if(listmt.get(i).getStatus().equalsIgnoreCase("Bảo Trì")){
                   but.get(i).setText(listmt.get(i).getTenmt()+"BT");
              but.get(i).setEnabled(false);
              }
           
          }
          else{
              but.get(i).setText("CHƯA CÓ");
              but.get(i).setEnabled(false);
          }
      }
  
  }


    public Hoadon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        init();
        txtmabill.setEnabled(false);
        ADDLIST();
        gangttsk();
    }
    BillMayTinhDao billmtdao=new BillMayTinhDao();
    List<bill_pc> listbillmt=billmtdao.selectAll();
void loadbilltable(){
    DefaultTableModel model=(DefaultTableModel) tbldatu.getModel();
    model.setRowCount(0);
     try {
            List<bill_pc> list=billmtdao.selectAll();
            for(bill_pc b:list){
                if(b.getMabill()==LuuBill.bill.getMabill()){
                 mayTinh m=mtdao.selectByid(b.getMamt());
                Object[] row={b.getMabill()+"-"+b.getMamt(),m.getTenmt(),m.getTientheogio(),1,"CHƯA CÓ",b.isLoai()?"Đồ Ăn":"Máy Tính"};
                model.addRow(row); 
                }
               
            }
            BillTaDao billtad=new BillTaDao();
            List<Bill_food> listbillfood=billtad.selectAll();
            for(Bill_food bta:listbillfood){
                 if(bta.getMabill()==LuuBill.bill.getMabill()){
                     ThucAnDao thucandao=new ThucAnDao();
                thuan ta=thucandao.selectByid(bta.getMata());
                Object[] row={bta.getMabill()+"-"+bta.getMata(),ta.getTenta(),ta.getGia(),bta.getSoluong(),bta.getPrice(),bta.isLoai()?"Đồ Ăn":"Máy Tính"};
                model.addRow(row);
                 }
                
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Lỗi Truy Vấn");
            System.out.println(e);
        }
    
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        butqr = new javax.swing.JButton();
        cbbloaikh = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        butthem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtmabill = new javax.swing.JTextField();
        txttenkh = new javax.swing.JTextField();
        txtmanv = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txttglap = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtkm = new javax.swing.JTextField();
        butxoa = new javax.swing.JButton();
        butsua = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtmakh = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbill = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        test = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        may1 = new javax.swing.JButton();
        may2 = new javax.swing.JButton();
        may3 = new javax.swing.JButton();
        may5 = new javax.swing.JButton();
        may4 = new javax.swing.JButton();
        may9 = new javax.swing.JButton();
        may6 = new javax.swing.JButton();
        may7 = new javax.swing.JButton();
        may10 = new javax.swing.JButton();
        may11 = new javax.swing.JButton();
        may12 = new javax.swing.JButton();
        may14 = new javax.swing.JButton();
        may8 = new javax.swing.JButton();
        may13 = new javax.swing.JButton();
        jButton185 = new javax.swing.JButton();
        jButton186 = new javax.swing.JButton();
        may17 = new javax.swing.JButton();
        jButton188 = new javax.swing.JButton();
        may15 = new javax.swing.JButton();
        may16 = new javax.swing.JButton();
        jButton191 = new javax.swing.JButton();
        jButton192 = new javax.swing.JButton();
        jButton193 = new javax.swing.JButton();
        jButton194 = new javax.swing.JButton();
        jButton195 = new javax.swing.JButton();
        jButton196 = new javax.swing.JButton();
        jButton197 = new javax.swing.JButton();
        jButton198 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldatu = new javax.swing.JTable();
        butxoasp = new javax.swing.JButton();
        butcapnhatsp = new javax.swing.JButton();
        butlammoihd = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btntrangthai = new javax.swing.JLabel();
        butta = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txttong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtkhuyenmait = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        butxacnhan = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbltrangthaibill = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbltrangthaibilldtt = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbbtttt = new javax.swing.JComboBox<>();
        butht = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        txtmanvtt = new javax.swing.JTextField();
        txtmabilltt = new javax.swing.JTextField();
        txtmakhtt = new javax.swing.JTextField();
        txttongtientt = new javax.swing.JTextField();
        txttgkttt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txttgbdtt = new javax.swing.JTextField();

        jLabel20.setText("jLabel20");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Loại Khách Hàng:");

        butqr.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butqr.setText("QR");
        butqr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butqrActionPerformed(evt);
            }
        });

        cbbloaikh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbloaikh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách Vãn Lai", "Thẻ Khách Hàng" }));
        cbbloaikh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbloaikhItemStateChanged(evt);
            }
        });
        cbbloaikh.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbbloaikhAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbbloaikh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbloaikhMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Rest");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbloaikh, 0, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butqr)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(butqr)
                    .addComponent(cbbloaikh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông Tin Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        butthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/Create.png"))); // NOI18N
        butthem.setText("Tạo Bill");
        butthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butthemActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Mã Bill:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Tên Khách Hàng:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Mã Nhân Viên:");

        txtmanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanvActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Thời Gian Lập:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Khuyến Mãi:");

        butxoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/Delete.png"))); // NOI18N
        butxoa.setText("Xóa Bill");
        butxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butxoaActionPerformed(evt);
            }
        });

        butsua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/Refresh.png"))); // NOI18N
        butsua.setText("Sửa Bill");
        butsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butsuaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Mã Khách Hàng:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(butthem)
                        .addGap(49, 49, 49)
                        .addComponent(butxoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(butsua)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(txttglap, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtkm, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmabill, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtmabill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txttglap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butthem)
                    .addComponent(butxoa)
                    .addComponent(butsua))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Các Bill Đã Tạo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblbill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Bill", "Mã KH", "Mã NV", "Giờ Tạo"
            }
        ));
        tblbill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbill);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(546, 546, 546)
                .addComponent(jLabel7)
                .addGap(343, 343, 343))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(jLabel7)
                            .addGap(358, 358, 358)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa Đơn", jPanel7);

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel22.setText("TẠO HÓA ĐƠN");

        test.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel23.setText("Danh Sách Máy");

        may1.setBackground(new java.awt.Color(153, 255, 255));
        may1.setText("Máy 1");
        may1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may1ActionPerformed(evt);
            }
        });

        may2.setBackground(new java.awt.Color(153, 255, 255));
        may2.setText("Máy 2");
        may2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may2ActionPerformed(evt);
            }
        });

        may3.setBackground(new java.awt.Color(153, 255, 255));
        may3.setText("Máy 3");
        may3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may3ActionPerformed(evt);
            }
        });

        may5.setBackground(new java.awt.Color(102, 255, 255));
        may5.setText("Máy 5");
        may5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may5ActionPerformed(evt);
            }
        });

        may4.setBackground(new java.awt.Color(153, 255, 255));
        may4.setText("Máy 4");
        may4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may4ActionPerformed(evt);
            }
        });

        may9.setBackground(new java.awt.Color(102, 255, 255));
        may9.setText("Máy 9");
        may9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may9ActionPerformed(evt);
            }
        });

        may6.setBackground(new java.awt.Color(102, 255, 255));
        may6.setText("Máy 6");
        may6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may6ActionPerformed(evt);
            }
        });

        may7.setBackground(new java.awt.Color(102, 255, 255));
        may7.setText("Máy 7");
        may7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may7ActionPerformed(evt);
            }
        });

        may10.setBackground(new java.awt.Color(102, 255, 255));
        may10.setText("Máy 10");
        may10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may10ActionPerformed(evt);
            }
        });

        may11.setBackground(new java.awt.Color(102, 255, 255));
        may11.setText("Máy 11");
        may11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may11ActionPerformed(evt);
            }
        });

        may12.setBackground(new java.awt.Color(102, 255, 255));
        may12.setText("Máy 12");
        may12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may12ActionPerformed(evt);
            }
        });

        may14.setBackground(new java.awt.Color(102, 255, 255));
        may14.setText("Máy 14");
        may14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may14ActionPerformed(evt);
            }
        });

        may8.setBackground(new java.awt.Color(102, 255, 255));
        may8.setText("Máy 8");
        may8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may8ActionPerformed(evt);
            }
        });

        may13.setBackground(new java.awt.Color(102, 255, 255));
        may13.setText("Máy 13");
        may13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may13ActionPerformed(evt);
            }
        });

        jButton185.setBackground(new java.awt.Color(102, 255, 255));
        jButton185.setText("Máy 18");
        jButton185.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton185jButton15ActionPerformed(evt);
            }
        });

        jButton186.setBackground(new java.awt.Color(102, 255, 255));
        jButton186.setText("Máy 21");
        jButton186.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton186ActionPerformed(evt);
            }
        });

        may17.setBackground(new java.awt.Color(102, 255, 255));
        may17.setText("Máy 17");
        may17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may17ActionPerformed(evt);
            }
        });

        jButton188.setBackground(new java.awt.Color(102, 255, 255));
        jButton188.setText("Máy 22");
        jButton188.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton188ActionPerformed(evt);
            }
        });

        may15.setBackground(new java.awt.Color(102, 255, 255));
        may15.setText("Máy 15");
        may15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may15ActionPerformed(evt);
            }
        });

        may16.setBackground(new java.awt.Color(102, 255, 255));
        may16.setText("Máy 16");
        may16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                may16jButton20ActionPerformed(evt);
            }
        });

        jButton191.setBackground(new java.awt.Color(102, 255, 255));
        jButton191.setText("Máy 23");
        jButton191.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton191jButton21ActionPerformed(evt);
            }
        });

        jButton192.setBackground(new java.awt.Color(102, 255, 255));
        jButton192.setText("Máy 19");
        jButton192.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton192ActionPerformed(evt);
            }
        });

        jButton193.setBackground(new java.awt.Color(102, 255, 255));
        jButton193.setText("Máy 20");
        jButton193.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton193ActionPerformed(evt);
            }
        });

        jButton194.setBackground(new java.awt.Color(102, 255, 255));
        jButton194.setText("Máy 24");
        jButton194.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton194ActionPerformed(evt);
            }
        });

        jButton195.setBackground(new java.awt.Color(102, 255, 255));
        jButton195.setText("Máy 28");
        jButton195.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton195ActionPerformed(evt);
            }
        });

        jButton196.setBackground(new java.awt.Color(102, 255, 255));
        jButton196.setText("Máy 26");
        jButton196.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton196jButton26ActionPerformed(evt);
            }
        });

        jButton197.setBackground(new java.awt.Color(102, 255, 255));
        jButton197.setText("Máy 25");
        jButton197.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton197ActionPerformed(evt);
            }
        });

        jButton198.setBackground(new java.awt.Color(102, 255, 255));
        jButton198.setText("Máy 27");
        jButton198.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton198ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testLayout = new javax.swing.GroupLayout(test);
        test.setLayout(testLayout);
        testLayout.setHorizontalGroup(
            testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testLayout.createSequentialGroup()
                        .addComponent(jButton197, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton196, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton198, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton195, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(testLayout.createSequentialGroup()
                        .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(testLayout.createSequentialGroup()
                                .addComponent(jButton186, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton188, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(testLayout.createSequentialGroup()
                                .addComponent(may17, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton185, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(testLayout.createSequentialGroup()
                                .addComponent(may13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(may14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(testLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton191, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton194, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(testLayout.createSequentialGroup()
                                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(testLayout.createSequentialGroup()
                                        .addComponent(may15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(may16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(testLayout.createSequentialGroup()
                                        .addComponent(jButton192, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton193, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(testLayout.createSequentialGroup()
                        .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(may1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(may9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(may5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(testLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel23))
                            .addGroup(testLayout.createSequentialGroup()
                                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(testLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(may3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(testLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(may2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(may10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(may11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(testLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(may6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(may7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(may8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(may4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(may12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        testLayout.setVerticalGroup(
            testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(may1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(may8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(may9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(may16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(may13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(may17, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton185, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton192, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton193, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton194, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton191, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton188, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton186, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(testLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton197, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton196, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton198, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton195, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Hàng Đã Mua", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N

        tbldatu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Đơn Hàng", "Tên Sản Phẩm", "Giá", "Số Lượng", "Thành Tiền", "Loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbldatu);
        if (tbldatu.getColumnModel().getColumnCount() > 0) {
            tbldatu.getColumnModel().getColumn(0).setResizable(false);
            tbldatu.getColumnModel().getColumn(1).setResizable(false);
            tbldatu.getColumnModel().getColumn(2).setResizable(false);
            tbldatu.getColumnModel().getColumn(3).setResizable(false);
            tbldatu.getColumnModel().getColumn(4).setResizable(false);
            tbldatu.getColumnModel().getColumn(5).setResizable(false);
        }

        butxoasp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butxoasp.setText("Xóa Sản Phẩm");
        butxoasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butxoaspActionPerformed(evt);
            }
        });

        butcapnhatsp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butcapnhatsp.setText("Cập Nhật");
        butcapnhatsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butcapnhatspActionPerformed(evt);
            }
        });

        butlammoihd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butlammoihd.setText("Làm Mới");
        butlammoihd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butlammoihdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butlammoihd)
                .addGap(27, 27, 27)
                .addComponent(butcapnhatsp)
                .addGap(18, 18, 18)
                .addComponent(butxoasp)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butxoasp)
                    .addComponent(butcapnhatsp)
                    .addComponent(butlammoihd))
                .addGap(366, 366, 366))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Trạng Thái"));

        btntrangthai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntrangthai.setText("Cần Tạo Bill Trước Khi Mua Hàng");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btntrangthai)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btntrangthai)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        butta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/thuan.png"))); // NOI18N
        butta.setText("Thức Ăn");
        butta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttaActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Giá", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tổng:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Khuyến Mãi:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Thành Tiền:");

        jLabel1.setText("Lưu ý tiền này chỉ được tính cho thức ăn");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txttong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtkhuyenmait, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtthanhtien))
                .addGap(23, 23, 23))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtkhuyenmait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        butxacnhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butxacnhan.setText("Xác Nhận");
        butxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butxacnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(butta)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(butxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(477, 477, 477)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(butta)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butxacnhan))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel22)
                    .addContainerGap(684, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Mua Hàng", jPanel5);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh Sách Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        tbltrangthaibill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Bill", "Mã KH", "Mã NV", "TG lập", "Tổng", "Trạng Thái"
            }
        ));
        tbltrangthaibill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltrangthaibillMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbltrangthaibill);

        jTabbedPane2.addTab("Chưa Thanh Toán", jScrollPane3);

        tbltrangthaibilldtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Bill", "Mã KH", "Mã NV", "TG lập", "Tổng", "Trạng Thái"
            }
        ));
        tbltrangthaibilldtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltrangthaibilldttMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbltrangthaibilldtt);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Đã Thanh Toán", jPanel3);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Cập Nhật Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Mã Bill");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Mã KH:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Mã NV:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Thời Gian Kế Thúc:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Tổng Tiền:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Trạng Thái:");

        cbbtttt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa thanh toán", "Đã  thanh toán" }));

        butht.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butht.setText("Hoàn Thành ");
        butht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buthtActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton15.setText("Chi Tiết Hóa Đơn");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        txtmabilltt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmabillttActionPerformed(evt);
            }
        });

        txttongtientt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtienttActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Thời Gian Bắt Đầu");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(24, 24, 24)
                        .addComponent(txttgbdtt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmakhtt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmanvtt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel18)
                                .addComponent(jLabel17)
                                .addComponent(jLabel16))
                            .addGap(20, 20, 20)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txttgkttt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttongtientt)
                                .addComponent(txtmabilltt)
                                .addComponent(cbbtttt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(butht, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15)
                .addGap(21, 21, 21))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtmabilltt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtmakhtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtmanvtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txttgbdtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txttgkttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txttongtientt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbbtttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butht)
                    .addComponent(jButton15)
                    .addComponent(jButton2))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Trạng Thái", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton185jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton185jButton15ActionPerformed
        LUUMT.user=listmt.get(17);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
    }//GEN-LAST:event_jButton185jButton15ActionPerformed

    private void may16jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may16jButton20ActionPerformed
       LUUMT.user=listmt.get(15);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
    }//GEN-LAST:event_may16jButton20ActionPerformed

    private void jButton191jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton191jButton21ActionPerformed
       LUUMT.user=listmt.get(22);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
    }//GEN-LAST:event_jButton191jButton21ActionPerformed

    private void jButton196jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton196jButton26ActionPerformed
         LUUMT.user=listmt.get(25);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
    }//GEN-LAST:event_jButton196jButton26ActionPerformed

    private void buttaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttaActionPerformed
        new BooKFoodJDialog(null, true).setVisible(true);
        fillTable();
        loadbilltable();
        filltong();
    }//GEN-LAST:event_buttaActionPerformed

    private void may1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may1ActionPerformed
        LUUMT.user=listmt.get(0);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may1ActionPerformed

    private void txtmabillttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmabillttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmabillttActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      if(cbbtttt.getSelectedIndex()==0){
          TBBOX.alert(this, "bạn Cần Thanh toán truoc khi coi chi tiết hóa đơn");
      }
      else{
           LuuBill.bill=dao.selectByid(Integer.parseInt(txtmabilltt.getText()));
        new ChiTietHDJDialog(null,true).setVisible(true);
      }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void txtmanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanvActionPerformed

    private void cbbloaikhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbloaikhMouseClicked
      
    }//GEN-LAST:event_cbbloaikhMouseClicked

    private void butqrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butqrActionPerformed
     QRCODEDJ qr=new QRCODEDJ(null,true);
     qr.setVisible(true);
        if(LUUKH.user!=null){
            txtmakh.setText(LUUKH.user.getMakh());
            txttenkh.setText(LUUKH.user.getTenkh());
            txttglap.setText(XDate.toString(XDate.now(),"dd-MM-yyyy HH:mm:ss"));
            txtkm.setText("15%");
        }
        else{
            TBBOX.alert(this,"Không có khách hàng đuoc chọn");
             
            
        }
    }//GEN-LAST:event_butqrActionPerformed

    private void cbbloaikhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbloaikhItemStateChanged
       if(cbbloaikh.getSelectedIndex()==0){
          butqr.setEnabled(false);
          txtmakh.setText("0");
//          txtmanv.setText(Auth.user.getManv());
          txttenkh.setText("KHÁCH VÃN LAI");
          txttglap.setText(XDate.toString(XDate.now(),"dd-MM-yyyy HH:mm:ss"));
          txtkm.setText("KHÔNG CÓ");
      }
      else if(cbbloaikh.getSelectedIndex()==1){
          butqr.setEnabled(true);
          clear();
      }
    }//GEN-LAST:event_cbbloaikhItemStateChanged

    private void cbbloaikhAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbbloaikhAncestorAdded
       if(cbbloaikh.getSelectedIndex()==0){
          butqr.setEnabled(false);
          txtmakh.setText("0");
//          txtmanv.setText(Auth.user.getManv());
          txttenkh.setText("KHÁCH VÃN LAI");
          txttglap.setText(XDate.toString(XDate.now(),"dd-MM-yyyy HH:mm:ss"));
          txtkm.setText("KHÔNG CÓ");
      }
      else if(cbbloaikh.getSelectedIndex()==1){
          butqr.setEnabled(true);
          clear();
      }
    }//GEN-LAST:event_cbbloaikhAncestorAdded

    private void butthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butthemActionPerformed
      if(TBBOX.confirm(this, "Chắn Chắn Thêm")){
          if(kttt()){
          them();
      }
      }
    }//GEN-LAST:event_butthemActionPerformed

    private void butxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butxoaActionPerformed
       if(TBBOX.confirm(this, "Chắn Chắn Xóa")){
          if(kttt()){
          xoa();
      }
      }
    }//GEN-LAST:event_butxoaActionPerformed

    private void butsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butsuaActionPerformed
      if(TBBOX.confirm(this, "Chắn Chắn Sưa")){
          if(kttt()){
          sua();
      }
      }
    }//GEN-LAST:event_butsuaActionPerformed

    private void tblbillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbillMouseClicked
        display(tblbill.getSelectedRow());
        LuuBill.clear();
        LuuBill.bill=dao.selectByid(Integer.parseInt(txtmabill.getText()));
    }//GEN-LAST:event_tblbillMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       if(LuuBill.bill!=null){
           btntrangthai.setText("Đã Có Mã Bill:"+LuuBill.bill.getMabill());
           ktbill();
           loadbilltable();
            loattbill();
       }
       else{
           if(!TBBOX.confirm(this, "Bạn Cần Cập Nhật Bill đúng không")){
           ktbill();
           TBBOX.alert(this, "Bạn Cần Tạo Bill Hoặc Chọn Bill Trước Khi Mua Hàng");
           }
           else{
               ktbill();
               TBBOX.alert(this, "Mời Bạn tiếp tục");
            loattbill();
           loattbilldtt();
           }
           
       }
       
       
    }//GEN-LAST:event_jTabbedPane1MouseClicked
void ktbill(){
    if(LuuBill.bill==null){
        for(JButton b:but){
            b.setEnabled(false);
        }
        butlammoihd.setEnabled(false);
        butcapnhatsp.setEnabled(false);
        butxoasp.setEnabled(false);
        butxacnhan.setEnabled(false);
        butta.setEnabled(false);
    }
    else{
        gangttsk();
        butlammoihd.setEnabled(true);
        butcapnhatsp.setEnabled(true);
        butxoasp.setEnabled(true);
        butxacnhan.setEnabled(true);
        butta.setEnabled(true);
    }
}
    private void may6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may6ActionPerformed
         LUUMT.user=listmt.get(5);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may6ActionPerformed

    private void may2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may2ActionPerformed
        LUUMT.user=listmt.get(1);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may2ActionPerformed

    private void may3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may3ActionPerformed
        LUUMT.user=listmt.get(2);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may3ActionPerformed

    private void may4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may4ActionPerformed
         LUUMT.user=listmt.get(3);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may4ActionPerformed

    private void may5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may5ActionPerformed
        LUUMT.user=listmt.get(4);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may5ActionPerformed

    private void may7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may7ActionPerformed
       LUUMT.user=listmt.get(6);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may7ActionPerformed

    private void may8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may8ActionPerformed
         LUUMT.user=listmt.get(7);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may8ActionPerformed

    private void may9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may9ActionPerformed
        LUUMT.user=listmt.get(8);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may9ActionPerformed

    private void may10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may10ActionPerformed
         LUUMT.user=listmt.get(9);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may10ActionPerformed

    private void may11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may11ActionPerformed
        LUUMT.user=listmt.get(10);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may11ActionPerformed

    private void may12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may12ActionPerformed
        LUUMT.user=listmt.get(11);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may12ActionPerformed

    private void may13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may13ActionPerformed
        LUUMT.user=listmt.get(12);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may13ActionPerformed

    private void may14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may14ActionPerformed
        LUUMT.user=listmt.get(13);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may14ActionPerformed

    private void may15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may15ActionPerformed
         LUUMT.user=listmt.get(14);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_may15ActionPerformed

    private void may17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_may17ActionPerformed
        LUUMT.user=listmt.get(16);
        new BookPCJDialog(null,true).setVisible(true);loadbilltable();
        gangttsk();
        filltong();
        loadbilltable();
    }//GEN-LAST:event_may17ActionPerformed

    private void jButton192ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton192ActionPerformed
         LUUMT.user=listmt.get(18);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_jButton192ActionPerformed

    private void jButton193ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton193ActionPerformed
         LUUMT.user=listmt.get(19);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_jButton193ActionPerformed

    private void jButton186ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton186ActionPerformed
        LUUMT.user=listmt.get(20);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_jButton186ActionPerformed

    private void jButton188ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton188ActionPerformed
        LUUMT.user=listmt.get(21);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_jButton188ActionPerformed

    private void jButton194ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton194ActionPerformed
         LUUMT.user=listmt.get(22);
        new BookPCJDialog(null,true).setVisible(true);loadbilltable();
        gangttsk();
        loadbilltable();
        filltong();
    }//GEN-LAST:event_jButton194ActionPerformed

    private void jButton197ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton197ActionPerformed
         LUUMT.user=listmt.get(23);
        new BookPCJDialog(null,true).setVisible(true);loadbilltable();
        gangttsk();
        filltong();
        loadbilltable();
    }//GEN-LAST:event_jButton197ActionPerformed

    private void jButton198ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton198ActionPerformed
        LUUMT.user=listmt.get(26);
        new BookPCJDialog(null,true).setVisible(true);loadbilltable();
        gangttsk();
        filltong();
        loadbilltable();
    }//GEN-LAST:event_jButton198ActionPerformed

    private void jButton195ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton195ActionPerformed
        LUUMT.user=listmt.get(27);
        new BookPCJDialog(null,true).setVisible(true);
        loadbilltable();
        gangttsk();
        filltong();
    }//GEN-LAST:event_jButton195ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(TBBOX.confirm(this, "Chắc Chắn Clear")){
            clear();
            LuuBill.clear();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void butlammoihdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butlammoihdActionPerformed
       ADDLIST();
        gangttsk();
       loadbilltable();
       filltong();
    }//GEN-LAST:event_butlammoihdActionPerformed

    private void butcapnhatspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butcapnhatspActionPerformed
      if(TBBOX.confirm(this, "Chắc Chắn Cập Nhật")){
          updatesl();
          fillTable();
          filltong();
          loadbilltable();
      }
    }//GEN-LAST:event_butcapnhatspActionPerformed

    private void butxoaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butxoaspActionPerformed
     xoatamtbill();
    }//GEN-LAST:event_butxoaspActionPerformed

    private void butxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butxacnhanActionPerformed
      if(TBBOX.confirm(this, "Xác Nhận Đơn Hàng")){
          updatebill();
      }
    }//GEN-LAST:event_butxacnhanActionPerformed

    private void tbltrangthaibillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltrangthaibillMouseClicked
        displaytt(tbltrangthaibill.getSelectedRow());
    }//GEN-LAST:event_tbltrangthaibillMouseClicked

    private void txttongtienttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtienttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtienttActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(TBBOX.confirm(this, "Chắn chắn clear")){
            cleartt();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buthtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buthtActionPerformed
       if(TBBOX.confirm(this, "Chắc Chắn Hoành Thành")){
           if(kttt_hoanthanh()){
               LuuBill.bill=dao.selectByid(Integer.parseInt(txtmabilltt.getText()));
                hoanthanh();
                loadbilltable();
                gangttsk();
                
           }
       }
    }//GEN-LAST:event_buthtActionPerformed

    private void tbltrangthaibilldttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltrangthaibilldttMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbltrangthaibilldttMouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        loattbilldtt();
    }//GEN-LAST:event_jTabbedPane2MouseClicked
void updatebill(){
    try {
        BillDao bildao=new BillDao();
    Bill bill=bildao.selectByid(Integer.parseInt(txtmabill.getText()));
   if(txttong.getText().equalsIgnoreCase("")){
       bill.setTong(null);
   }else{
        bill.setTong(Double.parseDouble(txttong.getText()));
   }
    
    bildao.update(bill);
    TBBOX.alert(this, "Xác Nhận Đơn Hàng Thành Công");
    } catch (Exception e) {
        TBBOX.alert(this, "đã xảy ra lỗi");
        System.out.println(e);
    }
}
    void updatesl(){
        try {
             for(int i=0;i<tbldatu.getRowCount();i++){
        if(tbldatu.getValueAt(i,5).equals("Đồ Ăn")){
            try {
                int vttru=String.valueOf(tbldatu.getValueAt(i,0)).indexOf("-");
          String mata =String.valueOf(tbldatu.getValueAt(i, 0)).substring(vttru+1);
          BillTaDao billtadao=new BillTaDao();
          Bill_food billta=billtadao.selectByid(Integer.parseInt(txtmabill.getText()),mata);
          int soluong=Integer.parseInt(tbldatu.getValueAt(i, 3).toString());
          //kt thuc an con lai
          ThucAnDao tadao=new ThucAnDao();
          thuan ta=tadao.selectByid(mata);
              if(ta.getSoLuong()<soluong){
                  TBBOX.alert(this, "số lượng trong kho không còn đủ");
                  return;
              }  
         billta.setSoluong(soluong);
         double tong=soluong*Float.parseFloat(tbldatu.getValueAt(i, 2).toString());
         billta.setPrice(tong);
         billtadao.update(billta);
         
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        else{
            TBBOX.alert(this, "LƯU Ý Không được cập nhật số lượng máy tính");
        }
    }
    TBBOX.alert(this, "cập nhật thành công");
        } catch (Exception e) {
            TBBOX.alert(this, "đã xảy ra lỗi");
        }
    
}
void xoatamtbill(){
    if(TBBOX.confirm(this,"Bạn chắc chắn muốn xóa")){
           try {
               

                   System.out.println(tbldatu.getSelectedRows());
             for(int row:tbldatu.getSelectedRows()){
                if(tbldatu.getValueAt(row, 5).equals("Máy Tính")){
                   int vttru=String.valueOf(tbldatu.getValueAt(row,0)).indexOf("-");
          String mata =String.valueOf(tbldatu.getValueAt(row, 0)).substring(vttru+1);
          billmtdao.delete(Integer.parseInt(txtmabill.getText()), mata);
          MayTinhDao mtdao=new MayTinhDao();
          mayTinh mt=mtdao.selectByid(mata);
          mt.setStatus("trống");
          mtdao.update(mt);
                }
                else{
                    int vttru=String.valueOf(tbldatu.getValueAt(row,0)).indexOf("-");
          String mata =String.valueOf(tbldatu.getValueAt(row, 0)).substring(vttru+1);
           BillTaDao billtadao=new BillTaDao();
           billtadao.delete(Integer.parseInt(txtmabill.getText()), mata);
           ThucAnDao tadao=new ThucAnDao();
           thuan ta=tadao.selectByid(mata);
           int soluong=Integer.parseInt(tbldatu.getValueAt(row, 3).toString());
           ta.setSoLuong(ta.getSoLuong()+soluong);
           tadao.update(ta);
                }
            }
             TBBOX.alert(this,"Xóa thành công");
               ADDLIST();
                  gangttsk();
                    loadbilltable();
                 filltong();
                  
        } catch (Exception e) {
            TBBOX.alert(this, "đã xãy ra lỗi");
               System.out.println(e);
        }
                
          
                
            }
          
}
    void filltong(){
    try {
        double tong = 0;
            List<bill_pc> list=billmtdao.selectAll();
            for(bill_pc b:list){
                if(b.getMabill()==LuuBill.bill.getMabill()){
                 mayTinh m=mtdao.selectByid(b.getMamt());
//                tong+=b.getPrice();
                
                }
               
            }
            BillTaDao billtad=new BillTaDao();
            List<Bill_food> listbillfood=billtad.selectAll();
            for(Bill_food bta:listbillfood){
                 if(bta.getMabill()==LuuBill.bill.getMabill()){
                     ThucAnDao thucandao=new ThucAnDao();
                thuan ta=thucandao.selectByid(bta.getMata());
                tong+=bta.getPrice();
                 }
               txttong.setText(String.valueOf(tong));
               if(LuuBill.bill.getMakh().equalsIgnoreCase("0")){
                   txtkhuyenmait.setText("0");
                   txtthanhtien.setText(""+tong);
                   
               }else{
                   txtkhuyenmait.setText("15%");
                   txtthanhtien.setText(""+(tong*0.85));
               }
               
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Lỗi Truy Vấn");
            System.out.println(e);
        }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Hoadon dialog = new Hoadon(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.dispose();
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btntrangthai;
    private javax.swing.JButton butcapnhatsp;
    private javax.swing.JButton butht;
    private javax.swing.JButton butlammoihd;
    private javax.swing.JButton butqr;
    private javax.swing.JButton butsua;
    private javax.swing.JButton butta;
    private javax.swing.JButton butthem;
    private javax.swing.JButton butxacnhan;
    private javax.swing.JButton butxoa;
    private javax.swing.JButton butxoasp;
    private javax.swing.JComboBox<String> cbbloaikh;
    private javax.swing.JComboBox<String> cbbtttt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton185;
    private javax.swing.JButton jButton186;
    private javax.swing.JButton jButton188;
    private javax.swing.JButton jButton191;
    private javax.swing.JButton jButton192;
    private javax.swing.JButton jButton193;
    private javax.swing.JButton jButton194;
    private javax.swing.JButton jButton195;
    private javax.swing.JButton jButton196;
    private javax.swing.JButton jButton197;
    private javax.swing.JButton jButton198;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton may1;
    private javax.swing.JButton may10;
    private javax.swing.JButton may11;
    private javax.swing.JButton may12;
    private javax.swing.JButton may13;
    private javax.swing.JButton may14;
    private javax.swing.JButton may15;
    private javax.swing.JButton may16;
    private javax.swing.JButton may17;
    private javax.swing.JButton may2;
    private javax.swing.JButton may3;
    private javax.swing.JButton may4;
    private javax.swing.JButton may5;
    private javax.swing.JButton may6;
    private javax.swing.JButton may7;
    private javax.swing.JButton may8;
    private javax.swing.JButton may9;
    private javax.swing.JTable tblbill;
    private javax.swing.JTable tbldatu;
    private javax.swing.JTable tbltrangthaibill;
    private javax.swing.JTable tbltrangthaibilldtt;
    private javax.swing.JPanel test;
    private javax.swing.JTextField txtkhuyenmait;
    private javax.swing.JTextField txtkm;
    private javax.swing.JTextField txtmabill;
    private javax.swing.JTextField txtmabilltt;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtmakhtt;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtmanvtt;
    private javax.swing.JTextField txttenkh;
    private javax.swing.JTextField txttgbdtt;
    private javax.swing.JTextField txttgkttt;
    private javax.swing.JTextField txttglap;
    private javax.swing.JTextField txtthanhtien;
    private javax.swing.JTextField txttong;
    private javax.swing.JTextField txttongtientt;
    // End of variables declaration//GEN-END:variables

    private void init() {
        fillTable();
    }

    private void fillTable() {
        DefaultTableModel model=(DefaultTableModel) tblbill.getModel();
        model.setRowCount(0);
        try {
            List<Bill> list=dao.selectAll();
            for(Bill b:list){
               if(!b.isTrangthai()){
                    Object[] row={b.getMabill(),b.getMakh(),b.getManv(),XDate.toString(b.getTglap(),"dd-MM-yyyy HH:mm:ss")};
                model.addRow(row);
               }
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Lỗi Truy Vấn");
            System.out.println(e);
        }
    }
    List<Bill> billvuatao=new ArrayList<>();
    private void display(int i){
        for(Bill bill:listbill){
            if(!bill.isTrangthai()){
                billvuatao.add(bill);
            }
        }
        Bill b=billvuatao.get(i);
        txtmabill.setText(""+b.getMabill());
        txtmakh.setText(b.getMakh());
        txtmanv.setText(b.getManv());
        txttglap.setText(b.getTglap().toString());
        txttenkh.setText(new KhachHangDao().selectByid(b.getMakh()).getTenkh());
        if(b.getMakh().equalsIgnoreCase("0")){
            txtkm.setText("Không Có Khuyến Mãi");
        }
        else{
            txtkm.setText("15%");
        }
        
    }
    private void clear(){
        txtmabill.setText("");
        txtmakh.setText("");
        txttenkh.setText("");
        txtmanv.setText("");
        txttglap.setText("");
        txtkm.setText("");
    }
    private void them(){
        Bill b=new Bill();
        b.setMakh(txtmakh.getText());
        b.setManv(txtmanv.getText());
        b.setTglap(XDate.now());
        b.setTong(0.0);
        b.setTrangthai(false);
        try {
           dao.insert(b);
           TBBOX.alert(this, "Thêm Thành Công");
           fillTable();
           listbill=dao.selectAll();
           clear();
        } catch (Exception e) {
            TBBOX.alert(this, "Đã Xảy Ra Lỗi");
            System.out.println(e);
        }
    }
    private void sua(){
        Bill b=new Bill();
        b.setMabill(Integer.parseInt(txtmabill.getText()));
        b.setMakh(txtmakh.getText());
        b.setManv(txtmanv.getText());
        b.setTglap(XDate.toDate(txttglap.getText(), "yyyy-MM-dd HH:mm:ss"));
        b.setTong(0.0);
        b.setTrangthai(false);
        try {
            Bill t=dao.selectByid(b.getMabill());
            if(t!=null){
                 dao.update(b);
           TBBOX.alert(this, "Cập Nhật Thành Công");
           fillTable();
           listbill=dao.selectAll();
           clear();
            }
            else{
                TBBOX.alert(this, "Bill Không Tồn Tại");
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Đã Xảy Ra Lỗi");
            System.out.println(e);
        }
    }
    private void xoa(){
        try {
            Bill b=listbill.get(tblbill.getSelectedRow());
            if(b!=null){
                dao.delete(b.getMabill());
                TBBOX.alert(this, "Xóa Thành Công");
           fillTable();
           listbill=dao.selectAll();
           clear();
            }
            else{
                TBBOX.alert(this, "Bill Không Tồn Tại");
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Đã Xãy Ra Lỗi");
            System.out.println(e);
        }
    }
    private boolean kttt(){
        if(txtmakh.getText().equals("") ||txtmakh.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
            txtmakh.requestFocus();
            return false;
        }
         if(txtmanv.getText().equals("") ||txtmanv.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
            txtmanv.requestFocus();
            return false;
        }
          if(txttglap.getText().equals("") ||txttglap.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
            txttglap.requestFocus();
            return false;
        }
           if(txtkm.getText().equals("") ||txtkm.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
            txtkm.requestFocus();
            return false;
        }
           else{
               return true;
           }
    }

    private void openQRCODE() {
        new QRCODEDJ(null,true).setVisible(true);
    }
    //load trang thai bill
    private void loattbill() {
        DefaultTableModel model=(DefaultTableModel) tbltrangthaibill.getModel();
        model.setRowCount(0);
        try {
            List<Bill> list=dao.selectAll();
            
            for(Bill b:list){
                if(!b.isTrangthai()){
                     Object[] row={b.getMabill(),b.getMakh(),b.getManv(),XDate.toString(b.getTglap(),"dd-MM-yyyy HH:mm:ss"),b.getTong(),b.isTrangthai()};
                model.addRow(row);
                }
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Lỗi Truy Vấn");
            System.out.println(e);
        }
    }
      private void loattbilldtt() {
        
        DefaultTableModel model=(DefaultTableModel) tbltrangthaibilldtt.getModel();
        model.setRowCount(0);
        try {
            List<Bill> list=dao.selectAll();
            for(Bill b:list){
               if(b.isTrangthai()){
                    Object[] row={b.getMabill(),b.getMakh(),b.getManv(),XDate.toString(b.getTglap(),"dd-MM-yyyy HH:mm:ss"),b.getTong(),b.isTrangthai()};
                model.addRow(row);
               }
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Lỗi Truy Vấn");
            System.out.println(e);
        }
    }
    private void displaytt(int i){
        try {
            for(Bill bill:listbill){
            if(!bill.isTrangthai()){
                billvuatao.add(bill);
            }
        }
            Bill b=billvuatao.get(i);
            if(b.isTrangthai()){
                txtmabilltt.setText(""+b.getMabill());
        txtmakhtt.setText(b.getMakh());
        txtmanvtt.setText(b.getManv());
        txttgkttt.setText(XDate.toString(XDate.now(), "dd-MM-yyyy HH:mm:ss"));
        txttgbdtt.setText(b.getTglap().toString());
        double tongta=b.getTong();
        List<bill_pc> billpc=billmtdao.selectAll();
        
        for(bill_pc bill:billpc){
            if(bill.getMabill()==Integer.parseInt(txtmabilltt.getText())){
                Date vao=bill.getStart();
                Date ra=XDate.now();
                long minis=ra.getTime()-vao.getTime();
                long minutes = minis / (1000 * 60);
                double hours = minutes / 60.0;
                double soGioTinhTien;
            }
        }
        if(!b.getMakh().equalsIgnoreCase("0")){
            txttongtientt.setText(String.valueOf(tongta));
        }
        else{
            txttongtientt.setText(String.valueOf(tongta));
        }
        if(b.isTrangthai()){
            cbbtttt.setSelectedIndex(1);
        }
        else{
           cbbtttt.setSelectedIndex(0);
        }
        
            }
            else{
        txtmabilltt.setText(""+b.getMabill());
        txtmakhtt.setText(b.getMakh());
        txtmanvtt.setText(b.getManv());
        txttgkttt.setText(XDate.toString(XDate.now(), "dd-MM-yyyy HH:mm:ss"));
        txttgbdtt.setText(b.getTglap().toString());
        double tongta=b.getTong();
        List<bill_pc> billpc=billmtdao.selectAll();
        
        for(bill_pc bill:billpc){
            if(bill.getMabill()==Integer.parseInt(txtmabilltt.getText())){
                Date vao=bill.getStart();
                Date ra=XDate.now();
                long minis=ra.getTime()-vao.getTime();
                long minutes = minis / (1000 * 60);
                double hours = minutes / 60.0;
                double soGioTinhTien;
        if (minutes % 60 > 30) {
            soGioTinhTien = Math.ceil(hours);
        } else {
            soGioTinhTien = Math.floor(hours) + 0.5;
        }
        mayTinh mt=mtdao.selectByid(bill.getMamt());
        double tien=mt.getTientheogio();
        tongta+=tien*soGioTinhTien;
            }
        }
        if(!b.getMakh().equalsIgnoreCase("0")){
            txttongtientt.setText(String.valueOf(tongta*0.85));
        }
        else{
            txttongtientt.setText(String.valueOf(tongta));
        }
        if(b.isTrangthai()){
            cbbtttt.setSelectedIndex(1);
        }
        else{
           cbbtttt.setSelectedIndex(0);
        }}
            if(b.isTrangthai()){
                butht.setEnabled(false);
            }
            else{
                butht.setEnabled(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    private void cleartt(){
        txtmabilltt.setText("");
        txtmakhtt.setText("");
        txtmanvtt.setText("");
        txttgbdtt.setText("");
        txttgkttt.setText("");
        txttongtientt.setText("");
    }
    private void hoanthanh(){
        Bill b=dao.selectByid(Integer.parseInt(txtmabilltt.getText()));
        b.setMabill(Integer.parseInt(txtmabilltt.getText()));
        b.setMakh(txtmakhtt.getText());
        b.setManv(txtmanvtt.getText());
        b.setTglap(XDate.toDate(txttgbdtt.getText(), "yyyy-MM-dd HH:mm:ss"));
        bill_pc billpc=billmtdao.selectByid(Integer.parseInt(txtmabilltt.getText()));
        double tong=0;
        if(billpc!=null){
            
        billpc.setEnd(XDate.now());
        billpc.setPrice(Double.parseDouble(txttongtientt.getText()));
        billmtdao.update(billpc);
        mayTinh mt=mtdao.selectByid(billpc.getMamt());
        mt.setStatus("trống");
        mtdao.update(mt);
         tong=b.getTong();
        }
        
        b.setTong(Double.parseDouble(txttongtientt.getText())+tong);
        if(cbbtttt.getSelectedIndex()==0){
            b.setTrangthai(false);
        }
        else{
            b.setTrangthai(true);
        }
        //
       if(TBBOX.confirm(this, "Bạn Muốn Thanh Toán Bằng thẻ thành viên")){
            if(!b.getMakh().equals("0")){
            KhachHangDao khdao=new KhachHangDao();
            khachhang kh=khdao.selectByid(b.getMakh());
            if(kh.getTienconlai()<(Double.parseDouble(txttongtientt.getText())+tong)){
                TBBOX.alert(this, "Số tiền còn lại không đủ để thanh toán");
            }
            else{
                kh.setTienconlai(kh.getTienconlai()-(Double.parseDouble(txttongtientt.getText())+tong));
            khdao.update(kh);
            }
        }
            else{
                TBBOX.alert(this, "bạn không có thẻ thành viên");
                return;
            }
       }
        dao.update(b);
        loattbill();
        listbill=dao.selectAll();
        TBBOX.alert(this, "thanh toán thành công");
 
        
    }
        private boolean kttt_hoanthanh(){
        if(txtmabilltt.getText().equals("") ||txtmabilltt.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
            return false;
        }
         if(txtmakhtt.getText().equals("") ||txtmabilltt.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
            
            return false;
        }
          if(txtmanvtt.getText().equals("") ||txtmanvtt.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
         
            return false;
        }
           if(txttgbdtt.getText().equals("") ||txttgbdtt.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
          
            return false;
        }
            if(txttgkttt.getText().equals("") ||txttgkttt.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
          
            return false;
        }
            if(txttongtientt.getText().equals("") ||txttongtientt.getText()==null){
            TBBOX.alert(this, "Thông Tin Không Được Để Trống");
          
            return false;
        }
           else{
               return true;
           }
    }
}
