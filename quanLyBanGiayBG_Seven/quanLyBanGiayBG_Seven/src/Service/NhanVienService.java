
package Service;

import Model.Nhanvien;
import java.util.List;


public interface NhanVienService {
       List<Nhanvien> getAll();
    public boolean add( Nhanvien nv); 
    public boolean update(Nhanvien nv);
     List<Nhanvien> timTheoMa(int idNhanvien);
}
