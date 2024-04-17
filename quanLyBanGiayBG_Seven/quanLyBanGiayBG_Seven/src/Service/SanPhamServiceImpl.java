package Service;

import Connection.DBConnect;
import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SanPhamServiceImpl implements SanPhamService {

    private Connection conn = DBConnect.getConnection();

    @Override
    public List<SanPham> getAll() {
        try {
            List<SanPham> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "Select * from sanPhamCt";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idSP = rs.getInt(1);
                String tenSP = rs.getString(2);
                int theLoai = rs.getInt(3);
                int chatLieu = rs.getInt(4);
                int thuongHieu = rs.getInt(5);
                int nhaCungCap = rs.getInt(6);
                int mau = rs.getInt(7);
                double gia = rs.getDouble(8);
                int size = rs.getInt(9);
                int soLuong = rs.getInt(10);
                String ghiChu = rs.getString(11);

                SanPham sp = new SanPham();
                sp.setiDSanPham(idSP);
                sp.setTenSP(tenSP);
                sp.setTheLoai(theLoai);
                sp.setChatLieu(chatLieu);
                sp.setThuongHieu(thuongHieu);
                sp.setNhaCungCap(nhaCungCap);
                sp.setMau(mau);
                sp.setGia(gia);
                sp.setSize(size);
                sp.setSoLuong(soLuong);
                sp.setGhiChu(ghiChu);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(SanPham sp) {
        //String sql = "INSERT sanPham(id_sanPham,tenSanPham,theLoai,chatLieu,thuongHieu,nhaCungCap,mau,gia,size,soLuong,ghiChu) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        String sql1="insert sanPhamCt(id_sanPham,id_theLoai,id_chatLieu,id_thuongHieu,id_nhaCungCap,id_mau,gia,size,soLuong,ghiChu)VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql1);
            stm.setInt(1, sp.getiDSanPham());
            //stm.setString(2, sp.getTenSP());
            stm.setInt(2, sp.getTheLoai());
            stm.setInt(3, sp.getChatLieu());
            stm.setInt(4, sp.getThuongHieu());
            stm.setInt(5, sp.getNhaCungCap());
            stm.setInt(6, sp.getMau());
            stm.setDouble(7, sp.getGia());
            stm.setInt(8, sp.getSize());
            stm.setInt(9,sp.getSoLuong());
            stm.setString(10, sp.getGhiChu());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public boolean delete(SanPham sp) {
        String sql = "delete sanPhamCt where id_sanPham=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);            
            stm.setInt(1, sp.getiDSanPham());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(SanPham sp) {
        String sql = "update sanPhamCt set id_theLoai=?,id_chatLieu=?,id_thuongHieu=?,id_nhaCungCap=?,id_mau=?,gia=?,size=?,soLuong=?,ghiChu=? where id_sanPham=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            //stm.setString(1, sp.getTenSP());
            stm.setInt(1, sp.getTheLoai());
            stm.setInt(2, sp.getChatLieu());
            stm.setInt(3, sp.getThuongHieu());
            stm.setInt(4, sp.getNhaCungCap());
            stm.setInt(5, sp.getMau());
            stm.setDouble(6, sp.getGia());
            stm.setInt(7, sp.getSize());
            stm.setInt(8, sp.getSoLuong());
            stm.setString(9, sp.getGhiChu());
            stm.setInt(10, sp.getiDSanPham());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
