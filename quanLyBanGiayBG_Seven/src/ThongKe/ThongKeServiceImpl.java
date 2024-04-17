/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThongKe;

import ConnectionProvider.connectionProvider;
import banHang.banHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sontr
 */
public class ThongKeServiceImpl implements ThongKeService {

    private Connection conn = connectionProvider.getConnection();

    @Override
    public List<ThongKe> getAll() {
        List<ThongKe> listTK = new ArrayList<>();
        try {
            String sql = "SELECT hdct.id_hoaDonCt,hd.id_hoaDon,hdct.id_sanPhamCt,hdct.soLuong,hdct.donGia,hd.id_nhanVien,hd.trangThai,hd.ngayTao,sp.tenSanPham,spct.id_theLoai,\n"
                    + "spct.id_chatLieu,\n"
                    + "spct.id_thuongHieu,\n"
                    + "spct.id_nhaCungCap,\n"
                    + "spct.id_mau,\n"
                    + "spct.size\n"
                    + "FROM \n"
                    + "hoaDon hd\n"
                    + "jOIN hoaDonCT hdct ON hd.id_hoaDon = hdct.id_hoaDon\n"
                    + "JOIN  sanPhamCt spct ON hdct.id_sanPhamCt = spct.id_sanPhamCt\n"
                    + "JOIN sanPham sp ON spct.id_sanPham = sp.id_sanPham\n"
                    + "where trangThai=1;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id_hoaDonCt = Integer.parseInt(rs.getString(1));
                int id_hoaDon = Integer.parseInt(rs.getString(2));
                int id_sanPham = Integer.parseInt(rs.getString(3));
                int soLuong = Integer.parseInt(rs.getString(4));
                double donGia = Double.parseDouble(rs.getString(5));
                int id_nhanVien = Integer.parseInt(rs.getString(6));
                int trangThai = Integer.parseInt(rs.getString(7));
                String ngayTao = rs.getString(8);
                String tenSP = rs.getString(9);
                int id_TheLoai = Integer.parseInt(rs.getString(10));
                int id_ChatLieu = Integer.parseInt(rs.getString(11));
                int id_ThuongHieu = Integer.parseInt(rs.getString(12));
                int id_NCC = Integer.parseInt(rs.getString(13));
                int id_Mau = Integer.parseInt(rs.getString(14));
                int size = Integer.parseInt(rs.getString(15));
                ThongKe bh = new ThongKe();
                bh.setId_hoaDonCt(id_hoaDonCt);
                bh.setId_hoaDon(id_hoaDon);
                bh.setId_sanPham(id_sanPham);
                bh.setSoLuong(soLuong);
                bh.setGia(donGia);
                bh.setId_nhanVien(id_nhanVien);
                bh.setTrangThai(trangThai);
                bh.setNgayTao(ngayTao);
                bh.setTenSP(tenSP);
                bh.setIdTL(id_TheLoai);
                bh.setIdCL(id_ChatLieu);
                bh.setIdTH(id_ThuongHieu);
                bh.setIdNCC(id_NCC);
                bh.setIdMau(id_Mau);
                bh.setSize(size);
                listTK.add(bh);
            }
            return listTK;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ThongKe> findByDate(String Date) {
        ArrayList<ThongKe> listTK = new ArrayList<>();
        String sql = "Select * from hoaDonCt where Date like?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + Date + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id_hoaDonCt = Integer.parseInt(rs.getString(1));
                int id_hoaDon = Integer.parseInt(rs.getString(2));
                int id_sanPham = Integer.parseInt(rs.getString(3));
                int soLuong = Integer.parseInt(rs.getString(4));
                double donGia = Double.parseDouble(rs.getString(5));
                int id_nhanVien = Integer.parseInt(rs.getString(6));
                int trangThai = Integer.parseInt(rs.getString(7));
                String ngayTao = rs.getString(8);

                ThongKe bh = new ThongKe();
                bh.setId_hoaDonCt(id_hoaDonCt);
                bh.setId_hoaDon(id_hoaDon);
                bh.setId_sanPham(id_sanPham);
                bh.setSoLuong(soLuong);
                bh.setGia(donGia);
                bh.setId_nhanVien(id_nhanVien);
                bh.setTrangThai(trangThai);
                bh.setNgayTao(ngayTao);
                listTK.add(bh);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTK;
    }

}
