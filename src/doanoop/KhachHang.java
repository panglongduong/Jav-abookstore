package doanoop;

import java.util.Scanner;

public class KhachHang {
    protected String makhachhang;
    protected String tenkhachhang;
    protected String diachikhachhang;
    protected int sodienthoaikhachhang;
    
    public KhachHang(){
    }
    public KhachHang(String makhachhang, String tenkhachhang, String diachikhachhang, int sodienthoaikhachhang)
    {
        this.makhachhang = makhachhang;
        this.tenkhachhang = tenkhachhang;
        this.diachikhachhang = diachikhachhang;
        this.sodienthoaikhachhang = sodienthoaikhachhang;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public String getDiachikhachhang() {
        return diachikhachhang;
    }

    public int getSodienthoaikhachhang() {
        return sodienthoaikhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public void setDiachikhachhang(String diachikhachhang) {
        this.diachikhachhang = diachikhachhang;
    }

    public void setSodienthoaikhachhang(int sodienthoaikhachhang) {
        this.sodienthoaikhachhang = sodienthoaikhachhang;
    }
    
    public void NhapKhachHang()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng: ");
        makhachhang = in.nextLine();
        System.out.println("Nhập tên khách hàng: ");
        tenkhachhang = in.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        diachikhachhang = in.nextLine();
        System.out.println("Nhập số điện thoại khách hàng: ");
        sodienthoaikhachhang = in.nextInt();
    }
    public void XuatKhachHang()
    {
        System.out.printf("  %20s | %20s | %20s | %20s | %15s \n",makhachhang,tenkhachhang,diachikhachhang,sodienthoaikhachhang);
    }
    
}
