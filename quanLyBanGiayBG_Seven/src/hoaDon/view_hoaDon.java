/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hoaDon;

import ConnectionProvider.connectionProvider;
import quanlybangiaybg_seven.*;
import KhuyenMai.view_khuyenMai;
import NhanVien.view_nhanVien;
import ThongKe.View_ThongKe;
import banHang.View_banHang;
import dangNhap.viewDangNhap;
import dangNhap.view_doiMatKhau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import sanPham.view_SanPham;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
//import java.sql.Date;

/**
 *
 * @author MSI
 */
public class view_hoaDon extends javax.swing.JFrame {

    private long count, sotrang, trang, countCt, sotrangCt, trangCt = 1;
    private String dataContructor;

    public view_hoaDon(String dataContructor) {
        initComponents();
        txt_thongTinNv.setText(dataContructor);
        java.util.Date date = new java.util.Date();
        System.out.println(date);
        cbo_trangThai.removeAllItems();
        cbo_trangThai.addItem("đã thanh toán");
        cbo_trangThai.addItem("chờ thanh toán");
        showHoaDon("");
    }

//    public view_hoaDon() {
//        initComponents();
//        txt_thongTinNv.setText(dataContructor);
//        java.util.Date date = new java.util.Date();
//        System.out.println(date);
//        showHoaDon("");
//    }
    void showHoaDon(String search) {
        countHoaDon();
        if (count % 3 == 0) {
            trang = count / 3;
        } else {
            trang = count / 3 + 1;
        }
        loadHoaDon(1, search);
        //System.out.println(trang);
        lbl_soTrangHd.setText("1/" + trang);
    }

