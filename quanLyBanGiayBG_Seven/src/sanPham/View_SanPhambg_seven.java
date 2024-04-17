package sanPham;

import ConnectionProvider.connectionProvider;
import sanPham.ChatLieuServcieImpl;
import sanPham.ChatLieuService;
import sanPham.MauService;
import sanPham.MauServiceImpl;
import sanPham.NhaCCService;
import sanPham.NhaCCServiceImpl;
import sanPham.SanPhamCtServiceImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sanPham.SanPhamCtService;
import sanPham.TheLoaiService;
import sanPham.TheLoaiServiceImpl;
import sanPham.ThuongHieuService;
import sanPham.ThuongHieuServiceImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import static sanPham.view_SanPham.tenSP;

public class View_SanPhambg_seven extends javax.swing.JFrame {

    private SanPhamCtService service = new SanPhamCtServiceImpl();
    private TheLoaiService tlService = new TheLoaiServiceImpl();
    private ChatLieuService clService = new ChatLieuServcieImpl();
    private ThuongHieuService thService = new ThuongHieuServiceImpl();
    private NhaCCService nccService = new NhaCCServiceImpl();
    private MauService mauService = new MauServiceImpl();
    DefaultTableModel mol = new DefaultTableModel();
    private String dataContructor;

    Connection cn;
    long count, soTrang, trang = 1;
    Statement st;
    ResultSet rs;

    public View_SanPhambg_seven(String dataContructor) {
        initComponents();
        setTitle("Sản phẩm chi tiết");
        setLocationRelativeTo(null);
        countDb();
        if (count % 5 == 0) {
            soTrang = count / 5;
        } else {
            soTrang = count / 5 + 1;
        }
        //this.fillTable();
        this.loadData(1, dataContructor);

        // cbo màu
        cboMau.removeAllItems();
        for (sanPham.Mau mau : mauService.getMau()) {
            cboMau.addItem(mau.getTenMau());
        }

        // cbo Thể loại
        cboTL.removeAllItems();
        for (sanPham.TheLoai tl : tlService.getTheLoai()) {
            cboTL.addItem(tl.getTenTheLoai());
        }
        // cbo chất liệu
        cboChatLieu.removeAllItems();
        for (sanPham.ChatLieu cl : clService.getChatLieu()) {
            cboChatLieu.addItem(cl.getTenChatLieu());
        }
        // cbo thương hiệu
        cboThuongHieu.removeAllItems();
        for (sanPham.ThuongHieu th : thService.getThuongHieu()) {
            cboThuongHieu.addItem(th.getTenThuongHieu());
        }
        // cbo nhà cung cấp
        cboNCC.removeAllItems();
        for (sanPham.NhaCungCap ncc : nccService.getNCC()) {
            cboNCC.addItem(ncc.getTenNhaCungCap());
        }
        //phân trang

        lblSoTrang.setText("1/" + soTrang);
        lblTrang.setText("1");
        //lọc
        cboTL1.addItem("Tất cả");
        cboChatLieu1.addItem("Tất cả");
        cboThuongHieu1.addItem("Tất cả");
        cboNCC1.addItem("Tất cả");
        cboMau1.addItem("Tất cả");
        // cbo màu
        //cboMau1.removeAllItems();
        for (sanPham.Mau mau : mauService.getMau()) {
            cboMau1.addItem(mau.getTenMau());
        }
        // cbo Thể loại
        for (sanPham.TheLoai tl : tlService.getTheLoai()) {
            cboTL1.addItem(tl.getTenTheLoai());
        }
        // cbo chất liệu
        for (sanPham.ChatLieu cl : clService.getChatLieu()) {
            cboChatLieu1.addItem(cl.getTenChatLieu());
        }
        // cbo thương hiệu
        for (sanPham.ThuongHieu th : thService.getThuongHieu()) {
            cboThuongHieu1.addItem(th.getTenThuongHieu());
        }
        // cbo nhà cung cấp
        for (sanPham.NhaCungCap ncc : nccService.getNCC()) {
            cboNCC1.addItem(ncc.getTenNhaCungCap());
        }
        fillTimKiemTuSP(dataContructor);
        txt_thongTinNv.setText(view_SanPham.thongTin);
        this.dataContructor = dataContructor;
        this.txtIDSP.setText(dataContructor);
        this.txtTenSP.setText(view_SanPham.tenSP);
    }

