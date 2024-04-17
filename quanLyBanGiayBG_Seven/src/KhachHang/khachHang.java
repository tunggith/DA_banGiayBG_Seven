/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KhachHang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class khachHang {
    public int id_khachHang;
    public String tenKhachHang;
    public int gioiTinh;
    public String diaChi;
    public int soDienThoai;
    
    public String checkKh(){
        if(this.gioiTinh == 0){
            return "nam";
        }else{
            return "nữ";
        }
    }
}
