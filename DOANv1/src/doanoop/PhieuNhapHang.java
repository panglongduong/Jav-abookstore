/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanoop;

import java.util.Scanner;

public class PhieuNhapHang {
    String mapnh;
    String manhanvien;
    double tongtien;
    String ngaynhaphang;
  
    public PhieuNhapHang(){}
    public PhieuNhapHang(String mapnh,String manhacc,String manhanvien,String ngaynhaphang,double tongtien){
        mapnh=this.mapnh;
        manhanvien=this.manhanvien;
        tongtien=this.tongtien;
        ngaynhaphang=this.ngaynhaphang;
        
        
    }
    public PhieuNhapHang(PhieuNhapHang pnh){
        mapnh=pnh.mapnh;
        ngaynhaphang=pnh.ngaynhaphang;
        manhanvien=pnh.manhanvien; 
        tongtien=pnh.tongtien;
    }

     public void nhapphieunhaphang(){
        Scanner scan=new Scanner(System.in);
        System.out.print("nhap ma phieu nhap hang");
        mapnh=scan.nextLine();
        System.out.print("nhap ma nhan vien");
        manhanvien=scan.nextLine();
        System.out.print("nhap ngay nhap hang");
        ngaynhaphang=scan.nextLine();
        System.out.print("nhap tong tien");
        tongtien=scan.nextInt();
    }
    public void xuatphieunhaphang(){
        System.out.println("ma nha cung cap : "+this.mapnh);
        System.out.println("dia chi nha cung cap : "+this.manhanvien);
        System.out.println("so dien thoai nha cung cap : "+this.ngaynhaphang);
        System.out.println("tong tien  : "+this.tongtien);
        
    }
    public String getMapnh() {
        return mapnh;
    }

    public void setMapnh(String mapnh) {
        this.mapnh = mapnh;
    }
    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgaynhaphang() {
        return ngaynhaphang;
    }

    public void setNgaynhaphang(String ngaynhaphang) {
        this.ngaynhaphang = ngaynhaphang;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

  
}