    void fillTable() {
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        for (sanPham.SanPhamCt sp : service.getAll()) {
            Object[] toData = new Object[]{
                sp.getIdSanPhamCt(), sp.getiDSanPham(), sp.getTenSP(), sp.getTenTheLoai(), sp.getTenChatLieu(), sp.getTenThuongHieu(),
                sp.getTenNhaCungCap(), sp.getTenMau(), sp.getGia(), sp.getSize(), sp.getSoLuong(), sp.getGhiChu()
            };
            mol.addRow(toData);
        }
    }

    void showSP(int index) {
        index = tbl_SPCT.getSelectedRow();
        txtSPCT.setText(tbl_SPCT.getValueAt(index, 0).toString());
        txtIDSP.setText(tbl_SPCT.getValueAt(index, 1).toString());
        txtTenSP.setText(tbl_SPCT.getValueAt(index, 2).toString());
        // Thể loại
        cboTL.setSelectedItem(tbl_SPCT.getValueAt(index, 3));
        // Chất liệu
        cboChatLieu.setSelectedItem(tbl_SPCT.getValueAt(index, 4));
        // Thương hiệu
        cboThuongHieu.setSelectedItem(tbl_SPCT.getValueAt(index, 5));
        // Nhà cc
        cboNCC.setSelectedItem(tbl_SPCT.getValueAt(index, 6));
        // Màu
        cboMau.setSelectedItem(tbl_SPCT.getValueAt(index, 7));
        txtGia.setText(tbl_SPCT.getValueAt(index, 8).toString());
        txtSize.setText(tbl_SPCT.getValueAt(index, 9).toString());
        txtSoLuong.setText(tbl_SPCT.getValueAt(index, 10).toString());
        String ghiChu = tbl_SPCT.getValueAt(index, 11).toString();
        txtGhiChu.setText(ghiChu);
    }

    void addSPCT() {
        int idSP = Integer.parseInt(txtIDSP.getText());
        int theLoai = cboTL.getSelectedIndex() + 1;
        int chatLieu = cboChatLieu.getSelectedIndex() + 1;
        int thuongHieu = cboThuongHieu.getSelectedIndex() + 1;
        int nhaCC = cboNCC.getSelectedIndex() + 1;
        int mau = cboMau.getSelectedIndex() + 1;
        Double gia = Double.parseDouble(txtGia.getText());
        int size = Integer.parseInt(txtSize.getText());
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        String ghiChu = txtGhiChu.getText();
        // kiểm tra trùng thuộc tính
        if(service.checkTrungTT(idSP, theLoai, chatLieu, thuongHieu, nhaCC, mau)){
            JOptionPane.showMessageDialog(this, "Sản phẩm chi tiết này đã tồn tại.");
            return;
        }
//        // kiểm tra trùng thể loại
//        if (service.checkTrungTheLoai(idSP, theLoai)) {
//            JOptionPane.showMessageDialog(this, "Sản phẩm đã có thể loại này.");
//            return; // Stop execution if category already exists
//        } else {
//            // kiểm tra trùng chất liệu
//            if (service.checkTrungChatLieu(idSP, chatLieu)) {
//                JOptionPane.showMessageDialog(this, "Sản phẩm đã có chất liệu này.");
//                return; // Stop execution if category already exists
//            } else {
//                // kiểm tra trùng thương hiệu
//                if (service.checkTrungThuongHieu(idSP, thuongHieu)) {
//                    JOptionPane.showMessageDialog(this, "Sản phẩm đã có thương hiệu này.");
//                    return; // Stop execution if category already exists
//                } else {
//                    // kiểm tra trùng nhà cung cấp
//                    if (service.checkTrungNhaCC(idSP, nhaCC)) {
//                        JOptionPane.showMessageDialog(this, "Sản phẩm đã có nhà cung cấp này.");
//                        return; // Stop execution if category already exists
//                    } else {
//                        // kiểm tra trùng màu
//                        if (service.checkTrungMau(idSP, mau)) {
//                            JOptionPane.showMessageDialog(this, "Sản phẩm đã có màu này.");
//                            return; // Stop execution if category already exists           
//                        }
//                    }
//                }
//            }
//        }

        sanPham.SanPhamCt spct = new sanPham.SanPhamCt();
        //spct
        spct.setiDSanPham(idSP);
        spct.setIdTL(theLoai);
        spct.setIdCL(chatLieu);
        spct.setIdTH(thuongHieu);
        spct.setIdNCC(nhaCC);
        spct.setIdMau(mau);
        spct.setGia(gia);
        spct.setSize(size);
        spct.setSoLuong(soLuong);
        spct.setGhiChu(ghiChu);
        boolean addResult = service.add(spct);
        if (addResult) {
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công.");
        } else {
            JOptionPane.showMessageDialog(this, "thêm sản phẩm thất bại.");
        }
        this.loadData(trang, "");
    }

