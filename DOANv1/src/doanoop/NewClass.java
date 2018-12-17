
package doanoop;

import danhsach.DanhSachNhanVien;
import danhsach.DanhSachKhachHang;
import danhsach.DanhSachNhaCungCap;
import java.io.IOException;

public class NewClass {
    public static void main(String[] args) throws IOException
    {
        DanhSachNhanVien  ds = new DanhSachNhanVien();
            //ds.NhapDanhSach();
        ds.docfile();
        ds.instruction();
        ds.XuatDanhSach();
        ds.ghifile();
        /*DanhSachKhachHang ds = new DanhSachKhachHang();
         ds.docfile();
        ds.instruction();
        ds.XuatDanhSach();
        ds.ghifile();*/
       /* DanhSachNhaCungCap ds = new DanhSachNhaCungCap();
         ds.docfile();
        ds.instruction();
        ds.XuatDanhSach();
        ds.ghifile();
*/
        
        
    }
}

