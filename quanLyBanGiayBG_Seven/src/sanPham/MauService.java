/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sanPham;

import sanPham.Mau;
import java.util.List;

/**
 *
 * @author sontr
 */
public interface MauService {
     List<Mau> getMau();

    public boolean add(Mau mau);
}
