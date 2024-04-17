package Model;

public class SanPham {

    public int iDSanPham;
    public String tenSP;
    public int theLoai;
    public int chatLieu;
    public int thuongHieu;
    public int nhaCungCap;
    public int mau;
    public double gia;
    public int size;
    public int soLuong;
    public String ghiChu;

    public SanPham() {
    }

    public SanPham(int iDSanPham, String tenSP, int theLoai, int chatLieu, int thuongHieu, int nhaCungCap, int mau, double gia, int size, int soLuong, String ghiChu) {
        this.iDSanPham = iDSanPham;
        this.tenSP = tenSP;
        this.theLoai = theLoai;
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
        this.nhaCungCap = nhaCungCap;
        this.mau = mau;
        this.gia = gia;
        this.size = size;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    public int getiDSanPham() {
        return iDSanPham;
    }

    public void setiDSanPham(int iDSanPham) {
        this.iDSanPham = iDSanPham;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(int theLoai) {
        this.theLoai = theLoai;
    }

    public int getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(int chatLieu) {
        this.chatLieu = chatLieu;
    }

    public int getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(int thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public int getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(int nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public int getMau() {
        return mau;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String tenSP() {
        if (this.getiDSanPham() == 1) {
            return "Giày đá bóng adidas";
        } else if (this.getiDSanPham() == 2) {
            return "Giày đá bóng puma";
        } else if (this.getiDSanPham() == 3) {
            return "Giày chạy Bộ poly";
        } else if (this.getiDSanPham() == 4) {
            return "Giày bóng rổ nike";
        } else {
            return "Giày nhảy cao adidas";
        }
    }

    public String theLoai() {
        if (this.getTheLoai() == 1) {
            return "Chạy";
        } else if (this.getTheLoai() == 2) {
            return "Đá bóng";
        } else if (this.getTheLoai() == 3) {
            return "bóng rổ";
        } else {
            return "nhảy cao";
        }

    }

    public String chatLieu() {
        if (this.getChatLieu() == 1) {
            return "vải";
        } else if (this.getChatLieu() == 2) {
            return "da bò";
        } else if (this.getChatLieu() == 3) {
            return "cacbon";
        } else {
            return "lụa";
        }
    }

    public String thuongHieu() {
        if (this.getThuongHieu()== 1) {
            return "adidas";
        } else if (this.getThuongHieu() == 2) {
            return "puma";
        } else if (this.getThuongHieu() == 3) {
            return "poly";
        } else {
            return "nike";
        }
    }
    
    public String NCC() {
        if (this.getNhaCungCap()== 1) {
            return "Mỹ";
        } else if (this.getNhaCungCap() == 2) {
            return "Anh";
        } else if (this.getNhaCungCap() == 3) {
            return "Pháp";
        } else {
            return "Trung Quốc";
        }
    }

    public String loaiMau() {
        if (this.getMau() == 1) {
            return "Xanh";
        } else if (this.getMau() == 2) {
            return "Đỏ";
        } else if (this.getMau() == 3) {
            return "Tím";
        } else if (this.getMau() == 4) {
            return "Vàng";
        } else if (this.getMau() == 5) {
            return "Đen";
        } else {
            return "Hồng";
        }
    }

}
