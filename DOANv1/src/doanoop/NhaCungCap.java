/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanoop;

import java.util.Scanner;
public class NhaCungCap {
    String tennhacc;
    String manhacc;
    String diachi;
    String sdt;
    public NhaCungCap(){}
    public NhaCungCap(String tennhacc,String manhacc,String diachi,String sdt){
        tennhacc=this.tennhacc;
        manhacc=this.manhacc;
        diachi=this.diachi;
        sdt=this.sdt;
    }
    public NhaCungCap(NhaCungCap ncc)
    {
        tennhacc=ncc.tennhacc;
        manhacc=ncc.manhacc;
        diachi=ncc.diachi;
        sdt=ncc.sdt;
    }
    public void nhapnhacungcap(){
        Scanner scan=new Scanner(System.in);
        System.out.print("nhap ten nha cc");
        tennhacc=scan.nextLine();
        System.out.print("nhap ma nha cc");
        manhacc=scan.nextLine();
        System.out.print("nhap dia chi nha cc");
        diachi=scan.nextLine();
        System.out.print("nhap sdt nha cc");
        sdt=scan.nextLine();
    }
    public void xuatnhacungcap(){
        System.out.println("ma nha cung cap : "+this.manhacc);
        System.out.println("ten nha cung cap : "+this.tennhacc);
        System.out.println("dia chi nha cung cap : "+this.diachi);
        System.out.println("so dien thoai nha cung cap : "+this.sdt);
        
    }
    public String getTennhacc() {
        return tennhacc;
    }

    public void setTennhacc(String tennhacc) {
        this.tennhacc = tennhacc;
    }

    public String getManhacc() {
        return manhacc;
    }

    public void setManhacc(String manhacc) {
        this.manhacc = manhacc;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
