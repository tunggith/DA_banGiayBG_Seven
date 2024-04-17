/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanPham;

import ConnectionProvider.connectionProvider;
import sanPham.ThuongHieu;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author sontr
 */
public class ThuongHieuServiceImpl implements ThuongHieuService {

    private Connection conn = connectionProvider.getConnection();

    @Override
    public List<ThuongHieu> getThuongHieu() {
        try {
            List<ThuongHieu> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "select * from thuongHieu";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idThuongHieu = rs.getInt(1);
                String tenThuongHieu = rs.getString(2);

                ThuongHieu th = new ThuongHieu();
                th.setIdThuongHieu(idThuongHieu);
                th.setTenThuongHieu(tenThuongHieu);
                list.add(th);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(ThuongHieu th) {
        try {
            String sql = "INSERT thuongHieu(tenThuongHieu) VALUES(?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, th.getTenThuongHieu());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

}
