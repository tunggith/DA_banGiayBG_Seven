package ThongKe;

import banHang.banHangService_IMPL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import ConnectionProvider.connectionProvider;
import KhuyenMai.view_khuyenMai;
import NhanVien.view_nhanVien;
import banHang.View_banHang;
import hoaDon.view_hoaDon;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import quanlybangiaybg_seven.view_backGroud;
import sanPham.view_SanPham;

/**
 *
 * @author sontr
 */
public class View_ThongKe extends javax.swing.JFrame {

    private ThongKeService thService = new ThongKeServiceImpl();
    private DefaultTableModel mol = new DefaultTableModel();
    private List<ThongKe> thongKe;
    long count, soTrang, trang = 1;
    Statement st;
    ResultSet rs;
    private String dataContructor;

    public View_ThongKe(String dataContructor) {
        initComponents();
        txt_thongTinNv.getText();
        txt_thongTinNv.setText(dataContructor);
        this.setLocationRelativeTo(null);
//        Tong();
        TongTheoNgay();
        TongTheoThang12();
        TongTheoNam2023();
        //phân trang
        countDb();
        if (count % 5 == 0) {
            soTrang = count / 5;
        } else {
            soTrang = count / 5 + 1;
        }
        this.loadData(1);
        lblSoTrang.setText("1/" + soTrang);
        lblTrang.setText("1");
    }

    void hoaDon() {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tblTK.getModel();
        mol.setRowCount(0);
        for (ThongKe x : thService.getAll()) {
            Object[] toData = new Object[]{
                x.getId_hoaDonCt(), x.getId_hoaDon(), x.getId_sanPham(),
                x.getSoLuong(), x.getGia(), x.getId_nhanVien(), x.checkTT(),
                x.getNgayTao(), x.getTenSP(), x.getIdTL(), x.getIdCL(), x.getIdTH(), x.getIdNCC(), x.getIdMau(), x.getSize()};
            mol.addRow(toData);
        }
    }

    private void Tong() {
        DecimalFormat x = new DecimalFormat("###,###,###");
        double Tong = 0;

        for (int i = 0; i < tblTK.getRowCount(); i++) {
            Tong += Double.parseDouble(tblTK.getValueAt(i, 4).toString());
        }
        //lblTong.setText("Tổng doanh thu: " + x.format(Tong) + " VND ");
    }

