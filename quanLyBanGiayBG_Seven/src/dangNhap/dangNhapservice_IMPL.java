/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangNhap;

import ConnectionProvider.connectionProvider;
import NhanVien.nhanVien;

/**
 *
 * @author MSI
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class dangNhapservice_IMPL implements nhanVienIMPL{
    public List<dangNhap> getMatKhau(){
        List<dangNhap> listDn = new ArrayList<>();
        try {
               Connection conn = connectionProvider.getConnection();
               String sql = "select tenDangNhap,matkhau from taiKhoan";
               Statement stm = conn.createStatement();
               ResultSet rs = stm.executeQuery(sql);
               while(rs.next()){
                   String tenDangNhap = rs.getString(1);
                   int matKhau = Integer.parseInt(rs.getString(2));
                   dangNhap dn = new dangNhap();
                   dn.setMatKhau(matKhau);
                   listDn.add(dn);
               }
               return listDn;
           } catch (Exception e) {
               e.printStackTrace();
               return null;
           }
    }
    @Override
    public void themTaiKhoan(dangNhap dn) {
        try {
            Connection conn = connectionProvider.getConnection();
            String sql = "insert into taiKhoan(tenDangNhap,matKhau,vaiTro) values(?,?,?)";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, dn.getTenDangNhap());
            prm.setString(2, String.valueOf(dn.getMatKhau()));
            prm.setString(3, String.valueOf(dn.getVaiTro()));
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "đăng kí thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "đăng kí thất bại");
            e.printStackTrace();
        }
    }

    @Override
    public void doiMatKhau(dangNhap dn) {
        try {
            Connection conn = connectionProvider.getConnection();
            String sql = "update taiKhoan set matKhau = ? where tenDangNhap= ?";
            PreparedStatement prm = conn.prepareStatement(sql);
            prm.setString(1, String.valueOf(dn.getMatKhauMoi()));
            prm.setString(2, dn.getTenDangNhap());
            prm.executeUpdate();
            JOptionPane.showMessageDialog(null, "đổi thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "đổi thất bại");
            e.printStackTrace();
        }
    }
    
    
}
