/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KhachHang;

import ConnectionProvider.connectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class khachHangService_impl implements khachHang_service {

    private Connection conn = connectionProvider.getConnection();

    @Override
    public void themKhachHang(khachHang kh) {
        try {
            String sql = "insert into khachHang(hoTen,gioiTinh,diaChi,soDienThoai) values(?,?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            //prm.setString(1, String.valueOf(kh.getId_khachHang()));
            prm.setString(1, kh.getTenKhachHang());
            prm.setString(2, String.valueOf(kh.getGioiTinh()));
            prm.setString(3, kh.getDiaChi());
            prm.setString(4, String.valueOf(kh.getSoDienThoai()));
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "thêm thất bại");
            e.printStackTrace();
        }
    }

}
