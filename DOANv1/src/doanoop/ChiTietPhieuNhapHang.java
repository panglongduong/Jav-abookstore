/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanoop;


public class ChiTietPhieuNhapHang {
    String mapnh;
    String masach;
    String manhacc;
    double dongia; 
    double soluong;
    double thanhtien; 
  
     public ChiTietPhieuNhapHang(String mapnh,String masach,double soluong,String manhacc,double thanhtien,double dongia){
        mapnh=this.mapnh;
        masach=this.masach;
        soluong=this.soluong;
        manhacc=this.manhacc;
        dongia=this.dongia;
        thanhtien=this.thanhtien;
     
        
    }
    public ChiTietPhieuNhapHang(ChiTietPhieuNhapHang pnh){
        mapnh=pnh.mapnh;
        masach=pnh.masach;
        manhacc=pnh.manhacc;
        soluong=pnh.soluong;
        dongia=pnh.dongia;
        thanhtien=pnh.thanhtien;
    }

    public String getMapnh() {
        return mapnh;
    }

    public void setMapnh(String mapnh) {
        this.mapnh = mapnh;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getManhacc() {
        return manhacc;
    }

    public void setManhacc(String manhacc) {
        this.manhacc = manhacc;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getSoluong() {
        return soluong;
    }

    public void setSoluong(double soluong) {
        this.soluong = soluong;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
        

}
