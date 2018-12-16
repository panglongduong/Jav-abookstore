/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanoop;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class ArraySaleCategory {
    
    public SaleCategory []SaleCat;
    private int item;
    
    
    public ArraySaleCategory(){
        SaleCat = new SaleCategory[0];
        item = 0;
    }
    public ArraySaleCategory(SaleCategory[] SaleCat, int item) {
        this.SaleCat = SaleCat;
        this.item = item;
    }
    public ArraySaleCategory(ArraySaleCategory d){
        SaleCat = d.SaleCat;
        item = d.item;
    }
    
    public void nhap()
    {
        SaleCat = Arrays.copyOf(SaleCat, item+1);
        SaleCat[item] = new SaleCategory();
        SaleCat[item].nhap();
        item++;
    }
    // hàm xuất tất cả!!!!!!!!
    public void xuat()
    {
        for(int i=0 ; i<item ; i++)
           SaleCat[i].xuat();
    }
    // hàm tìm vị trí của mã loại giảm giá(SaleCat)
    public int viTri_MaLoai(String maloai)
    {
        for(int i=1 ; i<=item ;i++)
        {
            if(SaleCat[i].getMaLoaiGiamGia().equals(maloai))
                return i;
        }
        return -1;
    }
    //thêm mã loại giảm giá(SaleCat)
    public void them_MaLoai()    
    {
        SaleCat = Arrays.copyOf(SaleCat , item+1 );
        SaleCat[item].nhap();
        item++;
    }
    //hàm xóa mã loại giảm giá(SaleCat)
    public void xoa_MaLoai(){
        Scanner sc = new Scanner(System.in);
        String MaSach;
        System.out.print("nhập mã loại bạn muốn xóa");
        MaSach = sc.nextLine();
        int vt = viTri_MaLoai(MaSach);
        if(vt != -1)
        {
            for(int i=vt ; i<item ;i++)
                SaleCat[i] = SaleCat[i+1];        
            item--;
            SaleCat = Arrays.copyOf(SaleCat,item);
        }
        else    System.err.println("không có loại này");
    }
    // hàm điều khiển class
    public void console()
    {
        Scanner sc = new Scanner(System.in);
        int chon;
        String ktra;
        LOOP:do{
            System.out.println("nhập 1 xuất thông tin các loại giảm giá!!!!");
            System.out.println("nhập 2 để thêm mã loại giảm giá!!!!");
            System.out.println("nhập 3 để xóa mã loại giảm giá!!!!");
            System.out.println("nhập 4 để thay đổi thông tin mã loại!!!!");
            System.out.print("nhập bất kì để thoát!!!!");
            System.out.print("bạn chọn: ");
            chon = sc.nextInt();
            switch(chon){
                case 1:{
                    xuat();
                    break;
                }
                case 2:{
                    them_MaLoai();
                    break;
                }
                case 3:{
                    xoa_MaLoai();
                    break;
                }
                // truy cập vào class SaleCategory
                case 4:{
                    System.out.print("nhập mã loại bạn muốn tìm thông tin");
                    String maloai = sc.nextLine();  
                    int i = viTri_MaLoai(maloai);
                    if(i != -1)
                    SaleCat[i].console();
                    else    System.err.println("không có mã loại này!!!!");
                    break;
                }
                default:    break LOOP;
            }
            System.out.println("nhập y để tiếp tục!!! để thoát nhập bất kì");
            ktra = sc.nextLine();
        }while(ktra.charAt(0) == 'y');
    }
}
