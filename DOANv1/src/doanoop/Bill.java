/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanoop;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class Bill {
    private String MaHoaDon ;
    private String MaNhanVien;
    private String MaKhachHang;
    private BillDetails[] ChiTiet = new BillDetails[0];
    private int SoLuongHang = 0;
    private Calendar Date;
    private double Tong;
    private boolean finish = false;
    
    
    public Bill(){}
    
    
    public Bill(String MaHoaDon,String MaNhanVien,String MaKhachHang,BillDetails ChiTiet[],int SoLuongHang,boolean finish)
    {
        this.MaHoaDon = MaHoaDon;
        this.MaNhanVien = MaNhanVien;
        this.MaKhachHang = MaKhachHang;
        this.ChiTiet = ChiTiet;
        this.SoLuongHang = SoLuongHang;
        this.finish = finish;
    }
    
    public Bill(Bill d)        
    {   
        MaHoaDon = d.MaHoaDon;
        MaNhanVien = d.MaNhanVien;
        MaKhachHang = d.MaKhachHang;
        ChiTiet = d.ChiTiet;
        SoLuongHang = d.SoLuongHang;
        finish = d.finish;
    }
    
    public void nhap()
    {
        String ktra;
        Scanner sc = new Scanner(System.in);
        boolean date = true;
        System.out.print("nhập mã hóa đơn: ");
        MaHoaDon = sc.nextLine();
        System.out.print("nhập mã nhân viên : ");
        MaNhanVien = sc.nextLine();
        System.out.print("nhập mã khách hàng: ");
        MaKhachHang = sc.nextLine();
        do
        {       
            ChiTiet = Arrays.copyOf(ChiTiet, SoLuongHang+1);
            ChiTiet[SoLuongHang] = new BillDetails();
            ChiTiet[SoLuongHang].nhap();
            SoLuongHang++;
            System.out.print("nhấn y nếu bạn muốn nhập thêm hàng???");
            ktra = sc.nextLine();           
        }while(ktra.charAt(0) == 'y');
    } 
    //hàm tính tổng tiền
    public void ThanhToan()
    {
        double s = 0;
        for(int i = 1; i <= SoLuongHang ; i++)
            s = ChiTiet[i].tinhTien();
        finish = true;
        thongTinHoaDon();
        Date = Calendar.getInstance();
    }
    //hàm xuất thông tin hóa đơn
    public void thongTinHoaDon()                          
    {
        System.out.printf("Mã hóa đơn: %s\n",MaHoaDon);
        System.out.printf("Mã nhân viên phụ trách: %s\n",MaNhanVien);
        System.out.printf("Mã khách hàng: %s\n",MaKhachHang);
        for(int i=0; i<SoLuongHang ; i++)
            ChiTiet[i].xuat();
        for(int i = 1; i <= SoLuongHang ; i++)
            Tong = ChiTiet[i].tinhTien();
        System.out.print("      Tổng tiền hiện tại:"+Tong);
        if(finish)  System.out.println("thời điểm xuat hóa đơn: "+Date.getTime());
    }
    //hàm tìm kiếm sản phẩm
    public int viTri_SanPham(String msp)         
    {
        for(int i=0 ; i<SoLuongHang ; i++)
        {
            if(msp.equals(ChiTiet[i].getMaSach()))
                return i;
        }
        return -1;
    }
    //hàm xóa 1 sp
    public void xoa_SanPham()                         
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập mã sách muốn xóa: ");
        String msp;
        msp = sc.nextLine();        
        int vt = viTri_SanPham(msp);
        if(vt  != -1)
        {
            for(int i=vt ; i<SoLuongHang ; i++)
                ChiTiet[i] = ChiTiet[i+1];
            SoLuongHang--;    
             ChiTiet = Arrays.copyOf(ChiTiet, SoLuongHang);
        }
        else    System.err.println("không có mã sách này!!!!");
    }
    // hàm thêm sản phẩm
    public void them_SanPham()
    {
        ChiTiet = Arrays.copyOf(ChiTiet, SoLuongHang+1);
        ChiTiet[SoLuongHang] = new BillDetails();
        ChiTiet[SoLuongHang].nhap();
        SoLuongHang++;
    }
    //hàm điều khiển class
    public void console()
    {
        Scanner sc = new Scanner(System.in);
        int chon;
        String ktra;
        String xacnhan;
        String password;
        String cancel;
        boolean admin = false;
        System.out.println("nếu muốn sửa hóa đơn đã tính xin hãy xác thực quyền hạn!!!");
        System.out.print("bạn có quyền sửa hóa đơn???? \r\nnhập y để xác nhận hoặc nhập bất kì");
        xacnhan =sc.nextLine();
        if(xacnhan.charAt(0) == 'y')
        {
            LOOP:    do
            { 
                System.out.print("xin nhập password;");
                password = sc.nextLine();
                if(password.equals("abc"))
                    admin = true;
                if(!admin) 
                {
                    System.err.println("sai password!!!! nhập y nếu muốn thoát!!!!");
                    cancel = sc.nextLine();
                    if(cancel.charAt(0) == 'y')
                    break;
                }    
            }while(!admin );
        }
        if(finish && !admin)
            System.err.print("Hóa đơn đã thanh toán ko thể sửa!!!!");
        else
        {
LOOP:        do
            {                
                System.out.println("nhập 1 nếu muốn xuất thông tin hóa đơn hiện tại");
                System.out.println("nhập 2 nếu muốn thêm sp!!!!");
                System.out.println("nhập 3 nếu muốn xóa sp!!!");
                if(!finish) System.out.print("nhập 4 nếu muốn thanh toán hóa đơn!!!");
                System.out.println("nhập 5 nếu muốn xem chi tiết sản phẩm");
                System.out.println("nhập bất kì nếu muốn thoát");
                System.out.println("hãy chọn phương thức bạn muôn: ");
                chon = sc.nextInt();
                if(finish && chon==4 ) chon = 1;
                switch(chon)
                {
                    case 1:{
                        thongTinHoaDon();
                        if(!finish) System.out.print("hóa đơn chưa thanh toán");
                    }
                    case 2:{
                        them_SanPham();
                        break;               
                    }
                    case 3:{
                        xoa_SanPham();   
                        break;
                    }                                        
                    case 4:{
                        ThanhToan();
                        break;
                    }
                    case 5:{
                        System.out.print("nhập mã sản phẩm cần biết chi tiết");
                        String masach = sc.nextLine();
                        int i = viTri_SanPham(masach);
                        if(i != -1)
                            ChiTiet[i].console();
                        else    System.err.println("không có sản phẩm này!!!!!");
                        break;
                    }
                    default:
                        break LOOP;
                }
                System.out.println("muốn tiếp tục sửa nhập y!!!!");
                System.out.println("nhập bất kì nếu muốn thoát!!!");
                System.out.println("bạn có muốn tếp tục???? ");
                ktra = sc.nextLine();
            }while(ktra.charAt(0) == 'y');
        }
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getSoLuongHang() {
        return SoLuongHang;
    }

    public void setSoLuongHang(int SoLuongHang) {
        this.SoLuongHang = SoLuongHang;
    }
    
   
}
