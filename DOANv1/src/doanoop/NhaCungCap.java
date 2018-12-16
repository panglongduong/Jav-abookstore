package doanoop;

import java.io.File;
import java.util.Scanner;

public class NhaCungCap {
    protected String manhacungcap;
    protected String tennhacungcap;
    protected String diachinhacungcap;
    protected String  sodienthoainhacungcap;
    
    public NhaCungCap(){
    }
    public NhaCungCap(String manhacungcap, String tennhacungcap, String diachinhacungcap, String sodienthoainhacungcap)
    {
        this.manhacungcap = manhacungcap;
        this.tennhacungcap = tennhacungcap;
        this.diachinhacungcap = diachinhacungcap;
        this.sodienthoainhacungcap = sodienthoainhacungcap;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public String getDiachinhacungcap() {
        return diachinhacungcap;
    }

    public String getSodienthoainhacungcap() {
        return sodienthoainhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    public void setDiachinhacungcap(String diachinhacungcap) {
        this.diachinhacungcap = diachinhacungcap;
    }

    public void setSodienthoainhacungcap(String  sodienthoainhacungcap) {
        this.sodienthoainhacungcap = sodienthoainhacungcap;
    }
    
    public void NhapNhaCungCap()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập mã nhà cung cấp: ");
        manhacungcap = in.nextLine();
        System.out.println("Nhập tên nhà cung cấp: ");
        tennhacungcap = in.nextLine();
        System.out.println("Nhập địa chỉ nhà cung cấp: ");
        diachinhacungcap = in.nextLine();
        System.out.println("Nhập số điện thoại nhà cung cấp: ");
        sodienthoainhacungcap = in.nextLine();
    }
    public void XuatNhaCungCap()
    {
        System.out.printf("  %20s | %20s | %20s | %20s \n",manhacungcap,tennhacungcap,diachinhacungcap,sodienthoainhacungcap);
    }
    
    public void docfile(File f , String s){
        String output[] = s.split("_");
        manhacungcap = output[0];
        tennhacungcap = output[1];
        diachinhacungcap = output[2];
        sodienthoainhacungcap = output[3];
       System.out.printf("  %20s | %20s | %20s | %20s \n",manhacungcap,tennhacungcap,diachinhacungcap,sodienthoainhacungcap);        
    }
}
