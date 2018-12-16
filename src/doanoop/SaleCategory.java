
package doanoop;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class SaleCategory {
    public String MaLoaiGiamGia;
    public float PercentOfSale;
    public SaleInformation[] SI;
    public int item;
    public SaleCategory(){
        SI = new SaleInformation[0];
        item = 0;
    }
    
    public SaleCategory(String MaLoaiGiamGia , float PercentOfSale , SaleInformation[] SI , int item){
        this.MaLoaiGiamGia = MaLoaiGiamGia;
        this.PercentOfSale = PercentOfSale;
        this.SI = SI;
        this.item = item;
    }
    
    public SaleCategory(SaleCategory d){
        MaLoaiGiamGia = d.MaLoaiGiamGia;
        PercentOfSale = d.PercentOfSale;
        SI = d.SI;
        item = d.item;
    }
    //hàm nhập mới 1 loại giảm giá
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        String ktra;
        System.out.print("nhập mã loại muốn giảm giá");
        MaLoaiGiamGia = sc.nextLine();
        System.out.print("nhập số tiền muốn giảm: ");
        PercentOfSale = sc.nextFloat()/100;
        do
        {       
            SI = Arrays.copyOf(SI, item+1);
            SI[item] = new SaleInformation();
            SI[item].nhap();
            item++;
            System.out.print("nhấn y nếu bạn muốn nhập thêm hàng???");
            ktra = sc.nextLine();           
        }while(ktra.charAt(0) == 'y');
    }
    //hàm tìm vị trí mã sách của SaleInformation
    public int viTri_MaSach(String MaSach){
        for(int i=0 ; i<item ; i++)
            if(MaSach.equals(SI[i].getMasach()))
                return i;
        return -1;
    }
    //hàm xóa mã sách cho SaleInformation
    public void xoa_MaSach(){
        Scanner sc = new Scanner(System.in);
        String MaSach;
        System.out.print("nhập mã sách bạn muốn xóa");
        MaSach = sc.nextLine();
        int vt = viTri_MaSach(MaSach);
        if(vt != -1)
        {
            for(int i=vt ; i<item ;i++)
                SI[i] = SI[i+1];        
            item--;
            SI = Arrays.copyOf(SI,item);
        }
        else    System.err.println("không có mã sách này");
    }
    // hàm thêm mã sách cho SaleInformation
    public void them_MaSach(){
        SI = Arrays.copyOf(SI , item+1 );
        SI[item].nhap();
        item++;
    }
    //hàm xuất tất cả!!!!!!
    public void xuat()
    {
        System.out.println("mãloạigiảmgiá: "+MaLoaiGiamGia);
        System.out.println("giảm: "+PercentOfSale*100+"%");
        for(SaleInformation i:SI)
            i.xuat();
        System.out.println("số lượng sách đang giảm giá của chuyên mục này: "+item);
    }
    //hàm điều khiển class
    public void console()
    {
        Scanner sc = new Scanner(System.in);
        int chon;
        String ktra;
        LOOP:do{
            System.out.println("nhập 1 xuất thông tin loại giảm giá!!!!");
            System.out.println("nhập 2 để thêm mã sách giảm giá!!!!");
            System.out.println("nhập 3 để xóa mã sách giảm giá!!!!");
            System.out.println("nhập 4 để thay đổi mã sách giảm giá!!!!");
            System.out.println("nhập 5 để thay đổi % tiền giảm giá!!!!!");
            System.out.println("Nhập bất kì để thoát!!!!");
            System.out.print("bạn chọn: ");
            chon = sc.nextInt();
            switch(chon)
            {
                case 1:{
                    xuat();
                    break;
                }
                case 2:{
                    them_MaSach();
                    break;
                }
                case 3:{
                    xoa_MaSach();
                    break;
                }
                case 4:{
                    System.out.print("nhập mã muốn đổi thành: ");
                    String MaLoai = sc.nextLine();
                    setMaLoaiGiamGia(MaLoai);
                }
                case 5:{
                    System.out.print("nhập % tiền muốn đổi thành: ");
                    float sotien = sc.nextFloat()/100;
                    setPercentOfSale(sotien);
                }
                // truy cập vào class SaleInformation
                case 6:{
                    System.out.print("nhập mã sách bạn muốn tìm thông tin");
                    String masach = sc.nextLine();  
                    int i = viTri_MaSach(masach);
                    if(i != -1)
                    SI[i].console();
                    else    System.err.println("không có mã sách này");
                    break;
                }
            }
            System.out.println("nhập y để tiếp tục!!! để thoát nhập bất kì");
            ktra = sc.nextLine();
        }while(ktra.charAt(0) == 'y');
    }

    public String getMaLoaiGiamGia() {
        return MaLoaiGiamGia;
    }

    public void setMaLoaiGiamGia(String MaLoaiGiamGia) {
        this.MaLoaiGiamGia = MaLoaiGiamGia;
    }   
    
    public float getPercentOfSale()
    {
        return PercentOfSale;
    }
    
    public void setPercentOfSale(float PercentOfSale)
    {
        this.PercentOfSale = PercentOfSale;
    }
}
