/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.netsys.gd;

import com.netsys.utlis.Auth;
import com.netsys.utlis.TBBOX;
import java.awt.Button;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 *
 * @author ASUS
 */
public class NetSySJframe extends javax.swing.JFrame {

    /**
     * Creates new form giaodienchinh
     */
    public NetSySJframe() {
        initComponents();
        this.setLocationRelativeTo(null);
        new ChaoJDialog(this, true).setVisible(true);
        new DangnhapJDialog(this, true).setVisible(true);
        new ChaoJDialog(this, true).setVisible(true);
        xetuser();
        xetvaitro();
    }
void xetuser(){
        if(Auth.isLogin()==false){
            TBBOX.alert(this, "BẠN CHƯA ĐĂNG NHẬP");
            System.exit(0);
        }
        xetvaitro();
        
    }
    void xetvaitro(){
        if(Auth.isManager()){
            txttrangthai.setText("Trưởng Phòng");
        }
        else{
            txttrangthai.setText("Nhân Viên");
            btndoanhthu.setEnabled(false);
            
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        butnhanvien = new javax.swing.JButton();
        butmt = new javax.swing.JButton();
        butta = new javax.swing.JButton();
        butkh = new javax.swing.JButton();
        buthoadon = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttrangthai = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menudmk = new javax.swing.JMenuItem();
        menuthoat = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menunv = new javax.swing.JMenuItem();
        menuta = new javax.swing.JMenuItem();
        menumt = new javax.swing.JMenuItem();
        btndoanhthu = new javax.swing.JMenu();
        menuDT = new javax.swing.JMenuItem();
        menuGSD = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menugt = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        butnhanvien.setBackground(new java.awt.Color(0, 0, 0));
        butnhanvien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butnhanvien.setForeground(new java.awt.Color(204, 255, 255));
        butnhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/User.png"))); // NOI18N
        butnhanvien.setText("Nhân Viên");
        butnhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butnhanvienActionPerformed(evt);
            }
        });
        jPanel2.add(butnhanvien);

        butmt.setBackground(new java.awt.Color(0, 0, 0));
        butmt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butmt.setForeground(new java.awt.Color(204, 255, 255));
        butmt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/maytinh.png"))); // NOI18N
        butmt.setText("Máy Tính");
        butmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butmtActionPerformed(evt);
            }
        });
        jPanel2.add(butmt);

        butta.setBackground(new java.awt.Color(0, 0, 0));
        butta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butta.setForeground(new java.awt.Color(204, 255, 255));
        butta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/thuan.png"))); // NOI18N
        butta.setText("Thức Ăn");
        butta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttaActionPerformed(evt);
            }
        });
        jPanel2.add(butta);

        butkh.setBackground(new java.awt.Color(0, 0, 0));
        butkh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butkh.setForeground(new java.awt.Color(204, 255, 255));
        butkh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/Users.png"))); // NOI18N
        butkh.setText("Khách Hàng");
        butkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butkhActionPerformed(evt);
            }
        });
        jPanel2.add(butkh);

        buthoadon.setBackground(new java.awt.Color(0, 0, 0));
        buthoadon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buthoadon.setForeground(new java.awt.Color(204, 255, 255));
        buthoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/Price list.png"))); // NOI18N
        buthoadon.setText("Hóa Đơn");
        buthoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buthoadonActionPerformed(evt);
            }
        });
        jPanel2.add(buthoadon);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/rs/logochaorise.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, 800));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 750, -1, 50));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/Refresh.png"))); // NOI18N
        jLabel1.setText("Trạng Thái:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/Alarm.png"))); // NOI18N
        jLabel3.setText("Thời Gian:");

        txttrangthai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttrangthai.setText("Trưởng Phòng.");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("00.00.00");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/netsys/icon_app/chuong.png"))); // NOI18N
        jButton1.setText("Thông Tin");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttrangthai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(55, 55, 55)
                .addComponent(jButton1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttrangthai)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuBar2.setBackground(new java.awt.Color(102, 102, 255));
        jMenuBar2.setBorder(null);

        jMenu5.setText("Hệ Thống");

        jMenuItem3.setText("Đăng Xuất");
        jMenu5.add(jMenuItem3);

        menudmk.setText("Đổi Mật Khẩu");
        menudmk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menudmkActionPerformed(evt);
            }
        });
        jMenu5.add(menudmk);

        menuthoat.setText("Thoát");
        menuthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuthoatActionPerformed(evt);
            }
        });
        jMenu5.add(menuthoat);

        jMenuBar2.add(jMenu5);

        jMenu6.setText("Quản Lý");

        menunv.setText("Nhân Viên");
        menunv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menunvActionPerformed(evt);
            }
        });
        jMenu6.add(menunv);

        menuta.setText("Thức Ăn");
        menuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menutaActionPerformed(evt);
            }
        });
        jMenu6.add(menuta);

        menumt.setText("Máy Tính");
        menumt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menumtActionPerformed(evt);
            }
        });
        jMenu6.add(menumt);

        jMenuBar2.add(jMenu6);

        btndoanhthu.setText("Thống Kê");

        menuDT.setText("Doanh Thu");
        menuDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDTActionPerformed(evt);
            }
        });
        btndoanhthu.add(menuDT);

        menuGSD.setText("Giờ Sử Dụng");
        menuGSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGSDActionPerformed(evt);
            }
        });
        btndoanhthu.add(menuGSD);

        jMenuBar2.add(btndoanhthu);

        jMenu8.setText("Trợ Giúp");

        menugt.setText("Giới Thiệu");
        menugt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menugtActionPerformed(evt);
            }
        });
        jMenu8.add(menugt);

        jMenuItem11.setText("Hướng Dẫn Sử Dụng");
        jMenu8.add(jMenuItem11);

        jMenuBar2.add(jMenu8);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buthoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buthoadonActionPerformed
        this.openHOADON();
    }//GEN-LAST:event_buthoadonActionPerformed

    private void menuthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuthoatActionPerformed
        if(TBBOX.confirm(this,"BẠN CHẮC CHẮN MUỐN THOÁT")){
            System.exit(0);
        }
    }//GEN-LAST:event_menuthoatActionPerformed

    private void menugtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menugtActionPerformed
      this.openGT();
    }//GEN-LAST:event_menugtActionPerformed

    private void butkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butkhActionPerformed
       this.openQLKH();
    }//GEN-LAST:event_butkhActionPerformed

    private void butmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butmtActionPerformed
      this.openMT();
    }//GEN-LAST:event_butmtActionPerformed

    private void menudmkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menudmkActionPerformed
      this.openDMK();
    }//GEN-LAST:event_menudmkActionPerformed

    private void menunvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menunvActionPerformed
       this.ôpenNhanVien();
    }//GEN-LAST:event_menunvActionPerformed

    private void menutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menutaActionPerformed
       this.openTHUCAN();
    }//GEN-LAST:event_menutaActionPerformed

    private void menumtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menumtActionPerformed
     this.openMT();
    }//GEN-LAST:event_menumtActionPerformed

    private void menuDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDTActionPerformed
      this.openThongKe();
    }//GEN-LAST:event_menuDTActionPerformed

    private void menuGSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGSDActionPerformed
       this.openThongKe();
    }//GEN-LAST:event_menuGSDActionPerformed

    private void butnhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butnhanvienActionPerformed
    this.ôpenNhanVien();
    }//GEN-LAST:event_butnhanvienActionPerformed

    private void buttaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttaActionPerformed
    this.openTHUCAN();
    }//GEN-LAST:event_buttaActionPerformed

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
            java.util.logging.Logger.getLogger(NetSySJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NetSySJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NetSySJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NetSySJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NetSySJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btndoanhthu;
    private javax.swing.JButton buthoadon;
    private javax.swing.JButton butkh;
    private javax.swing.JButton butmt;
    private javax.swing.JButton butnhanvien;
    private javax.swing.JButton butta;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JMenuItem menuDT;
    private javax.swing.JMenuItem menuGSD;
    private javax.swing.JMenuItem menudmk;
    private javax.swing.JMenuItem menugt;
    private javax.swing.JMenuItem menumt;
    private javax.swing.JMenuItem menunv;
    private javax.swing.JMenuItem menuta;
    private javax.swing.JMenuItem menuthoat;
    private javax.swing.JLabel txttrangthai;
    // End of variables declaration//GEN-END:variables
    private void openDMK() {
      new DoimatkhauJDialog(this, true).setVisible(true);
    }

    private void ôpenNhanVien() {
       new QuanLyNVJDialog(this,true).setVisible(true);
    }

    private void openTHUCAN() {
      new QLThucAnJDialog(this,true).setVisible(true);
    }

    private void openMT() {
        new QLMayTinh(this, true).setVisible(true);
    }

    private void openThongKe() {
        new ThongKeDiaLog(this, true).setVisible(true);
    }

    private void openGT() {
        new GioiThieuJDialog(this, true).setVisible(true);
    }

    private void openQLKH() {
        new QLKH(this, true).setVisible(true);
    }

    private void openHOADON() {
       new Hoadon(this, true).setVisible(true);
    }
    
}
