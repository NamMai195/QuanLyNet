/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.netsys.gd;

import com.netsys.dao.MayTinhDao;
import com.netsys.entity.mayTinh;
import com.netsys.utlis.TBBOX;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLMayTinh extends javax.swing.JDialog {
private int current;
private  MayTinhDao dao=new MayTinhDao();
private  List<mayTinh> listmt=dao.selectAll();
    public QLMayTinh(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmt = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtsomay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttenmay = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        butthem = new javax.swing.JButton();
        butsua = new javax.swing.JButton();
        butxoa = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        cbbtt = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txttientheogio = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        f = new javax.swing.JButton();
        ff = new javax.swing.JButton();
        n = new javax.swing.JButton();
        nn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        tblmt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Số máy", "Tên máy", "Tiền Theo Giờ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblmt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmt);
        if (tblmt.getColumnModel().getColumnCount() > 0) {
            tblmt.getColumnModel().getColumn(0).setResizable(false);
            tblmt.getColumnModel().getColumn(1).setResizable(false);
            tblmt.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin", jPanel12);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Quản lí máy tính");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Số máy:");

        txtsomay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsomayActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tên máy tính:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Trạng thái:");

        txttenmay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenmayActionPerformed(evt);
            }
        });

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        butthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butthem.setText("Thêm");
        butthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butthemActionPerformed(evt);
            }
        });
        jPanel11.add(butthem);

        butsua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butsua.setText("Sửa");
        butsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butsuaActionPerformed(evt);
            }
        });
        jPanel11.add(butsua);

        butxoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butxoa.setText("Xóa");
        butxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butxoaActionPerformed(evt);
            }
        });
        jPanel11.add(butxoa);

        clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear.setText("Cập nhật");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel11.add(clear);

        cbbtt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbtt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "trống", "đang sử dụng", "bảo trì" }));
        cbbtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbttMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tiền Theo Giờ:");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        f.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f.setText("<");
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });
        jPanel1.add(f);

        ff.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ff.setText("<<");
        ff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ffActionPerformed(evt);
            }
        });
        jPanel1.add(ff);

        n.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        n.setText(">>");
        n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nActionPerformed(evt);
            }
        });
        jPanel1.add(n);

        nn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nn.setText(">");
        nn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nnActionPerformed(evt);
            }
        });
        jPanel1.add(nn);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttenmay, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(txtsomay, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(txttientheogio)
                    .addComponent(cbbtt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsomay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttenmay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttientheogio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        jTabbedPane1.addTab("Quản lí", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsomayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsomayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsomayActionPerformed

    private void txttenmayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenmayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenmayActionPerformed

    private void cbbttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbttMouseClicked

    }//GEN-LAST:event_cbbttMouseClicked

    private void butthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butthemActionPerformed
      if(TBBOX.confirm(this,"Chắn Chắn Thêm")){
          if(kttt()){
              them();
          }
      }
    }//GEN-LAST:event_butthemActionPerformed

    private void butsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butsuaActionPerformed
        if(TBBOX.confirm(this,"Chắn Chắn Sửa")){
            if(kttt()){
                sua();
            }
        }
    }//GEN-LAST:event_butsuaActionPerformed

    private void butxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butxoaActionPerformed
       if(TBBOX.confirm(this,"Chắn Chắn Xóa")){
           if(kttt()){
               xoa();
           }
       }
    }//GEN-LAST:event_butxoaActionPerformed

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
       if(ktList()){
            TBBOX.alert(this,"Chưa có nhân viên nào");
            return;
        }
        else{
            current=0;
            display(current);
        }
    }//GEN-LAST:event_fActionPerformed

    private void ffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ffActionPerformed
       if(ktList()){
            TBBOX.alert(this,"Chưa có nhân viên nào");
            return;
        }
        if(current==0){
            JOptionPane.showMessageDialog(this,"Đang ở đầu danh sách!");
            return;
        }
        current--;
        display(current);
    }//GEN-LAST:event_ffActionPerformed

    private void nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nActionPerformed
        if(ktList()){
            TBBOX.alert(this,"Chưa có nhân viên nào");
            return;
        }
        if(current==listmt.size()-1){
            JOptionPane.showMessageDialog(this,"Đang cuối danh sách!");
            return;
        }
        current++;
        display(current);
    }//GEN-LAST:event_nActionPerformed

    private void nnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nnActionPerformed
           if(ktList()){
            TBBOX.alert(this,"Chưa có nhân viên nào");
            return;
        }
        current=listmt.size()-1;
        display(current);
    }//GEN-LAST:event_nnActionPerformed

    private void tblmtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmtMouseClicked

       listmt=dao.selectAll();
        display(tblmt.getSelectedRow());
    }//GEN-LAST:event_tblmtMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       clear();
    }//GEN-LAST:event_clearActionPerformed

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
            java.util.logging.Logger.getLogger(QLMayTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLMayTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLMayTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLMayTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLMayTinh dialog = new QLMayTinh(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butsua;
    private javax.swing.JButton butthem;
    private javax.swing.JButton butxoa;
    private javax.swing.JComboBox<String> cbbtt;
    private javax.swing.JButton clear;
    private javax.swing.JButton f;
    private javax.swing.JButton ff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton n;
    private javax.swing.JButton nn;
    private javax.swing.JTable tblmt;
    private javax.swing.JTextField txtsomay;
    private javax.swing.JTextField txttenmay;
    private javax.swing.JTextField txttientheogio;
    // End of variables declaration//GEN-END:variables

    private void init() {
        filltable();
        System.out.println(cbbtt.getSelectedItem().toString());
    }

    private void filltable() {
        DefaultTableModel model=(DefaultTableModel) tblmt.getModel();
        model.setRowCount(0);
        try {
            List<mayTinh> list=dao.selectAll();
            for(mayTinh mt:list){
                Object[] row={mt.getMamt(),mt.getTenmt(),mt.getTientheogio(),mt.getStatus()};
                model.addRow(row);
            }
        } catch (Exception e) {
            TBBOX.alert(this,"Lỗi Truy Vấn Dữ Liệu");
        }
    }
    void display(int i){
        mayTinh mt=listmt.get(i);
        txtsomay.setText(mt.getMamt());
        txttenmay.setText(mt.getTenmt());
        txttientheogio.setText(String.valueOf(mt.getTientheogio()));
        if(mt.getStatus().equalsIgnoreCase("trống")){
            cbbtt.setSelectedIndex(0);
        }
        else if(mt.getStatus().equalsIgnoreCase("đang sử dụng")){
            cbbtt.setSelectedIndex(1);
        }
        else {
            cbbtt.setSelectedIndex(2);
        }
    }
    private  boolean  ktList(){
        if(listmt.size()<1){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean kttt(){
        if(txtsomay.getText().equals("") || txtsomay.getText()==null){
            TBBOX.alert(this, "Thông Tin Không được trống");
            txtsomay.requestFocus();
            return false;
        }
        else if(txttenmay.getText().equals("") || txttenmay.getText()==null){
            TBBOX.alert(this, "Thông Tin Không được trống");
            txttenmay.requestFocus();
            return false;
        }
        else if(txttientheogio.getText().equals("") || txttientheogio.getText()==null){
             TBBOX.alert(this, "Thông Tin Không được trống");
             txttientheogio.requestFocus();
             return false;
        }
        else {
            return true;
        }
    }
    private void them(){
        mayTinh mt=new mayTinh();
        mt.setMamt(txtsomay.getText());
        mt.setTenmt(txttenmay.getText());
        mt.setTientheogio(Float.parseFloat(txttientheogio.getText()));
        mt.setStatus(cbbtt.getSelectedItem().toString());
        try {
            mayTinh a=dao.selectByid(txtsomay.getText());
            if(a!=null){
                TBBOX.alert(this,"Máy Tinh Đã Tồn Tại Trong Hệ Thống");
            }
            else{
                dao.insert(mt);
                TBBOX.alert(this,"Thêm Thành Công");
                filltable();
                listmt=dao.selectAll();
                clear();
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Đã Xãy Ra Lỗi");
            System.out.println(e);
           TBBOX.alert(this,mt.getStatus());
        }
    }

    private void clear() {
        txtsomay.setText("");
        txttenmay.setText("");
        txttientheogio.setText("");
        cbbtt.setSelectedIndex(0);
        filltable();
        listmt=dao.selectAll();
    }
    private void sua(){
          mayTinh mt=new mayTinh();
        mt.setMamt(txtsomay.getText());
        mt.setTenmt(txttenmay.getText());
        mt.setTientheogio(Float.parseFloat(txttientheogio.getText()));
        mt.setStatus(cbbtt.getSelectedItem().toString());
        try {
            mayTinh a=dao.selectByid(txtsomay.getText());
            if(a!=null){
                 dao.update(mt);
                TBBOX.alert(this,"Sữa Thành Công");
                filltable();
                listmt=dao.selectAll();
                clear();
            }
            else{
                TBBOX.alert(this,"Máy Tinh Không Tồn Tại Trong Hệ Thống");
            }
        } catch (Exception e) {
            TBBOX.alert(this, "Đã Xãy Ra Lỗi");
            System.out.println(e);
        }
    }
    private void xoa(){
        try {
            mayTinh a=dao.selectByid(txtsomay.getText());
            if(a!=null){
                dao.delete(a.getMamt());
                TBBOX.alert(this,"Xóa Thành Công");
                clear();
                filltable();
                listmt=dao.selectAll();
            }
            else{
                TBBOX.alert(this, "Máy Tinh Không Tồn Tại");
            }
        } catch (Exception e) {
            TBBOX.alert(this,"Đã Xãy Ra Lỗi");
            System.out.println(e);
        }
    }
    
}
