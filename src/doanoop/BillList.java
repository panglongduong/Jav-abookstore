/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanoop;

import java.util.Arrays;
import java.util.Scanner;

public class BillList {
    private int n=0;
    private Bill[] dshd;
    public BillList(){
        dshd = new Bill[0];
        n=0;
    }
    public BillList(Bill[] newhd,int n){
        this.n = n;
        dshd = newhd;
    }
    public BillList(BillList d)
    {
        n = d.n;
        dshd = d.dshd;
    }
    
    public void nhap()
    {
        dshd = Arrays.copyOf(dshd, n+1);
        dshd[n] = new Bill();
        dshd[n].nhap();
        n++;
    }
    //hàm trả về vị trí mã hóa đơn
    public int viTri_HoaDon (String mahoadon)       
    {
        for(int i=0 ; i<n ; i++)   
        {
            if(mahoadon.equals(dshd[i].getMaHoaDon()));
            {
                return i;
            }
        }
        return -1;
    }
    // h//xuất tất cả hóa đơn tim
    public void xoa_HoaDon(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập mã hóa đơn muốn xóa: ");
        String mahoadon;
        mahoadon = sc.nextLine();        
        int vt = viTri_HoaDon(mahoadon);
        if(vt  != -1)
        {
            for(int i=vt ; i<n ; i++)
                dshd[i] = dshd[i+1];
            n--;    
            dshd = Arrays.copyOf(dshd, n);
        }
        else    System.err.println("không có mã hóa đơn này!!!!");
    }
    //xuất tất cả hóa đơn
    public void xuat()          
    {
        for(int i=0 ; i<n ; i++)
            dshd[i].thongTinHoaDon();
    }
    // hàm điều khiển class
    public void console()
   {
        Scanner sc = new Scanner(System.in);
        int chon;
        String ktra;
        LOOP:do{
            System.out.println("nhập 1 để xuất danh sách hóa đơn!!!!");
            System.out.println("nhập 2 để xóa hóa đơn!!!!");
            System.out.println("nhập 3 để xem thông tin hóa đơn!!!!"); 
            System.out.println("nhập 4 để tiếp tục phiên làm việc!!!!"); 
            System.out.println("nhập bất kì để thoát!!!!");
            System.out.println("nhập bạn chọn: ");
            chon = sc.nextInt();
            switch(chon)
            {
                case 1:{
                    xuat();
                    break;
                }
                case 2:{
                    xoa_HoaDon();
                    break;
                }
                case 3:{
                    System.out.print("nhập mã hóa đơn cần biết thông tin");
                    String mahoadon = sc.nextLine();
                    int i = viTri_HoaDon(mahoadon);
                    if(i != -1)
                        dshd[i].console();
                    else    System.err.println("không có hóa đơn này!!!!!");
                    break;
                }
                case 4:{
                    nhap();
                    break;
                }
                default:     break LOOP;
            }
            System.out.println("muốn tiếp tục sửa nhập y!!!!");
            System.out.println("nhập bất kì nếu muốn thoát!!!");
            System.out.println("bạn có muốn tếp tục???? ");
            ktra = sc.nextLine();
        }while(ktra.charAt(0) == 'y');
   }
}
