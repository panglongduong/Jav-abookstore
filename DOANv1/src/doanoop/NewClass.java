
package doanoop;

import danhsach.DanhSachNhanVien;
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
    }
}