    void delete() {
        int idSPCT = Integer.parseInt(txtSPCT.getText());
        sanPham.SanPhamCt sp = new sanPham.SanPhamCt();
        sp.setIdSanPhamCt(idSPCT);
        boolean deleteResult = service.delete(sp);
        if (deleteResult) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
        this.loadData(trang, "");
    }

    void update() {
        int idSPCT = Integer.parseInt(txtSPCT.getText());
        int idSP = Integer.parseInt(txtIDSP.getText());
        int theLoai = cboTL.getSelectedIndex() + 1;
        int chatLieu = cboChatLieu.getSelectedIndex() + 1;
        int thuongHieu = cboThuongHieu.getSelectedIndex() + 1;
        int nhaCC = cboNCC.getSelectedIndex() + 1;
        int mau = cboMau.getSelectedIndex() + 1;
        Double gia = Double.parseDouble(txtGia.getText());
        int size = Integer.parseInt(txtSize.getText());
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        String ghiChu = txtGhiChu.getText();

        sanPham.SanPhamCt sp = new sanPham.SanPhamCt();
        sp.setIdSanPhamCt(idSPCT);
        sp.setiDSanPham(idSP);
        sp.setIdTL(theLoai);
        sp.setIdCL(chatLieu);
        sp.setIdTH(thuongHieu);
        sp.setIdNCC(nhaCC);
        sp.setIdMau(mau);
        sp.setGia(gia);
        sp.setSize(size);
        sp.setSoLuong(soLuong);
        sp.setGhiChu(ghiChu);
        boolean update = service.update(sp);
        if (update) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
        this.loadData(trang, "");
    }

    void clearForm() {
        txtSPCT.setText("");
        txtIDSP.setText("");
        txtTenSP.setText("");
        cboTL.setSelectedIndex(0);
        cboChatLieu.setSelectedIndex(0);
        cboThuongHieu.setSelectedIndex(0);
        cboNCC.setSelectedIndex(0);
        cboMau.setSelectedIndex(0);
        txtGia.setText("");
        txtSize.setText("");
        txtSoLuong.setText("");
        txtGhiChu.setText("");
    }

