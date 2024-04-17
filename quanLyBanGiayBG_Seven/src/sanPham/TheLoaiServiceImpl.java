package sanPham;

import ConnectionProvider.connectionProvider;
import sanPham.TheLoai;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class TheLoaiServiceImpl implements TheLoaiService {

    private Connection conn = connectionProvider.getConnection();

    @Override
    public List<TheLoai> getTheLoai() {
        try {
            List<TheLoai> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "select * from theLoai";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idTheLoai = rs.getInt(1);
                String tenTheLoai = rs.getString(2);

                TheLoai tl = new TheLoai();
                tl.setIdTheLoai(idTheLoai);
                tl.setTenTheLoai(tenTheLoai);
                list.add(tl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(TheLoai tl) {
        try {
            String sql = "INSERT theLoai(tenTheLoai) VALUES(?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tl.getTenTheLoai());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

}