    // doanh thu theo tháng
    private void TongTheoThang12() {
        this.hoaDon();
        DecimalFormat x = new DecimalFormat("###,###,###");
        double TongTheoThang = 0;

        for (int i = 0; i < tblTK.getRowCount(); i++) {
            // Lấy giá trị từ cột ngày (giả sử cột ngày có chỉ số là 4)
            String ngayStr = tblTK.getValueAt(i, 7).toString();

            // Chuyển đổi ngày thành đối tượng Date
            Date ngay;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ngay = sdf.parse(ngayStr);
            } catch (ParseException e) {
                e.printStackTrace();
                continue; // Bỏ qua nếu có lỗi chuyển đổi ngày
            }

            // Kiểm tra xem ngày có thuộc tháng 11 không
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngay);
            int thang = cal.get(Calendar.MONTH) + 1; // Lưu ý: Tháng trong Calendar là 0-indexed
            if (thang == 12) {
                // Nếu ngày thuộc tháng 11, thì cộng vào tổng
                Double giaTien = Double.parseDouble(tblTK.getValueAt(i, 4).toString());
                Double soLuong = Double.parseDouble(tblTK.getValueAt(i, 3).toString());
                Double tong = giaTien * soLuong;
                TongTheoThang += tong;
                //TongTheoThang += Double.parseDouble(tblTK.getValueAt(i, 4).toString()); // Giả sử cột số tiền có chỉ số là 3
            }
        }

        lblTongDTT.setText("Tổng doanh thu tháng: " + x.format(TongTheoThang) + " VND ");
    }

    // doanh thu theo năm
    private void TongTheoNam2023() {
        this.hoaDon();
        DecimalFormat x = new DecimalFormat("###,###,###");
        double TongTheoNam = 0;

        for (int i = 0; i < tblTK.getRowCount(); i++) {
            // Lấy giá trị từ cột ngày (giả sử cột ngày có chỉ số là 7)
            String ngayStr = tblTK.getValueAt(i, 7).toString();

            // Chuyển đổi ngày thành đối tượng Date
            Date ngay;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ngay = sdf.parse(ngayStr);
            } catch (ParseException e) {
                e.printStackTrace();
                continue; // Bỏ qua nếu có lỗi chuyển đổi ngày
            }

            // Kiểm tra xem ngày có thuộc tháng 11 năm 2023 không
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngay);
            int nam = cal.get(Calendar.YEAR);
            if (nam == 2023) {
                // Nếu ngày thuộc tháng 11, thì cộng vào tổng
                Double giaTien = Double.parseDouble(tblTK.getValueAt(i, 4).toString());
                Double soLuong = Double.parseDouble(tblTK.getValueAt(i, 3).toString());
                Double tong = giaTien * soLuong;
                TongTheoNam += tong; // Giả sử cột số tiền có chỉ số là 4
            }
        }

        lblTongDTNam.setText("Tổng doanh thu năm: " + x.format(TongTheoNam) + " VND ");
    }

    // doanh thu theo ngày
    private void TongTheoNgay() {
        this.hoaDon();
        DecimalFormat x = new DecimalFormat("###,###,###");
        double TongTheoNgay = 0;

        // Ngày bạn quan tâm (ví dụ: "2023-11-15")
        LocalDate ngayCanTinh = LocalDate.now();
        //System.out.println("ngày "+ngay);
        //String ngayCanTinh = "2023-12-07";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ngayTinh = sdf.parse(String.valueOf(ngayCanTinh));

            for (int i = 0; i < tblTK.getRowCount(); i++) {
                // Lấy giá trị từ cột ngày (giả sử cột ngày có chỉ số là 7)
                String ngayStr = tblTK.getValueAt(i, 7).toString();

                // Chuyển đổi ngày thành đối tượng Date
                Date ngay;
                ngay = sdf.parse(ngayStr);

                // Kiểm tra xem ngày có phù hợp với ngày bạn quan tâm không
                if (ngay.equals(ngayTinh)) {
                    // Nếu có, cộng vào tổng
                    Double giaTien = Double.parseDouble(tblTK.getValueAt(i, 4).toString());
                    Double soLuong = Double.parseDouble(tblTK.getValueAt(i, 3).toString());
                    Double tong = giaTien * soLuong;
                    TongTheoNgay += tong; // Giả sử cột số tiền có chỉ số là 4
                }
            }

            lblTongDTNgay.setText("Tổng doanh thu ngày " + ": " + x.format(TongTheoNgay) + " VND ");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txt_thongTinNv = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTK = new javax.swing.JTable();
        lblTongDTT = new javax.swing.JLabel();
        lblTongDTNam = new javax.swing.JLabel();
        lblTongDTNgay = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        lblTrang = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblSoTrang = new javax.swing.JLabel();
        btn_xemBieuDo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_hoaDon = new javax.swing.JButton();
        btn_sanPham = new javax.swing.JButton();
        btn_khuyenMai = new javax.swing.JButton();
        btn_nhanVien = new javax.swing.JButton();
        btn_banHang = new javax.swing.JButton();
        btn_trangChu = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btn_thongKe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt_thongTinNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));

        tblTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id hóa đơn ct", "id hóa đơn", "tên sản phẩm", "số lượng", "đơn giá", "tên nhân viên", "ngày Tạo", "thể loại", "tên chất liệu", "tên thương hiệu", "tên nhà cung cấp", "tên màu", "Size", "tổng tiền"
            }
        ));
        tblTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTKMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTK);

        lblTongDTT.setBackground(new java.awt.Color(0, 255, 255));
        lblTongDTT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongDTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping_cart_accept.png"))); // NOI18N
        lblTongDTT.setText("Tổng doanh thu: ");

        lblTongDTNam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongDTNam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping_cart_accept.png"))); // NOI18N
        lblTongDTNam.setText("Tổng doanh thu: ");

        lblTongDTNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongDTNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping_cart_accept.png"))); // NOI18N
        lblTongDTNgay.setText("Tổng doanh thu: ");

        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setText("<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        lblTrang.setText("....");

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblSoTrang.setText("......");

        btn_xemBieuDo.setText("Xem biểu đồ");
        btn_xemBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemBieuDoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblTongDTNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(lblTongDTT, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(lblTongDTNam, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(btnFirst)
                        .addGap(18, 18, 18)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_xemBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongDTT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongDTNam, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongDTNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_xemBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst)
                            .addComponent(btnPre)
                            .addComponent(lblTrang)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext)
                            .addComponent(btnLast)
                            .addComponent(lblSoTrang))))
                .addGap(119, 119, 119))
        );

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
                .addComponent(btn_thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoaDonActionPerformed
        view_hoaDon viewHd = new view_hoaDon(txt_thongTinNv.getText());
        viewHd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_hoaDonActionPerformed

    private void btn_sanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sanPhamActionPerformed
        view_SanPham viewSp = new view_SanPham(txt_thongTinNv.getText());
        viewSp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_sanPhamActionPerformed

    private void btn_khuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khuyenMaiActionPerformed
        view_khuyenMai viewKM = new view_khuyenMai(txt_thongTinNv.getText());
        viewKM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_khuyenMaiActionPerformed

    private void btn_banHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_banHangActionPerformed
        View_banHang viewBh = new View_banHang(txt_thongTinNv.getText(), "");
        viewBh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_banHangActionPerformed

    private void btn_trangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trangChuActionPerformed
        view_backGroud viewBg = new view_backGroud(txt_thongTinNv.getText());
        viewBg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_trangChuActionPerformed

    private void tblTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTKMouseClicked

    }//GEN-LAST:event_tblTKMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        trang = 1;
        loadData(trang);
        lblTrang.setText("1");
        lblSoTrang.setText("1/" + soTrang);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        if (trang > 1) {
            trang--;
            loadData(trang);
            lblTrang.setText("" + trang);
            lblSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (trang < soTrang) {
            trang++;
            loadData(trang);
            lblTrang.setText("" + trang);
            lblSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        trang = soTrang;
        loadData(trang);
        lblTrang.setText("" + soTrang);
        lblSoTrang.setText(soTrang + "/" + soTrang);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btn_thongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeActionPerformed
        JOptionPane.showMessageDialog(null, "bạn đang ở chức năng thống kê");
    }//GEN-LAST:event_btn_thongKeActionPerformed

    private void btn_nhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhanVienActionPerformed
        view_nhanVien viewNv = new view_nhanVien(txt_thongTinNv.getText());
        viewNv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_nhanVienActionPerformed

    private void btn_xemBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemBieuDoActionPerformed
        try {
            String sql = "SELECT hd.ngayTao, SUM(ct.donGia * soLuong) AS tongTien\n"
                    + "FROM hoaDon hd\n"
                    + "JOIN hoaDonCT ct ON hd.id_hoaDon = ct.id_hoaDon\n"
                    + "GROUP BY hd.ngayTao;";
            Connection conn = connectionProvider.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            JFreeChart jChart = null;
            DefaultCategoryDataset barchartData = new DefaultCategoryDataset();
            String ngaytest = "2023-12-10";

            // Định dạng của chuỗi ngày
            while (rs.next()) {
                String ngay = rs.getString(1);
                int tongTien = rs.getInt(2);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Chuyển đổi chuỗi ngày thành LocalDate
                LocalDate localDate = LocalDate.parse(ngay, formatter);

                // Lấy ngày và tháng
                int ngayOfMonth = localDate.getDayOfMonth();
                int thang = localDate.getMonthValue();

                // In ra kết quả
                String dateMoth = ngayOfMonth + "-" + thang;
                //System.out.println("Ngày và tháng: " + dateMoth);
                barchartData.setValue(tongTien, "tổng tiền", dateMoth);
                jChart = ChartFactory.createBarChart("thống kê", "Năm 2023", "tổng tiền", barchartData, PlotOrientation.VERTICAL, false, true, false);

            }
            BarRenderer render = null;
            CategoryPlot chart = null;
            render = new BarRenderer();
            //chart.setRangeGridlinePaint(Color.BLUE);
            ChartFrame frame = new ChartFrame("biểu đồ", jChart);
            frame.setVisible(true);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_xemBieuDoActionPerformed

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
            java.util.logging.Logger.getLogger(View_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new View_ThongKe().setVisible(true);
            }
        });
    }
    // phân trang

    public void countDb() {
        Connection conn = connectionProvider.getConnection();
        try {
            String query = "Select count(id_hoaDonCt) from hoaDonCt";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                count = rs.getLong(1);
                System.out.println(count);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadData(long trang) {
        Connection conn = connectionProvider.getConnection();
        mol = (DefaultTableModel) tblTK.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        try {
            String query = "SELECT hdct.id_hoaDonCt, hd.id_hoaDon, sp.tenSanPham, hdct.soLuong, hdct.donGia, nv.hoTen, hd.ngayTao, tl.tenTheLoai, cl.tenChatLieu, th.tenThuongHieu, ncc.tenNhaCungCap, m.tenMau, spct.size\n"
                    + "FROM hoaDon hd \n"
                    + "JOIN hoaDonCT hdct ON hd.id_hoaDon = hdct.id_hoaDon \n"
                    + "JOIN sanPhamCt spct ON hdct.id_sanPhamCt = spct.id_sanPham \n"
                    + "JOIN sanPham sp ON spct.id_sanPham = sp.id_sanPham \n"
                    + "join nhanVien nv on nv.id_nhanVien = hd.id_nhanVien\n"
                    + "join theloai tl on spct.id_theLoai = tl.id_theLoai \n"
                    + "join chatLieu cl on spct.id_chatLieu = cl.id_chatLieu\n"
                    + "join thuongHieu th on spct.id_thuongHieu = th.id_thuongHieu\n"
                    + "join nhaCungCap ncc on spct.id_nhaCungCap = ncc.id_nhaCungCap\n"
                    + "join mau m on spct.id_mau = m.id_mau\n"
                    + "AND NOT EXISTS (SELECT 1 FROM hoaDonCt WHERE hdct.id_hoaDonCt IN (SELECT TOP " + (trang * 5 - 5) + " id_hoaDonCt FROM hoaDonCt))\n"
                    + "ORDER BY hdct.id_hoaDonCt OFFSET " + ((trang - 1) * 5) + " ROWS FETCH NEXT 5 ROWS ONLY";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Vector v = new Vector();
                int id_hoaDonCt = rs.getInt(1);
                int id_hoaDon = rs.getInt(2);
                String tenSp = rs.getString(3);
                int soLuong = rs.getInt(4);
                double donGia = rs.getDouble(5);
                String tenNv = rs.getString(6);
                String ngayTao = rs.getString(7);
                String tenTheloai = rs.getString(8);
                String tenChatLieu = rs.getString(9);
                String tenThuongHieu = rs.getString(10);
                String tenNCC = rs.getString(11);
                String tenMau = rs.getString(12);
                int size = rs.getInt(13);
                //
                v.add(id_hoaDonCt);
                v.add(id_hoaDon);
                v.add(tenSp);
                v.add(soLuong);
                v.add(donGia);
                v.add(tenNv);
                v.add(ngayTao);
                v.add(tenTheloai);
                v.add(tenChatLieu);
                v.add(tenThuongHieu);
                v.add(tenNCC);
                v.add(tenMau);
                v.add(size);
                v.add(donGia + soLuong);
                mol.addRow(v);
                //System.out.println(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btn_banHang;
    private javax.swing.JButton btn_hoaDon;
    private javax.swing.JButton btn_khuyenMai;
    private javax.swing.JButton btn_nhanVien;
    private javax.swing.JButton btn_sanPham;
    private javax.swing.JButton btn_thongKe;
    private javax.swing.JButton btn_trangChu;
    private javax.swing.JButton btn_xemBieuDo;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblSoTrang;
    private javax.swing.JLabel lblTongDTNam;
    private javax.swing.JLabel lblTongDTNgay;
    private javax.swing.JLabel lblTongDTT;
    private javax.swing.JLabel lblTrang;
    private javax.swing.JTable tblTK;
    private javax.swing.JTextField txt_thongTinNv;
    // End of variables declaration//GEN-END:variables

}