    void timKiemTheoID() {
        String idSP = txtIDSP.getText();
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);

    }

    public void loadData(long trang, String strIdSp) {
        Connection conn = connectionProvider.getConnection();
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        try {
            if (strIdSp.equals("")) {
                String query = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt] not in (select top " + (trang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt )";
                Statement stm = conn.createStatement();
                rs = stm.executeQuery(query);
            } else {
                String query = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt] not in (select top " + (trang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt )"
                        + "and sanPhamCt.id_sanPham = ?";
                PreparedStatement prm = conn.prepareStatement(query);
                prm.setString(1, strIdSp);
                System.out.println("check:" + strIdSp);
                rs = prm.executeQuery();
            }

            while (rs.next()) {
                Vector v = new Vector();
                int idSPCT = rs.getInt(1);
                int idSP = rs.getInt(2);
                String tenSP = rs.getString(3);
                String theLoai = rs.getString(4);
                String chatLieu = rs.getString(5);
                String thuongHieu = rs.getString(6);
                String nhaCungCap = rs.getString(7);
                String mau = rs.getString(8);
                double gia = rs.getDouble(9);
                int size = rs.getInt(10);
                int soLuong = rs.getInt(11);
                String ghiChu = rs.getString(12);
                v.add(idSPCT);
                v.add(idSP);
                v.add(tenSP);
                v.add(theLoai);
                v.add(chatLieu);
                v.add(thuongHieu);
                v.add(nhaCungCap);
                v.add(mau);
                v.add(gia);
                v.add(size);
                v.add(soLuong);
                v.add(ghiChu);
                mol.addRow(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnSanPham = new javax.swing.JButton();
        txt_thongTinNv = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtSize = new javax.swing.JTextField();
        btnMoi = new javax.swing.JButton();
        cboMau = new javax.swing.JComboBox<>();
        cboTL = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboThuongHieu = new javax.swing.JComboBox<>();
        cboNCC = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtSPCT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnTheLoai = new javax.swing.JButton();
        btnThuongHieu = new javax.swing.JButton();
        btnChatLieu = new javax.swing.JButton();
        btnNCC = new javax.swing.JButton();
        btnMau = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_SPCT = new javax.swing.JTable();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        lblTrang = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblSoTrang = new javax.swing.JLabel();
        cboTL1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cboChatLieu1 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cboThuongHieu1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cboNCC1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cboMau1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setForeground(new java.awt.Color(255, 153, 153));

        btnSanPham.setText("Sản phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_thongTinNv, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSanPham)
                    .addComponent(txt_thongTinNv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setForeground(new java.awt.Color(255, 153, 153));

        jLabel1.setText("Id sản phẩm");

        jLabel2.setText("Tên sản phẩm:");

        jLabel5.setText("Thể loại:");

        jLabel6.setText("Chất liệu:");

        jLabel7.setText("Thương hiệu:");

        jLabel8.setText("Nhà cung cấp:");

        jLabel9.setText("Màu:");

        jLabel10.setText("Giá:");

        jLabel11.setText("Size:");

        jLabel12.setText("Số lượng:");

        jLabel13.setText("Ghi chú:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setText("Làm mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        cboMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboTL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Id sản phẩm ct");

        txtSPCT.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("Thêm Thuộc tính sản phẩm");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTheLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheLoaiActionPerformed(evt);
            }
        });

        btnThuongHieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuongHieuActionPerformed(evt);
            }
        });

        btnChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        btnNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNCCActionPerformed(evt);
            }
        });

        btnMau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        btnMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnMoi))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(1, 1, 1))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIDSP, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                        .addComponent(txtSPCT)
                                        .addComponent(txtTenSP)
                                        .addComponent(cboTL, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMau, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMoi))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setForeground(new java.awt.Color(255, 153, 153));

        jLabel14.setText("Nhập tên sản phẩm");

        btnTimKiem.setText("Tìm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tbl_SPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã spct", "Mã sp", "Tên sp", "Thể loại", "Chất liệu", "Thương hiệu", "Nhà cung cấp", "Màu", "Giá", "Size", "Số lượng", "Ghi chú"
            }
        ));
        tbl_SPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SPCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_SPCT);

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

        lblTrang.setText("jLabel3");

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

        lblSoTrang.setText("jLabel4");

        cboTL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTL1ActionPerformed(evt);
            }
        });

        jLabel17.setText("Thể loại");

        jLabel18.setText("Chất liệu");

        cboChatLieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChatLieu1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Thương hiệu");

        cboThuongHieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHieu1ActionPerformed(evt);
            }
        });

        jLabel20.setText("Nhà cung cấp");

        cboNCC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNCC1ActionPerformed(evt);
            }
        });

        jLabel21.setText("Màu");

        cboMau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMau1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboChatLieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboThuongHieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboMau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem)
                        .addContainerGap(373, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChatLieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThuongHieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNCC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPre)
                    .addComponent(lblTrang)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(lblSoTrang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        this.delete();
        loadData(trang, "");
        fillTimKiemTuSP(dataContructor);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (!validates()) {
            return;
        }
        this.addSPCT();
        fillTimKiemTuSP(dataContructor);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!validates()) {
            return;
        }
        if (Integer.valueOf(txtSize.getText()) >= 50) {
            JOptionPane.showMessageDialog(null, "không tồn tại size quá lơn như vậy");
        } else {
            this.addSPCT();
            fillTimKiemTuSP(dataContructor);
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void tbl_SPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPCTMouseClicked
        // TODO add your handling code here:
        int index = tbl_SPCT.getSelectedRow();
        this.showSP(index);
    }//GEN-LAST:event_tbl_SPCTMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        if (!checkTK()) {
            return;
        }
        String tenSanPham = txtTimKiem.getText();
        fillTimKiem(tenSanPham);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    void fillTimKiem(String tenSanPham) {
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        for (sanPham.SanPhamCt sp : service.timTheoTen(tenSanPham)) {
            Object[] toData = new Object[]{
                sp.getIdSanPhamCt(), sp.getiDSanPham(), sp.getTenSP(), sp.getTenTheLoai(), sp.getTenChatLieu(), sp.getTenThuongHieu(),
                sp.getTenNhaCungCap(), sp.getTenMau(), sp.getGia(), sp.getSize(), sp.getSoLuong(), sp.getGhiChu()
            };
            mol.addRow(toData);
        }
    }

    void fillTimKiemTuSP(String tenSanPham1) {
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        for (sanPham.SanPhamCt sp : service.timTheoTuSP(tenSanPham1)) {
            Object[] toData = new Object[]{
                sp.getIdSanPhamCt(), sp.getiDSanPham(), sp.getTenSP(), sp.getTenTheLoai(), sp.getTenChatLieu(), sp.getTenThuongHieu(),
                sp.getTenNhaCungCap(), sp.getTenMau(), sp.getGia(), sp.getSize(), sp.getSoLuong(), sp.getGhiChu()
            };
            mol.addRow(toData);
        }
    }

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:
        view_SanPham viewSp = new view_SanPham(txt_thongTinNv.getText());
        viewSp.setVisible(true);
        viewSp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        trang = 1;
        loadData(trang, "");
        lblTrang.setText("1");
        lblSoTrang.setText("1/" + soTrang);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        // TODO add your handling code here:
        if (trang > 1) {
            trang--;
            loadData(trang, "");
            lblTrang.setText("" + trang);
            lblSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (trang < soTrang) {
            trang++;
            loadData(trang, "");
            lblTrang.setText("" + trang);
            lblSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        trang = soTrang;
        loadData(trang, "");
        lblTrang.setText("" + soTrang);
        lblSoTrang.setText(soTrang + "/" + soTrang);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheLoaiActionPerformed
        // TODO add your handling code here:
        View_TheLoai theLoai = new View_TheLoai(txtIDSP.getText());
        theLoai.setVisible(true);
        theLoai.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTheLoaiActionPerformed

    private void btnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuActionPerformed
        // TODO add your handling code here:
        View_ChatLieu chatLieu = new View_ChatLieu(txtIDSP.getText());
        chatLieu.setVisible(true);
        chatLieu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnChatLieuActionPerformed

    private void btnThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuongHieuActionPerformed
        // TODO add your handling code here:
        View_ThuongHieu thuongHieu = new View_ThuongHieu(txtIDSP.getText());
        thuongHieu.setVisible(true);
        thuongHieu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnThuongHieuActionPerformed

    private void btnNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNCCActionPerformed
        // TODO add your handling code here:
        View_NhaCC ncc = new View_NhaCC(txtIDSP.getText());
        ncc.setVisible(true);
        ncc.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnNCCActionPerformed

    private void btnMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauActionPerformed
        // TODO add your handling code here:
        View_Mau mau = new View_Mau(txtIDSP.getText());
        mau.setVisible(true);
        mau.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMauActionPerformed

    private void cboTL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTL1ActionPerformed
        int theLoai = cboTL1.getSelectedIndex();
        String strTheLoai;
        System.out.println(theLoai);
        if (theLoai == 1) {
            strTheLoai = "1";
            loadCboTheLoai(1, strTheLoai);
        } else if (theLoai == 2) {
            strTheLoai = "2";
            loadCboTheLoai(1, strTheLoai);
        } else if (theLoai == 3) {
            strTheLoai = "3";
            loadCboTheLoai(1, strTheLoai);
        } else if (theLoai == 4) {
            strTheLoai = "4";
            loadCboTheLoai(1, strTheLoai);
        } else if (theLoai == 5) {
            strTheLoai = "5";
            loadCboTheLoai(1, strTheLoai);
        } else {
            strTheLoai = "Tất cả";
            loadCboTheLoai(1, strTheLoai);
        }
    }//GEN-LAST:event_cboTL1ActionPerformed

    private void cboChatLieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChatLieu1ActionPerformed

        int theLoai = cboChatLieu1.getSelectedIndex();
        String strChatLieu;
        System.out.println(theLoai);
        if (theLoai == 1) {
            strChatLieu = "1";
            loadCboChatLieu(1, strChatLieu);
        } else if (theLoai == 2) {
            strChatLieu = "2";
            loadCboChatLieu(1, strChatLieu);
        } else if (theLoai == 3) {
            strChatLieu = "3";
            loadCboChatLieu(1, strChatLieu);
        } else if (theLoai == 4) {
            strChatLieu = "4";
            loadCboChatLieu(1, strChatLieu);
        } else if (theLoai == 5) {
            strChatLieu = "5";
            loadCboChatLieu(1, strChatLieu);
        } else {
            strChatLieu = "Tất cả";
            loadCboChatLieu(1, strChatLieu);
        }
    }//GEN-LAST:event_cboChatLieu1ActionPerformed

    private void cboThuongHieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuongHieu1ActionPerformed
        int theLoai = cboThuongHieu1.getSelectedIndex();
        String strThuongHieu;
        System.out.println(theLoai);
        if (theLoai == 1) {
            strThuongHieu = "1";
            loadCboThuongHieu(1, strThuongHieu);
        } else if (theLoai == 2) {
            strThuongHieu = "2";
            loadCboThuongHieu(1, strThuongHieu);
        } else if (theLoai == 3) {
            strThuongHieu = "3";
            loadCboThuongHieu(1, strThuongHieu);
        } else if (theLoai == 4) {
            strThuongHieu = "4";
            loadCboThuongHieu(1, strThuongHieu);
        } else if (theLoai == 5) {
            strThuongHieu = "5";
            loadCboThuongHieu(1, strThuongHieu);;
        } else {
            strThuongHieu = "Tất cả";
            loadCboThuongHieu(1, strThuongHieu);
        }
    }//GEN-LAST:event_cboThuongHieu1ActionPerformed

    private void cboNCC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNCC1ActionPerformed
        int theLoai = cboNCC1.getSelectedIndex();
        String strNhaCungCap;
        System.out.println(theLoai);
        if (theLoai == 1) {
            strNhaCungCap = "1";
            loadCboNcc(1, strNhaCungCap);
        } else if (theLoai == 2) {
            strNhaCungCap = "2";
            loadCboNcc(1, strNhaCungCap);
        } else if (theLoai == 3) {
            strNhaCungCap = "3";
            loadCboNcc(1, strNhaCungCap);
        } else if (theLoai == 4) {
            strNhaCungCap = "4";
            loadCboNcc(1, strNhaCungCap);
        } else if (theLoai == 5) {
            strNhaCungCap = "5";
            loadCboNcc(1, strNhaCungCap);
        } else {
            strNhaCungCap = "Tất cả";
            loadCboNcc(1, strNhaCungCap);
        }
    }//GEN-LAST:event_cboNCC1ActionPerformed

    private void cboMau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMau1ActionPerformed
        int theLoai = cboMau1.getSelectedIndex();
        String strMau;
        System.out.println(theLoai);
        if (theLoai == 1) {
            strMau = "1";
            loadCboMau(1, strMau);
        } else if (theLoai == 2) {
            strMau = "2";
            loadCboMau(1, strMau);
        } else if (theLoai == 3) {
            strMau = "3";
            loadCboMau(1, strMau);
        } else if (theLoai == 4) {
            strMau = "4";
            loadCboMau(1, strMau);
        } else if (theLoai == 5) {
            strMau = "5";
            loadCboMau(1, strMau);
        } else if (theLoai == 6) {
            strMau = "6";
            loadCboMau(1, strMau);
        } else if (theLoai == 7) {
            strMau = "7";
            loadCboMau(1, strMau);
        } else if (theLoai == 8) {
            strMau = "8";
            loadCboMau(1, strMau);
        } else {
            strMau = "Tất cả";
            loadCboMau(1, strMau);
        }
    }//GEN-LAST:event_cboMau1ActionPerformed

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
            java.util.logging.Logger.getLogger(View_SanPhambg_seven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_SanPhambg_seven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_SanPhambg_seven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_SanPhambg_seven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new View_SanPhambg_seven().setVisible(true);
            }
        });
    }

    boolean validates() {
        // id sản phẩm
        if (txtIDSP.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Id sản phẩm đang trống");
            return false;
        }
        // giá
        if (txtGia.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm đang trống");
            return false;
        }
        if (Double.parseDouble(txtGia.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm phải lớn hơn 0");
            return false;
        }
        // Size
        if (txtSize.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Size sản phẩm đang trống");
            return false;
        }
        if (Integer.parseInt(txtSize.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Size sản phẩm phải lớn hơn 0");
            return false;
        }
        // Số lượng
        if (txtSoLuong.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "số lượng sản phẩm đang trống");
            return false;
        }
        if (Integer.parseInt(txtSoLuong.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 0");
            return false;
        }

        return true;
    }

    boolean checkTK() {
        // tìm kiếm
        if (txtTimKiem.getText().equals("")) {
            this.loadData(trang, "");
            return false;
        }
        return true;
    }

    // phân trang
    public void countDb() {
        Connection conn = connectionProvider.getConnection();
        try {
            String query = "Select count(id_sanPhamCt) from sanPhamCt";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //cbo thể loại
    void loadCboTheLoai(long sotrang, String strTheLoai) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            if (strTheLoai.equals("Tất cả")) {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)";
                Connection conn = connectionProvider.getConnection();
                Statement stm = conn.createStatement();
                rs = stm.executeQuery(sql);
            } else {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)"
                        + "and tl.id_theLoai = ? ";
                Connection conn = connectionProvider.getConnection();
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, strTheLoai);
                rs = prm.executeQuery();
            }
            while (rs.next()) {
                Vector v = new Vector();
                int idSPCT = rs.getInt(1);
                int idSP = rs.getInt(2);
                String tenSP = rs.getString(3);
                String theLoai = rs.getString(4);
                String chatLieu = rs.getString(5);
                String thuongHieu = rs.getString(6);
                String nhaCungCap = rs.getString(7);
                String mau = rs.getString(8);
                double gia = rs.getDouble(9);
                int size = rs.getInt(10);
                int soLuong = rs.getInt(11);
                String ghiChu = rs.getString(12);
                v.add(idSPCT);
                v.add(idSP);
                v.add(tenSP);
                v.add(theLoai);
                v.add(chatLieu);
                v.add(thuongHieu);
                v.add(nhaCungCap);
                v.add(mau);
                v.add(gia);
                v.add(size);
                v.add(soLuong);
                v.add(ghiChu);
                mol.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // cbo chất liệu
    void loadCboChatLieu(long sotrang, String strChatLieu) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            if (strChatLieu.equals("Tất cả")) {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)";
                Connection conn = connectionProvider.getConnection();
                Statement stm = conn.createStatement();
                rs = stm.executeQuery(sql);
            } else {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)"
                        + "and cl.id_chatLieu = ? ";
                Connection conn = connectionProvider.getConnection();
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, strChatLieu);
                rs = prm.executeQuery();
            }
            while (rs.next()) {
                Vector v = new Vector();
                int idSPCT = rs.getInt(1);
                int idSP = rs.getInt(2);
                String tenSP = rs.getString(3);
                String theLoai = rs.getString(4);
                String chatLieu = rs.getString(5);
                String thuongHieu = rs.getString(6);
                String nhaCungCap = rs.getString(7);
                String mau = rs.getString(8);
                double gia = rs.getDouble(9);
                int size = rs.getInt(10);
                int soLuong = rs.getInt(11);
                String ghiChu = rs.getString(12);
                v.add(idSPCT);
                v.add(idSP);
                v.add(tenSP);
                v.add(theLoai);
                v.add(chatLieu);
                v.add(thuongHieu);
                v.add(nhaCungCap);
                v.add(mau);
                v.add(gia);
                v.add(size);
                v.add(soLuong);
                v.add(ghiChu);
                mol.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //cbo thương hiệu

    void loadCboThuongHieu(long sotrang, String strThuongHieu) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            if (strThuongHieu.equals("Tất cả")) {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)";
                Connection conn = connectionProvider.getConnection();
                Statement stm = conn.createStatement();
                rs = stm.executeQuery(sql);
            } else {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)"
                        + "and th.id_thuongHieu = ? ";
                Connection conn = connectionProvider.getConnection();
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, strThuongHieu);
                rs = prm.executeQuery();
            }
            while (rs.next()) {
                Vector v = new Vector();
                int idSPCT = rs.getInt(1);
                int idSP = rs.getInt(2);
                String tenSP = rs.getString(3);
                String theLoai = rs.getString(4);
                String chatLieu = rs.getString(5);
                String thuongHieu = rs.getString(6);
                String nhaCungCap = rs.getString(7);
                String mau = rs.getString(8);
                double gia = rs.getDouble(9);
                int size = rs.getInt(10);
                int soLuong = rs.getInt(11);
                String ghiChu = rs.getString(12);
                v.add(idSPCT);
                v.add(idSP);
                v.add(tenSP);
                v.add(theLoai);
                v.add(chatLieu);
                v.add(thuongHieu);
                v.add(nhaCungCap);
                v.add(mau);
                v.add(gia);
                v.add(size);
                v.add(soLuong);
                v.add(ghiChu);
                mol.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //cbo nhà cung cấp

    void loadCboNcc(long sotrang, String StrNhaCungCap) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            if (StrNhaCungCap.equals("Tất cả")) {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)";
                Connection conn = connectionProvider.getConnection();
                Statement stm = conn.createStatement();
                rs = stm.executeQuery(sql);
            } else {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)"
                        + "and ncc.id_nhaCungCap = ? ";
                Connection conn = connectionProvider.getConnection();
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, StrNhaCungCap);
                rs = prm.executeQuery();
            }
            while (rs.next()) {
                Vector v = new Vector();
                int idSPCT = rs.getInt(1);
                int idSP = rs.getInt(2);
                String tenSP = rs.getString(3);
                String theLoai = rs.getString(4);
                String chatLieu = rs.getString(5);
                String thuongHieu = rs.getString(6);
                String nhaCungCap = rs.getString(7);
                String mau = rs.getString(8);
                double gia = rs.getDouble(9);
                int size = rs.getInt(10);
                int soLuong = rs.getInt(11);
                String ghiChu = rs.getString(12);
                v.add(idSPCT);
                v.add(idSP);
                v.add(tenSP);
                v.add(theLoai);
                v.add(chatLieu);
                v.add(thuongHieu);
                v.add(nhaCungCap);
                v.add(mau);
                v.add(gia);
                v.add(size);
                v.add(soLuong);
                v.add(ghiChu);
                mol.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //cbo mau
    void loadCboMau(long sotrang, String strMau) {
        DefaultTableModel mol = new DefaultTableModel();
        mol = (DefaultTableModel) tbl_SPCT.getModel();
        mol.setRowCount(0);
        mol.getDataVector().removeAllElements();
        ResultSet rs = null;
        try {
            if (strMau.equals("Tất cả")) {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)";
                Connection conn = connectionProvider.getConnection();
                Statement stm = conn.createStatement();
                rs = stm.executeQuery(sql);
            } else {
                String sql = "SELECT top 5\n"
                        + "	sanPhamCt.id_sanPhamCt,\n"
                        + "    sanPham.id_sanPham,\n"
                        + "    sanPham.tenSanPham,  \n"
                        + "    tl.tenTheLoai,\n"
                        + "    cl.tenChatLieu,\n"
                        + "    th.tenThuongHieu,\n"
                        + "    ncc.tenNhaCungCap,\n"
                        + "    mau.tenMau,\n"
                        + "    sanPhamCt.gia,\n"
                        + "    sanPhamCt.size,\n"
                        + "    sanPhamCt.soLuong,\n"
                        + "    sanPhamCt.ghiChu\n"
                        + "FROM\n"
                        + "    sanPham sanPham\n"
                        + "JOIN\n"
                        + "    sanPhamCt sanPhamCt ON sanPham.id_sanPham = sanPhamCt.id_sanPham\n"
                        + "JOIN\n"
                        + "    theloai tl ON sanPhamCt.id_theLoai = tl.id_theLoai\n"
                        + "JOIN\n"
                        + "    chatLieu cl ON sanPhamCt.id_chatLieu = cl.id_chatLieu\n"
                        + "JOIN\n"
                        + "    thuongHieu th ON sanPhamCt.id_thuongHieu = th.id_thuongHieu\n"
                        + "JOIN\n"
                        + "    nhaCungCap ncc ON sanPhamCt.id_nhaCungCap = ncc.id_nhaCungCap\n"
                        + "JOIN\n"
                        + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where [id_sanPhamCt]not in (select top   " + (sotrang * 5 - 5) + " [id_sanPhamCt] from sanPhamCt)"
                        + "and mau.id_mau = ? ";
                Connection conn = connectionProvider.getConnection();
                PreparedStatement prm = conn.prepareStatement(sql);
                prm.setString(1, strMau);
                rs = prm.executeQuery();
            }
            while (rs.next()) {
                Vector v = new Vector();
                int idSPCT = rs.getInt(1);
                int idSP = rs.getInt(2);
                String tenSP = rs.getString(3);
                String theLoai = rs.getString(4);
                String chatLieu = rs.getString(5);
                String thuongHieu = rs.getString(6);
                String nhaCungCap = rs.getString(7);
                String mau = rs.getString(8);
                double gia = rs.getDouble(9);
                int size = rs.getInt(10);
                int soLuong = rs.getInt(11);
                String ghiChu = rs.getString(12);
                v.add(idSPCT);
                v.add(idSP);
                v.add(tenSP);
                v.add(theLoai);
                v.add(chatLieu);
                v.add(thuongHieu);
                v.add(nhaCungCap);
                v.add(mau);
                v.add(gia);
                v.add(size);
                v.add(soLuong);
                v.add(ghiChu);
                mol.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMau;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNCC;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTheLoai;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThuongHieu;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboChatLieu1;
    private javax.swing.JComboBox<String> cboMau;
    private javax.swing.JComboBox<String> cboMau1;
    private javax.swing.JComboBox<String> cboNCC;
    private javax.swing.JComboBox<String> cboNCC1;
    private javax.swing.JComboBox<String> cboTL;
    private javax.swing.JComboBox<String> cboTL1;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JComboBox<String> cboThuongHieu1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSoTrang;
    private javax.swing.JLabel lblTrang;
    private javax.swing.JTable tbl_SPCT;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtIDSP;
    private javax.swing.JTextField txtSPCT;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JLabel txt_thongTinNv;
    // End of variables declaration//GEN-END:variables
}
