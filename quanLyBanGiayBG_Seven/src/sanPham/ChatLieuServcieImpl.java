package sanPham;

import ConnectionProvider.connectionProvider;
import sanPham.ChatLieu;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChatLieuServcieImpl implements ChatLieuService {

    private Connection conn = connectionProvider.getConnection();

    @Override
    public List<ChatLieu> getChatLieu() {
        try {
            List<ChatLieu> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "select * from chatLieu";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idChatLieu = rs.getInt(1);
                String tenChatLieu = rs.getString(2);

                ChatLieu tl = new ChatLieu();
                tl.setIdChatLieu(idChatLieu);
                tl.setTenChatLieu(tenChatLieu);
                list.add(tl);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(ChatLieu cl) {
        try {
            String sql = "INSERT chatLieu(tenChatLieu) VALUES(?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, cl.getTenChatLieu());
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }
    }

}
