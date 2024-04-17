
package Model;


public class Nhanvien {
    public int idNhanVien;
    public String ten;
    public String diachi;
    public int dienthoai;
    public String email;
    public boolean gioitinh;
    public int idUser;

    public Nhanvien() {
    }

    public Nhanvien(int idNhanVien, String ten, String diachi, int dienthoai, String email, boolean gioitinh, int idUser) {
        this.idNhanVien = idNhanVien;
        this.ten = ten;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.email = email;
        this.gioitinh = gioitinh;
        this.idUser = idUser;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(int dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

 
   

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
    