    void showHoaDonCt(String search) {
        countHoaDonCt(search);
        if (countCt % 5 == 0) {
            trangCt = countCt / 5;
        } else {
            trangCt = countCt / 5 + 1;
        }
        loadHoaDonCt(1, search);
        //System.out.println(trang);
        lbl_soTrangct.setText("1/" + trangCt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_hoaDon = new javax.swing.JButton();
        btn_sanPham = new javax.swing.JButton();
        btn_khuyenMai = new javax.swing.JButton();
        btn_nhanVien = new javax.swing.JButton();
        btn_banHang = new javax.swing.JButton();
        btn_trangChu = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btn_thongKe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_thongTinNv = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        btn_nextHd = new javax.swing.JButton();
        btn_prevhd = new javax.swing.JButton();
        lbl_soTrangHd = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        btn_timTiem = new javax.swing.JButton();
        txt_ngay = new com.toedter.calendar.JDateChooser();
        btn_timkiemNgay = new javax.swing.JButton();
        cbo_trangThai = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoaDonCt = new javax.swing.JTable();
        btn_prev_ct = new javax.swing.JButton();
        lbl_soTrangct = new javax.swing.JLabel();
        btn_next_ct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

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
        btn_khuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khuyenMaiActionPerformed(evt);
            }
        });

        btn_nhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/users_1.png"))); // NOI18N
        btn_nhanVien.setText("Nhân viên");
        btn_nhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhanVienActionPerformed(evt);
            }
        });

        btn_banHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/business_user.png"))); // NOI18N
        btn_banHang.setText("Bán Hàng");
        btn_banHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_banHangActionPerformed(evt);
            }
        });

        btn_trangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Home.png"))); // NOI18N
        btn_trangChu.setText("Trang chủ");
        btn_trangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trangChuActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/User.png"))); // NOI18N
        jButton7.setEnabled(false);

        btn_thongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Statistics.png"))); // NOI18N
        btn_thongKe.setText("Thống kê");
        btn_thongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_nhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_khuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_hoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_banHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_trangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_banHang, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 153, 153));

        txt_thongTinNv.setText("thông tin nhân viên");
        txt_thongTinNv.setToolTipText("");
        txt_thongTinNv.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_thongTinNv, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txt_thongTinNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id hóa đơn", "tên nhân viên", "Trạng thái", "ngày tạo", "tên khách hàng"
            }
        ));
        tbl_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_hoaDon);

        btn_nextHd.setText(">>");
        btn_nextHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextHdActionPerformed(evt);
            }
        });

        btn_prevhd.setText("<<");
        btn_prevhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevhdActionPerformed(evt);
            }
        });

        jLabel1.setText("Id hóa đơn");

        txt_timKiem.setToolTipText("");

        btn_timTiem.setText("Tìm kiếm");
        btn_timTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timTiemActionPerformed(evt);
            }
        });

        txt_ngay.setDateFormatString("yyyy-MM-dd");

        btn_timkiemNgay.setText("Tìm kiếm");
        btn_timkiemNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemNgayActionPerformed(evt);
            }
        });

        cbo_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trangThaiActionPerformed(evt);
            }
        });

        jLabel2.setText("Ngày tạo");

        jLabel3.setText("Trạng thái");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_prevhd)
                .addGap(18, 18, 18)
                .addComponent(lbl_soTrangHd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nextHd)
                .addGap(198, 198, 198))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timTiem)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timkiemNgay)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_timTiem)
                                .addComponent(jLabel2))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_timkiemNgay)
                                .addComponent(txt_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nextHd)
                    .addComponent(btn_prevhd)
                    .addComponent(lbl_soTrangHd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));

        tbl_hoaDonCt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id hóa đơn chi tiết", "id hóa đơn", "Tên sản phẩm", "số lượng", "đơn giá", "thể loại", "chất liệu", "thương hiệu", "nhà cung cấp", "tên màu", "size"
            }
        ));
        jScrollPane1.setViewportView(tbl_hoaDonCt);

        btn_prev_ct.setText("<<");
        btn_prev_ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prev_ctActionPerformed(evt);
            }
        });

        lbl_soTrangct.setText("jLabel1");

        btn_next_ct.setText(">>");
        btn_next_ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_next_ctActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(btn_prev_ct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_soTrangct, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_next_ct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_prev_ct)
                    .addComponent(lbl_soTrangct)
                    .addComponent(btn_next_ct)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoaDonActionPerformed
        JOptionPane.showMessageDialog(null, "bạn đang ở chức năng hóa đơn");
    }//GEN-LAST:event_btn_hoaDonActionPerformed

    private void btn_khuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khuyenMaiActionPerformed
        view_khuyenMai viewKM = new view_khuyenMai(txt_thongTinNv.getText());
        viewKM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_khuyenMaiActionPerformed

    private void btn_trangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trangChuActionPerformed
        view_backGroud viewbg = new view_backGroud(txt_thongTinNv.getText());
        viewbg.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_trangChuActionPerformed

    private void btn_sanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanPhamActionPerformed
        view_SanPham viewSp = new view_SanPham(txt_thongTinNv.getText());
        viewSp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_sanPhamActionPerformed

    private void btn_banHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_banHangActionPerformed
        View_banHang viewBh = new View_banHang(txt_thongTinNv.getText(), "");
        viewBh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_banHangActionPerformed

    private void btn_nextHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextHdActionPerformed
        if (sotrang < trang) {
            sotrang++;
            loadHoaDon(sotrang, "");
            //lbl_soTrang.setText("" + sotrang);
            lbl_soTrangHd.setText(sotrang + "/" + trang);
        }
    }//GEN-LAST:event_btn_nextHdActionPerformed

    private void btn_prevhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevhdActionPerformed
        if (sotrang > 1) {
            sotrang--;
            loadHoaDon(sotrang, "");
            //lbl_soTrang.setText("" + sotrang);
            lbl_soTrangHd.setText(sotrang + "/" + trang);
        }
    }//GEN-LAST:event_btn_prevhdActionPerformed

    private void btn_prev_ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prev_ctActionPerformed
        int index = tbl_hoaDon.getSelectedRow();
        String id_hoaDon = tbl_hoaDon.getValueAt(index, 0).toString();
        if (sotrangCt > 1) {
            sotrangCt--;
            loadHoaDonCt(sotrangCt, id_hoaDon);
            //lbl_soTrang.setText("" + sotrang);
            lbl_soTrangct.setText(sotrangCt + "/" + trangCt);
        }
    }//GEN-LAST:event_btn_prev_ctActionPerformed

    private void btn_next_ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_next_ctActionPerformed
        if (sotrangCt < trangCt) {
            sotrangCt++;
            int index = tbl_hoaDon.getSelectedRow();
            String id_hoaDon = tbl_hoaDon.getValueAt(index, 0).toString();
            loadHoaDonCt(sotrangCt, id_hoaDon);
            //lbl_soTrang.setText("" + sotrang);
            lbl_soTrangct.setText(sotrangCt + "/" + trangCt);
        }
    }//GEN-LAST:event_btn_next_ctActionPerformed

    private void tbl_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoaDonMouseClicked
        int index = tbl_hoaDon.getSelectedRow();
        String id_hoaDon = tbl_hoaDon.getValueAt(index, 0).toString();
        showHoaDonCt(id_hoaDon);
    }//GEN-LAST:event_tbl_hoaDonMouseClicked

    private void btn_nhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhanVienActionPerformed
        view_nhanVien viewNv = new view_nhanVien(txt_thongTinNv.getText());
        viewNv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_nhanVienActionPerformed

    private void btn_thongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeActionPerformed
        View_ThongKe viewTK = new View_ThongKe(txt_thongTinNv.getText());
        viewTK.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_thongKeActionPerformed

    private void btn_timkiemNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemNgayActionPerformed
        Date search = txt_ngay.getDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        if (search == null) {
            JOptionPane.showMessageDialog(null, "bạn chưa nhập tên nhân viên cần tìm");
        } else {
            searchNgay(1, sdf.format(search));
            DefaultTableModel mol = new DefaultTableModel();
            mol = (DefaultTableModel) tbl_hoaDonCt.getModel();
            mol.setRowCount(0);
            System.out.println(search);
        }
    }//GEN-LAST:event_btn_timkiemNgayActionPerformed

    private void cbo_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trangThaiActionPerformed
        int index = cbo_trangThai.getSelectedIndex();
        String search;
        if (index == 0) {
            search = "1";
            searchNhanVien(1, search);
            DefaultTableModel mol = new DefaultTableModel();
            mol = (DefaultTableModel) tbl_hoaDonCt.getModel();
            mol.setRowCount(0);
        } else {
            search = "0";
            searchNhanVien(1, search);
            DefaultTableModel mol = new DefaultTableModel();
            mol = (DefaultTableModel) tbl_hoaDonCt.getModel();
            mol.setRowCount(0);
        }
    }//GEN-LAST:event_cbo_trangThaiActionPerformed

    private void btn_timTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timTiemActionPerformed
        String search = txt_timKiem.getText();
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(null, "vui lòng nhập id hóa đơn muốn tìm");
        } else if (search.matches("[0-9]+")) {
            showHoaDon(search);
            DefaultTableModel mol = new DefaultTableModel();
            mol = (DefaultTableModel) tbl_hoaDonCt.getModel();
            mol.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(null, "id không phải là sô");
        }
    }//GEN-LAST:event_btn_timTiemActionPerformed

    void countHoaDon() {
        Connection conn = connectionProvider.getConnection();
        try {
            String sql = "Select count (id_hoaDon) from hoaDon";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                count = rs.getLong(1);
                System.out.println(count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadHoaDon(long soTrang, String search) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_hoaDon.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            if (search.equals("")) {
                String sql = "SELECT TOP 3 hd.id_hoaDon, nv.hoTen, hd.trangThai, hd.ngayTao, kh.hoTen "
                        + "FROM hoaDon hd "
                        + "JOIN nhanVien nv ON hd.id_nhanVien = nv.id_nhanVien "
                        + "JOIN khachHang kh ON hd.id_khachHang = kh.id_khachHang "
                        + "WHERE hd.id_hoaDon NOT IN (SELECT TOP " + (soTrang * 3 - 3) + " id_hoaDon FROM hoaDon)";
                Connection con = connectionProvider.getConnection();
                Statement stm = con.createStatement();
                rs = stm.executeQuery(sql);
            } else {
                String sql = "SELECT TOP 3 hd.id_hoaDon, nv.hoTen, hd.trangThai, hd.ngayTao, kh.hoTen "
                        + "FROM hoaDon hd "
                        + "JOIN nhanVien nv ON hd.id_nhanVien = nv.id_nhanVien "
                        + "JOIN khachHang kh ON hd.id_khachHang = kh.id_khachHang "
                        + "WHERE hd.id_hoaDon NOT IN (SELECT TOP " + (soTrang * 3 - 3) + " id_hoaDon FROM hoaDon) "
                        + "AND hd.id_hoaDon = ?";
                Connection con = connectionProvider.getConnection();
                PreparedStatement prm = con.prepareStatement(sql);
                prm.setString(1, search);
                rs = prm.executeQuery();
            }
            while (rs.next()) {
                int id_hoaDon = Integer.parseInt(rs.getString(1));
                String tenNhanvien = rs.getString(2);
                int trangThai = Integer.parseInt(rs.getString(3));
                String checkTT;
                if (trangThai == 1) {
                    checkTT = "đã thanh toán";
                } else {
                    checkTT = "chờ thanh toán";
                }
                String ngaytao = rs.getString(4);
                String tenkhachHang = rs.getString(5);

                Vector vt = new Vector();
                vt.add(id_hoaDon);
                vt.add(tenNhanvien);
                vt.add(checkTT);
                vt.add(ngaytao);
                vt.add(tenkhachHang);
                mol.addRow(vt);
                //System.out.println(mol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void countHoaDonCt(String id_hoaDon) {
        Connection conn = connectionProvider.getConnection();
        try {
            String sql = "Select count (id_hoaDon) from hoaDonCT where id_hoaDon = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, id_hoaDon);
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                countCt = rs.getLong(1);
                System.out.println(countCt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //tìm kiếm theo tên nhân viên
    void searchNhanVien(long soTrang, String search) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_hoaDon.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            String sql = "SELECT TOP 3 hd.id_hoaDon, nv.hoTen, hd.trangThai, hd.ngayTao, kh.hoTen "
                    + "FROM hoaDon hd "
                    + "JOIN nhanVien nv ON hd.id_nhanVien = nv.id_nhanVien "
                    + "JOIN khachHang kh ON hd.id_khachHang = kh.id_khachHang "
                    + "WHERE hd.id_hoaDon NOT IN (SELECT TOP " + (soTrang * 3 - 3) + " id_hoaDon FROM hoaDon) "
                    + "AND hd.trangThai = ?";
            Connection con = connectionProvider.getConnection();
            PreparedStatement prm = con.prepareStatement(sql);
            prm.setString(1, search);
            rs = prm.executeQuery();
            while (rs.next()) {
                int id_hoaDon = Integer.parseInt(rs.getString(1));
                String tenNhanvien = rs.getString(2);
                int trangThai = Integer.parseInt(rs.getString(3));
                String checkTT;
                if (trangThai == 1) {
                    checkTT = "đã thanh toán";
                } else {
                    checkTT = "chờ thanh toán";
                }
                String ngaytao = rs.getString(4);
                String tenkhachHang = rs.getString(5);

                Vector vt = new Vector();
                vt.add(id_hoaDon);
                vt.add(tenNhanvien);
                vt.add(checkTT);
                vt.add(ngaytao);
                vt.add(tenkhachHang);
                mol.addRow(vt);
                //System.out.println(mol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void searchNgay(long soTrang, String search) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_hoaDon.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            String sql = "SELECT TOP 3 hd.id_hoaDon, nv.hoTen, hd.trangThai, hd.ngayTao, kh.hoTen "
                    + "FROM hoaDon hd "
                    + "JOIN nhanVien nv ON hd.id_nhanVien = nv.id_nhanVien "
                    + "JOIN khachHang kh ON hd.id_khachHang = kh.id_khachHang "
                    + "WHERE hd.id_hoaDon NOT IN (SELECT TOP " + (soTrang * 3 - 3) + " id_hoaDon FROM hoaDon) "
                    + "AND hd.ngayTao = ?";
            Connection con = connectionProvider.getConnection();
            PreparedStatement prm = con.prepareStatement(sql);
            prm.setString(1, search);
            rs = prm.executeQuery();
            while (rs.next()) {
                int id_hoaDon = Integer.parseInt(rs.getString(1));
                String tenNhanvien = rs.getString(2);
                int trangThai = Integer.parseInt(rs.getString(3));
                String checkTT;
                if (trangThai == 1) {
                    checkTT = "đã thanh toán";
                } else {
                    checkTT = "chờ thanh toán";
                }
                String ngaytao = rs.getString(4);
                String tenkhachHang = rs.getString(5);

                Vector vt = new Vector();
                vt.add(id_hoaDon);
                vt.add(tenNhanvien);
                vt.add(checkTT);
                vt.add(ngaytao);
                vt.add(tenkhachHang);
                mol.addRow(vt);
                //System.out.println(mol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadHoaDonCt(long soTrangCt, String search) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_hoaDonCt.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            String sql = "SELECT TOP 5 hd.id_hoaDonCt,hd.id_hoaDon,sp.tenSanPham,hd.soLuong,ct.gia,tl.tenTheLoai,cl.tenChatLieu,th.tenThuongHieu,ncc.tenNhaCungCap,m.tenMau,ct.size\n"
                    + "FROM hoaDonCT hd\n"
                    + "join sanPhamCt ct on hd.id_sanPhamCt = ct.id_sanPhamCt\n"
                    + "join sanPham sp on ct.id_sanPham = sp.id_sanPham\n"
                    + "join theloai tl on ct.id_theLoai = tl.id_theLoai\n"
                    + "join chatLieu cl on ct.id_chatLieu = cl.id_chatLieu\n"
                    + "join thuongHieu th on ct.id_thuongHieu = th.id_thuongHieu\n"
                    + "join nhaCungCap ncc on ct.id_nhaCungCap = ncc.id_nhaCungCap\n"
                    + "join mau m on ct.id_mau = m.id_mau\n"
                    + "WHERE hd.id_hoaDon NOT IN (SELECT TOP " + (soTrangCt * 5 - 5) + " id_hoaDon FROM hoaDon)\n"
                    + "and id_hoaDon = ?";
            Connection con = connectionProvider.getConnection();
            PreparedStatement prm = con.prepareStatement(sql);
            prm.setString(1, search);
            rs = prm.executeQuery();
            while (rs.next()) {
                int id_hoaDonCt = Integer.parseInt(rs.getString(1));
                int id_hoaDon = Integer.parseInt(rs.getString(2));
                String tenSp = rs.getString(3);
                int soLuong = Integer.parseInt(rs.getString(4));
                double gia = Double.parseDouble(rs.getString(5));
                String theLoai = rs.getString(6);
                String chatLieu = rs.getString(7);
                String thuongHieu = rs.getString(8);
                String nhaCungCap = rs.getString(9);
                String mau = rs.getString(10);
                int size = Integer.parseInt(rs.getString(11));

                Vector vt = new Vector();
                vt.add(id_hoaDonCt);
                vt.add(id_hoaDon);
                vt.add(tenSp);
                vt.add(soLuong);
                vt.add(gia);
                vt.add(theLoai);
                vt.add(chatLieu);
                vt.add(thuongHieu);
                vt.add(nhaCungCap);
                vt.add(mau);
                vt.add(size);
                mol.addRow(vt);
                //System.out.println(mol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(view_hoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_hoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_hoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_hoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new view_hoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_banHang;
    private javax.swing.JButton btn_hoaDon;
    private javax.swing.JButton btn_khuyenMai;
    private javax.swing.JButton btn_nextHd;
    private javax.swing.JButton btn_next_ct;
    private javax.swing.JButton btn_nhanVien;
    private javax.swing.JButton btn_prev_ct;
    private javax.swing.JButton btn_prevhd;
    private javax.swing.JButton btn_sanPham;
    private javax.swing.JButton btn_thongKe;
    private javax.swing.JButton btn_timTiem;
    private javax.swing.JButton btn_timkiemNgay;
    private javax.swing.JButton btn_trangChu;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_soTrangHd;
    private javax.swing.JLabel lbl_soTrangct;
    private javax.swing.JTable tbl_hoaDon;
    private javax.swing.JTable tbl_hoaDonCt;
    private com.toedter.calendar.JDateChooser txt_ngay;
    private javax.swing.JTextField txt_thongTinNv;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
