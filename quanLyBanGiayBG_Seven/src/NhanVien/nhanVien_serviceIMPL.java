/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NhanVien;

import ConnectionProvider.connectionProvider;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class nhanVien_serviceIMPL implements nhanVien_service {

    private Connection conn = connectionProvider.getConnection();

    public List<nhanVien> getNhanVien(String search) {
        List<nhanVien> listNv = new ArrayList<>();
        try {
            String sql = "select id_nhanVien, hoTen, gioiTinh,soDt,email,diaChi,id_taiKhoan,trangThai from nhanVien where hoTen like ?";

            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, "%" + search + "%");
            ResultSet rs = prm.executeQuery();
            while (rs.next()) {
                int idNhanVien = Integer.parseInt(rs.getString(1));
                String hoTen = rs.getString(2);
                int gioiTinh = Integer.parseInt(rs.getString(3));
                int soDienthoai = Integer.parseInt(rs.getString(4));
                String email = rs.getString(5);
                String diaChi = rs.getString(6);
                int idTaiKhoan = Integer.parseInt(rs.getString(7));
                int trangThai = Integer.parseInt(rs.getString(8));

                nhanVien nv = new nhanVien();
                nv.setId_nhanVien(idNhanVien);
                nv.setTenNhanVien(hoTen);
                nv.setGioiTinh(gioiTinh);
                nv.setSoDienThoai(soDienthoai);
                nv.setEmail(email);
                nv.setDiaChi(diaChi);
                nv.setTaiKhoan(idTaiKhoan);
                nv.setTrangThai(trangThai);
                listNv.add(nv);
            }
            return listNv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void themNhanVien(nhanVien nv) {
        try {
            String sql = "insert into nhanVien(hoTen, gioiTinh,soDt,email,diaChi,id_taiKhoan,trangThai) values(?,?,?,?,?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, nv.getTenNhanVien());
            prm.setString(2, String.valueOf(nv.getGioiTinh()));
            prm.setString(3, String.valueOf(nv.getSoDienThoai()));
            prm.setString(4, nv.getEmail());
            prm.setString(5, nv.getDiaChi());
            prm.setString(6, String.valueOf(nv.getTaiKhoan()));
            prm.setString(7, String.valueOf(nv.getTrangThai()));
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "thêm thất bại");
            e.printStackTrace();
        }

    }

    @Override
    public void suaNhanVien(nhanVien nv) {
        try {
            String sql = "update nhanVien "
                    + "set  hoTen = ?, gioiTinh = ?,soDt= ?,email=?,diaChi=?,id_taiKhoan = ?,trangThai= ?  "
                    + "where id_nhanVien = ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, nv.getTenNhanVien());
            prm.setString(2, String.valueOf(nv.getGioiTinh()));
            prm.setString(3, String.valueOf(nv.getSoDienThoai()));
            prm.setString(4, nv.getEmail());
            prm.setString(5, nv.getDiaChi());
            prm.setString(6, String.valueOf(nv.getTaiKhoan()));
            prm.setString(7, String.valueOf(nv.getTrangThai()));
            prm.setString(8, String.valueOf(nv.getId_nhanVien()));
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sửa thất bại");
            e.printStackTrace();
        }
    }

}
