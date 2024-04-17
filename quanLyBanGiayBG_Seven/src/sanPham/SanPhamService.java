package sanPham;

import sanPham.SanPham;
import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();
    public boolean add(SanPham sp);

}
