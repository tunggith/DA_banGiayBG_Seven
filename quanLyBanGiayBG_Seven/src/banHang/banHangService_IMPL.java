/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banHang;

import ConnectionProvider.connectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class banHangService_IMPL implements banhangService {

    private Connection conn = connectionProvider.getConnection();

    public List<banHang> getHoaDon() {
        List<banHang> listHd = new ArrayList<>();
        try {
            String sql = "select hd.id_hoaDon,nv.hoTen,hd.trangThai, hd.ngayTao from hoaDon hd\n"
                    + "join nhanVien nv on hd.id_nhanVien = nv.id_nhanVien";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id_hoaDon = Integer.parseInt(rs.getString(1));
                String tenNhanVien = rs.getString(2);
                int trangThai = Integer.parseInt(rs.getString(3));
                String ngayTao = rs.getString(4);

                banHang bh = new banHang();
                bh.setId_hoaDon(id_hoaDon);
                bh.setTenNhanVien(tenNhanVien);
                bh.setTrangThai(trangThai);
                bh.setNgayTao(ngayTao);
                listHd.add(bh);
            }
            return listHd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getSanPham(String timKiem) {
        List<banHang> listSp = new ArrayList<>();
        try {
            String sql = "select id_sanPhamCt,sp.tenSanPham,tl.tenTheLoai,cl.tenChatLieu,th.tenThuongHieu,ncc.tenNhaCungCap,m.tenMau, gia,size, soLuong, ct.ghiChu \n"
                    + "from sanPhamCt ct join sanPham sp on ct.id_sanPham = sp.id_sanPham \n"
                    + "join theloai tl on ct.id_theLoai = tl.id_theLoai \n"
                    + "join chatLieu cl on ct.id_chatLieu = cl.id_chatLieu\n"
                    + "join thuongHieu th on ct.id_thuongHieu = th.id_thuongHieu\n"
                    + "join nhaCungCap ncc on ct.id_nhaCungCap = ncc.id_nhaCungCap\n"
                    + "join mau m on ct.id_mau = m.id_mau where sp.tenSanPham like ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, "%" + timKiem + "%");
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                int ma = Integer.parseInt(rs.getString(1));
                String tenSp = rs.getString(2);
                String theLoai = rs.getString(3);
                String chatLieu = rs.getString(4);
                String thuongHieu = rs.getString(5);
                String nhaCungCap = rs.getString(6);
                String mau = rs.getString(7);
                double giaSp = Double.parseDouble(rs.getString(8));
                int size = Integer.parseInt(rs.getString(9));
                int soLuong = Integer.parseInt(rs.getString(10));
                String ghiChu = rs.getString(11);

                banHang bh = new banHang();
                bh.setId_sanPhamCt(ma);
                bh.setTenSanPham(tenSp);
                bh.setTenTheLoai(theLoai);
                bh.setTenChatLieu(chatLieu);
                bh.setTenThuongHieu(thuongHieu);
                bh.setTenNhaCungCap(nhaCungCap);
                bh.setTenMau(mau);
                bh.setGiaSp(giaSp);
                bh.setSize(size);
                bh.setSoLuong(soLuong);
                bh.setGhiChu(ghiChu);
                listSp.add(bh);
            }
            return listSp;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sản phẩm không tồn tại");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void taoHoaDon(banHang bh) {
        try {
            String sql = "INSERT INTO hoaDon (id_nhanVien, ngayTao,trangThai,id_khachHang,id_khuyenMai)\n"
                    + "SELECT nv.id_nhanVien, ?, ?, ? ,1\n"
                    + "FROM nhanVien nv\n"
                    + "WHERE nv.hoTen = ?;";
            PreparedStatement prm = conn.prepareStatement(sql);

            prm.setString(1, bh.getNgayTao());
            prm.setString(2, String.valueOf(bh.getTrangThai()));
            prm.setString(3, String.valueOf(bh.getId_khachHang()));
            prm.setString(4, bh.getTenNhanVien());
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "tạo thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "tạo thất bại");
            e.printStackTrace();

        }
    }

    @Override
    public void themSanPham(banHang bh) {
        try {
            String sql = "INSERT INTO hoaDonCT(id_hoaDon,id_sanPhamCt, soLuong, donGia) values(?,?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, String.valueOf(bh.getId_hoaDon()));
            prm.setString(2, String.valueOf(bh.getId_sanPhamCt()));
            prm.setString(3, String.valueOf(bh.getSoLuongThem()));
            prm.setString(4, String.valueOf(bh.getGiaSp()));
            prm.executeUpdate();

            JOptionPane.showMessageDialog(null, "thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaSoLuong(banHang bh) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            String sql = "update sanPhamCt set soLuong = ? - ? where id_sanPhamCt = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, bh.getSoLuong());
            prm.setInt(2, bh.getSoLuongThem());
            prm.setInt(3, bh.getId_sanPhamCt());
            prm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<banHang> getGioHang(String search) {
        List<banHang> listGH = new ArrayList<>();
        try {
            //Statement stm = conn.createStatement();
            String sql = "select ct.id_hoaDonCt,ct.id_hoaDon,sp.tenSanPham,ct.soLuong,ct.donGia,tl.tenTheLoai,cl.tenChatLieu,th.tenThuongHieu,ncc.tenNhaCungCap,m.tenMau,spct.size\n"
                    + "from hoaDonCT ct\n"
                    + "join sanPhamCt spCt on ct.id_sanPhamCt = spct.id_sanPhamCt\n"
                    + "join sanPham sp on spCt.id_sanPham = sp.id_sanPham \n"
                    + "join theloai tl on spct.id_theLoai = tl.id_theLoai\n"
                    + "join chatLieu cl on spct.id_chatLieu = cl.id_chatLieu\n"
                    + "join thuongHieu th on spct.id_thuongHieu = th.id_thuongHieu\n"
                    + "join nhaCungCap ncc on spct.id_nhaCungCap = ncc.id_nhaCungCap\n"
                    + "join mau m on spct.id_mau = m.id_mau\n"
                    + "where ct.id_hoaDon = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, search);
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                int id_hoaDonCt = Integer.parseInt(rs.getString(1));
                int id_hoaDon = Integer.parseInt(rs.getString(2));
                String tenSanpham = rs.getString(3);
                int soLuong = Integer.parseInt(rs.getString(4));
                Double donGia = Double.parseDouble(rs.getString(5));
                String theLoai = rs.getString(6);
                String chatLieu = rs.getString(7);
                String thuongHieu = rs.getString(8);
                String nhaCungCap = rs.getString(9);
                String mau = rs.getString(10);
                int size = Integer.parseInt(rs.getString(11));

                banHang bh = new banHang();
                bh.setId_hoaDonCt(id_hoaDonCt);
                bh.setId_hoaDon(id_hoaDon);
                bh.setTenSanPham(tenSanpham);
                bh.setSoLuong(soLuong);
                bh.setGiaSp(donGia);
                bh.setTenTheLoai(theLoai);
                bh.setTenChatLieu(chatLieu);
                bh.setTenThuongHieu(thuongHieu);
                bh.setTenNhaCungCap(nhaCungCap);
                bh.setTenMau(mau);
                bh.setSize(size);
                listGH.add(bh);
                System.out.println(listGH);
            }
            return listGH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void themSoLuong(banHang bh) {
        try {
            String sql = "UPDATE sanPhamCt\n"
                    + "SET soLuong = ct.soLuong + ?\n"
                    + "FROM sanPhamCt ct\n"
                    + "JOIN hoaDonCt hd ON ct.id_sanPham = hd.id_sanPham\n"
                    + "WHERE hd.id_hoaDonCt = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            //prm.setInt(1, bh.getSoLuong());
            prm.setInt(1, bh.getSoLuongThem());
            prm.setInt(2, bh.getId_hoaDonCt());
            prm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void thanhToan(banHang bh) {
        try {
            String sql = "update hoaDon set trangThai = ? where id_hoaDon = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, bh.getTrangThai());
            prm.setInt(2, bh.getId_hoaDon());
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "thanh toán thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaGioHang(banHang bh) {
        try {
            String sql1 = "delete from hoaDonCt where id_hoaDonct = ?";
            PreparedStatement prm1 = conn.prepareStatement(sql1);
            prm1.setInt(1, bh.getId_hoaDonCt());
            prm1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<banHang> getTheLoai() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenTheLoai from theloai";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenTheLoai(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getChatLieu() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenChatLieu from chatLieu";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenChatLieu(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getThuongHieu() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenThuongHieu from thuongHieu";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenThuongHieu(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getNhaCungCap() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenNhaCungCap from nhaCungCap";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenNhaCungCap(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<banHang> getMau() {
        List<banHang> listTL = new ArrayList<>();
        try {
            String sql = "select tenMau from mau";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenTheLoai = rs.getString(1);
                banHang bh = new banHang();
                bh.setTenMau(tenTheLoai);
                listTL.add(bh);
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateGioHang(banHang bh) {
        try {
            String sql = "update hoaDonCT set soLuong = ? + ? where id_hoaDonCt = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, bh.getSoLuongGh());
            prm.setInt(2, bh.getSoLuongThemGh());
            prm.setInt(3, bh.getId_hoaDonCt());
            prm.executeUpdate();
            System.out.println(prm + "+");
            JOptionPane.showMessageDialog(null, "thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "thêm thất bại");
            e.printStackTrace();
            
        }
    }

    @Override
    public void updateSpct(banHang bh) {
      try {
            String sql = "update sanPhamCt set soLuong = ? - ? where id_hoaDonCt = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setInt(1, bh.getSoLuong());
            prm.setInt(2, bh.getSoLuongThem());
            prm.setInt(3, bh.getId_sanPhamCt());
            prm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
