package sanPham;

import ConnectionProvider.connectionProvider;
import sanPham.SanPhamCt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SanPhamCtServiceImpl implements SanPhamCtService {

    private Connection conn = connectionProvider.getConnection();

    @Override
    public List<SanPhamCt> getAll() {
        try {
            List<SanPhamCt> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "SELECT \n"
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
                    + "    mau mau ON sanPhamCt.id_mau = mau.id_mau;";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
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

                SanPhamCt sp = new SanPhamCt();
                sp.setIdSanPhamCt(idSPCT);
                sp.setiDSanPham(idSP);
                sp.setTenSP(tenSP);
                sp.setTenTheLoai(theLoai);
                sp.setTenChatLieu(chatLieu);
                sp.setTenThuongHieu(thuongHieu);
                sp.setTenNhaCungCap(nhaCungCap);
                sp.setTenMau(mau);
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
    public boolean add(SanPhamCt sp) {
        try {
            String sql1 = "insert sanPhamCt(id_sanPham,id_theLoai,id_chatLieu,id_thuongHieu,id_nhaCungCap,id_mau,gia,size,soLuong,ghiChu)VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm1 = conn.prepareStatement(sql1);
            stm1.setInt(1, sp.getiDSanPham());
            stm1.setInt(2, sp.getIdTL());
            stm1.setInt(3, sp.getIdCL());
            stm1.setInt(4, sp.getIdTH());
            stm1.setInt(5, sp.getIdNCC());
            stm1.setInt(6, sp.getIdMau());
            stm1.setDouble(7, sp.getGia());
            stm1.setInt(8, sp.getSize());
            stm1.setInt(9, sp.getSoLuong());
            stm1.setString(10, sp.getGhiChu());
            stm1.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public boolean delete(SanPhamCt sp) {
        String sql = "delete sanPhamCt where id_sanPhamCt=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, sp.getIdSanPhamCt());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(SanPhamCt sp) {
        String sql = "update sanPhamCt set id_sanPham=?,id_theLoai=?,id_chatLieu=?,id_thuongHieu=?,id_nhaCungCap=?,id_mau=?,gia=?,size=?,soLuong=?,ghiChu=?  where id_sanPhamCt =?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, sp.getiDSanPham());
            stm.setInt(2, sp.getIdTL());
            stm.setInt(3, sp.getIdCL());
            stm.setInt(4, sp.getIdTH());
            stm.setInt(5, sp.getIdNCC());
            stm.setInt(6, sp.getIdMau());
            stm.setDouble(7, sp.getGia());
            stm.setInt(8, sp.getSize());
            stm.setInt(9, sp.getSoLuong());
            stm.setString(10, sp.getGhiChu());
            stm.setInt(11, sp.getIdSanPhamCt());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SanPhamCt> timTheoTen(String tenSanPham) {
        try {
            List<SanPhamCt> listTK = new ArrayList<>();
            String sql = "SELECT \n"
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
                    + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where sanPham.tenSanPham like ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + tenSanPham + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int idSPCT = Integer.parseInt(rs.getString(1));
                int idSP = Integer.parseInt(rs.getString(2));
                String tenSP = rs.getString(3);
                String theLoai = rs.getString(4);
                String chatLieu = rs.getString(5);
                String thuongHieu = rs.getString(6);
                String nhaCungCap = rs.getString(7);
                String mau = rs.getString(8);
                double gia = rs.getDouble(9);
                int size = Integer.parseInt(rs.getString(10));
                int soLuong = Integer.parseInt(rs.getString(11));
                String ghiChu = rs.getString(12);

                SanPhamCt spct = new SanPhamCt();
                spct.setIdSanPhamCt(idSPCT);
                spct.setiDSanPham(idSP);
                spct.setTenSP(tenSP);
                spct.setTenTheLoai(theLoai);
                spct.setTenChatLieu(chatLieu);
                spct.setTenThuongHieu(thuongHieu);
                spct.setTenNhaCungCap(nhaCungCap);
                spct.setTenMau(mau);
                spct.setGia(gia);
                spct.setSize(size);
                spct.setSoLuong(soLuong);
                spct.setGhiChu(ghiChu);
                listTK.add(spct);

            }
            return listTK;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SanPhamCt> timTheoTuSP(String tenSanPham1) {
        try {
            List<SanPhamCt> listTK = new ArrayList<>();
            String sql = "SELECT \n"
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
                    + "    mau mau ON sanPhamCt.id_mau = mau.id_mau where sanPhamCt.id_sanPham=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenSanPham1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int idSPCT = Integer.parseInt(rs.getString(1));
                int idSP = Integer.parseInt(rs.getString(2));
                String tenSP = rs.getString(3);
                String theLoai = rs.getString(4);
                String chatLieu = rs.getString(5);
                String thuongHieu = rs.getString(6);
                String nhaCungCap = rs.getString(7);
                String mau = rs.getString(8);
                double gia = rs.getDouble(9);
                int size = Integer.parseInt(rs.getString(10));
                int soLuong = Integer.parseInt(rs.getString(11));
                String ghiChu = rs.getString(12);

                SanPhamCt spct = new SanPhamCt();
                spct.setIdSanPhamCt(idSPCT);
                spct.setiDSanPham(idSP);
                spct.setTenSP(tenSP);
                spct.setTenTheLoai(theLoai);
                spct.setTenChatLieu(chatLieu);
                spct.setTenThuongHieu(thuongHieu);
                spct.setTenNhaCungCap(nhaCungCap);
                spct.setTenMau(mau);
                spct.setGia(gia);
                spct.setSize(size);
                spct.setSoLuong(soLuong);
                spct.setGhiChu(ghiChu);
                listTK.add(spct);

            }
            return listTK;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkTrungTheLoai(int id_sanPham, int id_theLoai) {
        try {
            String query = "SELECT COUNT(*) FROM sanPhamCt WHERE id_sanPham = ? AND id_theLoai = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_theLoai);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungChatLieu(int id_sanPham, int id_chatLieu) {
        try {
            String query = "SELECT COUNT(*) FROM sanPhamCt WHERE id_sanPham = ? AND id_chatLieu = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_chatLieu);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungThuongHieu(int id_sanPham, int id_thuongHieu) {
        try {
            String query = "SELECT COUNT(*) FROM sanPhamCt WHERE id_sanPham = ? AND id_thuongHieu = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_thuongHieu);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungNhaCC(int id_sanPham, int id_nhaCungCap) {
        try {
            String query = "SELECT COUNT(*) FROM sanPhamCt WHERE id_sanPham = ? AND id_nhaCungCap = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_nhaCungCap);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungMau(int id_sanPham, int id_mau) {
        try {
            String query = "SELECT COUNT(*) FROM sanPhamCt WHERE id_sanPham = ? AND id_mau = ? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_mau);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkTrungTT(int id_sanPham, int id_theLoai, int id_chatLieu, int id_thuongHieu, int id_nhaCungCap, int id_mau) {
        try {
            String query = "SELECT COUNT(*) FROM sanPhamCt WHERE id_sanPham = ? AND id_theLoai = ? AND id_chatLieu = ? AND id_thuongHieu = ? AND id_nhaCungCap = ? AND id_mau = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, id_sanPham);
            stm.setInt(2, id_theLoai);
            stm.setInt(3, id_chatLieu);
            stm.setInt(4, id_thuongHieu);
            stm.setInt(5, id_nhaCungCap);
            stm.setInt(6, id_mau);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
