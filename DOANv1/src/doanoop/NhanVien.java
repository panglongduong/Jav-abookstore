package doanoop;

import java.util.Scanner;

public class NhanVien {
    protected String manhanvien;
    protected String tennhanvien;
    protected String diachinhanvien;
    protected int sodienthoainhanvien;
    
    public NhanVien(){
    }
    public NhanVien(String manhanvien, String tennhanvien, String diachinhanvien, int sodienthoainhanvien)
    {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.diachinhanvien = diachinhanvien;
        this.sodienthoainhanvien = sodienthoainhanvien;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public String getDiachinhanvien() {
        return diachinhanvien;
    }

    public int getSodienthoainhanvien() {
        return sodienthoainhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public void setDiachinhanvien(String diachinhanvien) {
        this.diachinhanvien = diachinhanvien;
    }

    public void setSodienthoainhanvien(int sodienthoainhanvien) {
        this.sodienthoainhanvien = sodienthoainhanvien;
    }
    
    public void NhapNhanVien()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên: ");
        manhanvien = in.nextLine();
        System.out.println("Nhập tên nhân viên: ");
        tennhanvien = in.nextLine();
        System.out.println("Nhập địa chỉ nhân viên: ");
        diachinhanvien = in.nextLine();
        System.out.println("Nhập số điện thoại nhân viên: ");
        sodienthoainhanvien = in.nextInt();
    }
    public void XuatNhanVien()
    {
        System.out.printf("  %20s | %20s | %20s | %20s \n",manhanvien,tennhanvien,diachinhanvien,sodienthoainhanvien);
    }
    
}
