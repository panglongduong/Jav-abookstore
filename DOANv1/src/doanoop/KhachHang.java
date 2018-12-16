package doanoop;

import java.io.File;
import java.util.Scanner;

public class KhachHang {
    protected String makhạchhang;
    protected String tenkhạchhang;
    protected String diachikhạchhang;
    protected String  sodienthoaikhạchhang;
    
    public KhachHang(){
    }
    public KhachHang(String makhạchhang, String tenkhạchhang, String diachikhạchhang, String sodienthoaikhạchhang)
    {
        this.makhạchhang = makhạchhang;
        this.tenkhạchhang = tenkhạchhang;
        this.diachikhạchhang = diachikhạchhang;
        this.sodienthoaikhạchhang = sodienthoaikhạchhang;
    }

    public String getMakhạchhang() {
        return makhạchhang;
    }

    public String getTenkhạchhang() {
        return tenkhạchhang;
    }

    public String getDiachikhạchhang() {
        return diachikhạchhang;
    }

    public String getSodienthoaikhạchhang() {
        return sodienthoaikhạchhang;
    }

    public void setMakhạchhang(String makhạchhang) {
        this.makhạchhang = makhạchhang;
    }

    public void setTenkhạchhang(String tenkhạchhang) {
        this.tenkhạchhang = tenkhạchhang;
    }

    public void setDiachikhạchhang(String diachikhạchhang) {
        this.diachikhạchhang = diachikhạchhang;
    }

    public void setSodienthoaikhạchhang(String  sodienthoaikhạchhang) {
        this.sodienthoaikhạchhang = sodienthoaikhạchhang;
    }
    
    public void NhapKhachHang()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng: ");
        makhạchhang = in.nextLine();
        System.out.println("Nhập tên khách hàng: ");
        tenkhạchhang = in.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        diachikhạchhang = in.nextLine();
        System.out.println("Nhập số điện thoại khách hàng: ");
        sodienthoaikhạchhang = in.nextLine();
    }
    public void XuatKhachHang()
    {
        System.out.printf("  %20s | %20s | %20s | %20s \n",makhạchhang,tenkhạchhang,diachikhạchhang,sodienthoaikhạchhang);
    }
    
    public void docfile(File f , String s){
        String output[] = s.split("_");
        makhạchhang = output[0];
        tenkhạchhang = output[1];
        diachikhạchhang = output[2];
        sodienthoaikhạchhang = output[3];
       System.out.printf("  %20s | %20s | %20s | %20s \n",makhạchhang,tenkhạchhang,diachikhạchhang,sodienthoaikhạchhang);        
    }
}
