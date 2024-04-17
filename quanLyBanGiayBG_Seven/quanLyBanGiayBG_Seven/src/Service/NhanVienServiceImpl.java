package Service;

import Connection.DBConnect;
import Model.Nhanvien;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class NhanVienServiceImpl implements NhanVienService {

    private Connection conn = DBConnect.getConnection();

    @Override
    public List<Nhanvien> getAll() {
        try {
            List<Nhanvien> list = new ArrayList<>();
            Statement stm = conn.createStatement();
            String sql = "select* from nhanVien";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idNhanVien = rs.getInt(1);
                String ten = rs.getString(2);
                boolean gioitinh = rs.getBoolean(3);
                int dienthoai = rs.getInt(4);
                String email = rs.getString(5);
                String diachi = rs.getString(6);
                int idUser = rs.getInt(7);

                Nhanvien nv = new Nhanvien();
                nv.setIdNhanVien(idNhanVien);
                nv.setTen(ten);
                nv.setGioitinh(gioitinh);
                nv.setDienthoai(dienthoai);
                nv.setEmail(email);
                nv.setDiachi(diachi);
                nv.setIdUser(idUser);
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean add(Nhanvien nv) {
        String sql1 = "insert nhanVien(hoTen,gioiTinh,soDt,email,diaChi,id_taiKhoan)VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql1);
            stm.setString(1, nv.getTen());
            stm.setBoolean(2, nv.isGioitinh());
            stm.setInt(3, nv.getDienthoai());
            stm.setString(4, nv.getEmail());
            stm.setString(5, nv.getDiachi());
            stm.setInt(6, nv.getIdUser());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public boolean update(Nhanvien nv) {
        String sql = "update nhanVien set hoTen=?,gioiTinh=?,soDt=?,email=?,diaChi=?,id_taiKhoan=? where id_nhanVien=? ";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, nv.getTen());
            stm.setBoolean(2, nv.isGioitinh());
            stm.setInt(3, nv.getDienthoai());
            stm.setString(4, nv.getEmail());
            stm.setString(5, nv.getDiachi());
            stm.setInt(6, nv.getIdUser());
            stm.setInt(7, nv.getIdNhanVien());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Nhanvien> timTheoMa(int idNhanvien) {
        try {
               List<Nhanvien> listTK = new ArrayList<>();
            String sql="select * from nhanVien where id_nhanVien=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setInt(1, idNhanvien);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                  int idNhanVien = rs.getInt(1);
                String ten = rs.getString(2);
                boolean gioitinh = rs.getBoolean(3);
                int dienthoai = rs.getInt(4);
                String email = rs.getString(5);
                String diachi = rs.getString(6);
                int idUser = rs.getInt(7);
                
                Nhanvien nvtk=new Nhanvien();
                nvtk.setIdNhanVien(idNhanVien);
                nvtk.setTen(ten);
                nvtk.setGioitinh(gioitinh);
                nvtk.setDienthoai(dienthoai);
                nvtk.setEmail(email);
                nvtk.setDiachi(diachi);
                nvtk.setIdUser(idUser);
                listTK.add(nvtk);
                
                
            }
            return listTK;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }  

}
