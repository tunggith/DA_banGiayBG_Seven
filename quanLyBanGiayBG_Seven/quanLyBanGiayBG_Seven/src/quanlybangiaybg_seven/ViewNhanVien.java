package quanlybangiaybg_seven;

import Service.NhanVienService;
import Service.NhanVienServiceImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewNhanVien extends javax.swing.JFrame {

    private NhanVienService service = new NhanVienServiceImpl();
    private DefaultTableModel mol = new DefaultTableModel();

    public ViewNhanVien() {
        initComponents();
        this.filltable();

    }

    void filltable() {
        mol = (DefaultTableModel) tblbang.getModel();
        mol.setRowCount(0);
        for (Model.Nhanvien nv : service.getAll()) {
            Object[] toDaTa = new Object[]{
                nv.getIdNhanVien(), nv.getTen(), nv.isGioitinh() ? "nam" : "nu",
                nv.getDienthoai(), nv.getEmail(), nv.getDiachi(), nv.getIdUser()
            };
            mol.addRow(toDaTa);
        }

    }

    void show(int index) {
        index = tblbang.getSelectedRow();
        txtidnhanvien.setText(tblbang.getValueAt(index, 0).toString());
        txtten.setText(tblbang.getValueAt(index, 1).toString());
        String gioiTinh = tblbang.getValueAt(index, 2).toString();
        if (gioiTinh == "nam") {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        txtdienthoai.setText(tblbang.getValueAt(index, 3).toString());
        txtemail.setText(tblbang.getValueAt(index, 4).toString());
        txtdiachi.setText(tblbang.getValueAt(index, 5).toString());

        txtuser.setText(tblbang.getValueAt(index, 6).toString());
    }

    void add() {
        String tenNV = txtten.getText();
        boolean gioiTinh;
        if (rdonam.isSelected()) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        int DT = Integer.parseInt(txtdienthoai.getText());
        String EM = txtemail.getText();
        String DC = txtdiachi.getText();
        int idUS = Integer.parseInt(txtuser.getText());
        Model.Nhanvien nv = new Model.Nhanvien();
        nv.setTen(tenNV);
        nv.setGioitinh(gioiTinh);
        nv.setDienthoai(DT);
        nv.setEmail(EM);
        nv.setDiachi(DC);
        nv.setIdUser(idUS);
        boolean addResult = service.add(nv);
        if (addResult) {
            JOptionPane.showMessageDialog(this, "thêm nhân viên thành công");
        } else {
            JOptionPane.showMessageDialog(this, "thêm nhân viên thất bại.");
        }
        this.filltable();

    }

    void update() {
        int idNV = Integer.parseInt(txtidnhanvien.getText());
        String tenNV = txtten.getText();
        boolean gioiTinh;
        if (rdonam.isSelected()) {
            gioiTinh = true;
        } else {
            gioiTinh = false;
        }
        int DT = Integer.parseInt(txtdienthoai.getText());
        String EM = txtemail.getText();
        String DC = txtdiachi.getText();

        int idUS = Integer.parseInt(txtuser.getText());

        Model.Nhanvien nv = new Model.Nhanvien();
        nv.setIdNhanVien(idNV);
        nv.setTen(tenNV);
        nv.setGioitinh(gioiTinh);
        nv.setDienthoai(DT);
        nv.setEmail(EM);
        nv.setDiachi(DC);

        nv.setIdUser(idUS);
        boolean addResult = service.update(nv);
        if (addResult) {
            JOptionPane.showMessageDialog(this, "sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "sửa thất bại.");
        }
        this.filltable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        btn_trangChu = new javax.swing.JButton();
        btn_banHang = new javax.swing.JButton();
        btn_hoaDon = new javax.swing.JButton();
        btn_sanPham = new javax.swing.JButton();
        btn_khuyenMai = new javax.swing.JButton();
        btn_nhanVien = new javax.swing.JButton();
        btn_dangNhap = new javax.swing.JButton();
        btn_dangxuat = new javax.swing.JButton();
        btn_doiMatKhau = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbang = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btntimkiem = new javax.swing.JButton();
        trhhrtrh = new javax.swing.JLabel();
        gerger = new javax.swing.JLabel();
        ghjg = new javax.swing.JLabel();
        erger = new javax.swing.JLabel();
        trhstr = new javax.swing.JLabel();
        rgr = new javax.swing.JLabel();
        rgeereg = new javax.swing.JLabel();
        txtidnhanvien = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txtdienthoai = new javax.swing.JTextField();
        txtuser = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        txttimkiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User.png"))); // NOI18N
        jButton7.setEnabled(false);

        btn_trangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Home.png"))); // NOI18N
        btn_trangChu.setText("Trang chủ");
        btn_trangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trangChuActionPerformed(evt);
            }
        });

        btn_banHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/business_user.png"))); // NOI18N
        btn_banHang.setText("Bán Hàng");

        btn_hoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/List.png"))); // NOI18N
        btn_hoaDon.setText("Hóa đơn");
        btn_hoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoaDonActionPerformed(evt);
            }
        });

        btn_sanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping_cart.png"))); // NOI18N
        btn_sanPham.setText("Sản Phẩm");
        btn_sanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sanPhamActionPerformed(evt);
            }
        });

        btn_khuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/speaker.png"))); // NOI18N
        btn_khuyenMai.setText("Khuyến mãi");

        btn_nhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/users_1.png"))); // NOI18N
        btn_nhanVien.setText("Nhân viên");

        btn_dangNhap.setText("Đăng nhập");

        btn_dangxuat.setText("Đăng xuất");

        btn_doiMatKhau.setText("Đổi mật khẩu");

        tblbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID NHAN VIEN", "TEN", "GIOI TINH", "DIEN THOAI", "EMAIL", "DIA CHI", "ID USER"
            }
        ));
        tblbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbang);

        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsua.setText("UPDATE");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btntimkiem.setText("TIM KIEM");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        trhhrtrh.setText("ID NHAN VIEN");

        gerger.setText("TEN");

        ghjg.setText("GIOI TINH");

        erger.setText("EMAIL");

        trhstr.setText("DIEN THOAI");

        rgr.setText("DIA CHI");

        rgeereg.setText("ID USER");

        txtdiachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdonam);
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setText("Nu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_nhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_banHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_trangChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_hoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_sanPham)
                                        .addComponent(btn_khuyenMai)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trhhrtrh, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gerger, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(erger, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rgr, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trhstr, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rgeereg, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ghjg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdonam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(rdonu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtdienthoai)
                                        .addComponent(txtemail)
                                        .addComponent(txtidnhanvien)
                                        .addComponent(txtuser)
                                        .addComponent(txtten)
                                        .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(btn_dangNhap)
                                        .addGap(52, 52, 52)
                                        .addComponent(btn_dangxuat)
                                        .addGap(61, 61, 61))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(btnadd)
                                        .addGap(102, 102, 102)
                                        .addComponent(btnsua)
                                        .addGap(101, 101, 101)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_doiMatKhau)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btntimkiem)
                                        .addGap(18, 18, 18)
                                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(21, 21, 21)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_dangNhap)
                            .addComponent(btn_dangxuat)
                            .addComponent(btn_doiMatKhau))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnadd)
                            .addComponent(btnsua)
                            .addComponent(btntimkiem)
                            .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_trangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(trhhrtrh)
                            .addComponent(txtidnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gerger)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ghjg)
                    .addComponent(rdonam)
                    .addComponent(rdonu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_banHang, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trhstr)
                    .addComponent(txtdienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(erger)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rgr)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rgeereg)
                            .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 304, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hoaDonActionPerformed

    private void btn_sanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanPhamActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_sanPhamActionPerformed

    private void btn_trangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trangChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_trangChuActionPerformed

    private void txtdiachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiActionPerformed

    private void tblbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangMouseClicked
        int index = tblbang.getSelectedRow();
        this.show(index);
    }//GEN-LAST:event_tblbangMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
         if(!validates()){
        return;
        }
        this.add();
        this.filltable();

    }//GEN-LAST:event_btnaddActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        if(!validates()){
        return;
        }
        this.update();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
         int id_nhanvien = Integer.parseInt(txttimkiem.getText());
        mol = (DefaultTableModel) tblbang.getModel();
        mol.setRowCount(0);
        for (Model.Nhanvien nv : service.timTheoMa(id_nhanvien)) {
            Object[] toData = new Object[]{
              nv.getIdNhanVien(), nv.getTen(), nv.isGioitinh() ? "nam" : "nu",
                nv.getDienthoai(), nv.getEmail(), nv.getDiachi(), nv.getIdUser()
            };
            mol.addRow(toData);
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewNhanVien().setVisible(true);
            }
        });
    }
    boolean validates(){
        
        if (txtten.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "ten khong duoc de trong");
            return false;
        }
        
        if (txtdienthoai.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "dien thoai khong duoc de trong");
            return false;
        }
        
        if (txtemail.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "email khong duoc de trong");
            return false;
        }
          if (txtdiachi.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "dia chi khong duoc de trong");
            return false;
        }
              if (txtuser.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "user khong duoc de trong");
            return false;
        }
        
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_banHang;
    private javax.swing.JButton btn_dangNhap;
    private javax.swing.JButton btn_dangxuat;
    private javax.swing.JButton btn_doiMatKhau;
    private javax.swing.JButton btn_hoaDon;
    private javax.swing.JButton btn_khuyenMai;
    private javax.swing.JButton btn_nhanVien;
    private javax.swing.JButton btn_sanPham;
    private javax.swing.JButton btn_trangChu;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btntimkiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel erger;
    private javax.swing.JLabel gerger;
    private javax.swing.JLabel ghjg;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JLabel rgeereg;
    private javax.swing.JLabel rgr;
    private javax.swing.JTable tblbang;
    private javax.swing.JLabel trhhrtrh;
    private javax.swing.JLabel trhstr;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtdienthoai;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidnhanvien;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
