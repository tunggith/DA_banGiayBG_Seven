package Service;

import java.util.List;
import Model.SanPham;   
public interface SanPhamService {
    List<SanPham> getAll();
    public boolean add(SanPham sp);
    public boolean delete(SanPham sp);   
    public boolean update(SanPham sp);
}
