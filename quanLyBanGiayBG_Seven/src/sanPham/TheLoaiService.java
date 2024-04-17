package sanPham;

import sanPham.TheLoai;
import java.util.List;

public interface TheLoaiService {
    List<TheLoai> getTheLoai();
    public boolean add(TheLoai tl);
}
