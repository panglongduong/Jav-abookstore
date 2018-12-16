
package danhsach;



import doanoop.KhachHang;
import java.util.Arrays;
import java.util.Scanner;
public class DanhSachKhachHang {
    private int v;
    Scanner in = new Scanner(System.in);
    KhachHang [] KH;

    public DanhSachKhachHang() {
    }

    public DanhSachKhachHang(int v){
        KH = new KhachHang[v];
        for (int i = 0; i < v; i++) {
            KH[i]= new KhachHang();
            KH[i].NhapKhachHang();
        }
    }
    public void NhapDanhSach(){
        System.out.print("Nhập số lượng khách hàng:");
        v=in.nextInt();
        KH=new KhachHang[v];
        for(int i=0;i<v;i++)
        {
            KH[i] = new KhachHang();
            KH[i].NhapKhachHang();
        }
    }
    public void XuatDanhSach(){
        System.out.println("Số lượng khách hàng hiện tại:" +v);
        System.out.println("Danh sach khách hàng vừa nhập");
        System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("   %20s | %20s | %20s | %20s \n","MA KH","TEN KH","DIA CHI KH","SDT KH");     
        for(int i=0; i< v;i++)
        {
            System.out.print(i);
            KH[i].XuatKhachHang();
        }        
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void them(int slct){
        KH = Arrays.copyOf(KH, v+slct);
        for(int i=v; i<v+slct; i++)
        {   
            KH[i] = new KhachHang();
            System.out.println("Nhập khách hàng thứ " + i + " :");
            KH[i].NhapKhachHang();
        }
        v+=slct;
    }
    public void xoa(String makhachhang){
        int id = search_vitri(makhachhang);
        if(id >= 0){
            for(int i=id; i<v; i++){
                KH[i]=KH[i+1];
                v--;
            }
            System.err.println("Đã xóa khách hàng!!!");
        }
        else{
            System.err.println("Không có khách hàng cần xóa!!!");
        }
    }
    public void sua(String makhachhang){
        int id = search_vitri(makhachhang);
        if(id >= 0){
            KhachHang nv = new KhachHang();
            nv = (KhachHang) KH[id];
            Set_KH(nv);
            KH[id]=nv;
        }
        else{
            System.err.println("KHONG CO KH CAN SUA");
        }
    }
    public void timkiem(){
        int chon = 0;
        Scanner sc= new Scanner(System.in);
        LOOP:
        while (true) {
            System.out.println("============ TÌM THÔNG TIN ================");
            System.out.println("1.Tìm mã khách hàng");
            System.out.println("2.Tìm tên khách hàng");
            System.out.println("3.Thoát");
            System.out.println("Nhập lựa chọn : ");
            chon = in.nextInt();
            switch(chon){
                case 1:
                    System.out.println("Nhập mã khách hàng cần tìm : ");
                    String makhachhangtk = sc.nextLine();
                    search_mnv(makhachhangtk);
                    break;
                case 2:
                    System.out.println("Nhập tên khách hàng: ");
                    String tenkhachhangtk = sc.nextLine();
                    search_tnv(tenkhachhangtk);
                    break;
                default:
                    break LOOP;
            }
        }
    }
    public void instruction(){
        Scanner sc= new Scanner(System.in);
        int chon = 0;
       
        LOOP:
        while (true) { 
            System.out.println("1.thêm số lượng KH");
            System.out.println("2.xóa KH");
            System.out.println("3.Sửa KH");
            System.out.println("4.Tìm KH");
            System.out.println("5.Thoát");
            System.out.println("Nhập lựa chọn : ");
            chon = in.nextInt();
            switch(chon){
                case 1:
                    System.out.println("Nhập số lượng KH cần thêm:");
                    int slct=in.nextInt();
                    them(slct);
                    System.out.println("Số lượng khách hàng hiện tại:" +v);
                    System.out.println("Danh sách khách hàng vừa nhập:");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("   %20s | %20s | %20s | %20s \n","MA KH","TEN KH","DIA CHI KH","SDT KH");     
                    for(int i=0;i<v;i++)
                    {
                        System.out.print(i);
                        KH[i].XuatKhachHang();
                    }        
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Nhập mã khách hàng cần xóa:");
                    String makhachhang = sc.nextLine();
                    xoa(makhachhang);
                    System.out.println("Số lượng khách hàng hiện tại:" +v);
                    System.out.println("Danh sách khách hàng vừa nhập:");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("   %20s | %20s | %20s | %20s  \n","MA KH","TEN KH","DIA CHI KH","SDT KH");     
                    for(int i=0;i<v;i++)
                    {
                        System.out.print(i);
                        KH[i].XuatKhachHang();
                    }        
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("nhập mã khách hàng cần sửa:");
                    String makhachhangs = sc.nextLine();
                    sua(makhachhangs);
                    break;
                case  4:
                    timkiem();
                    break;
                default:
                    break LOOP;
            }
        }
    }
    public int search_vitri(String makhachhang){
        int vt = -1;
        for(int i= 0; i<v;i++){
            if(KH[i].getMakhachhang().equals(makhachhang)){
                vt = i;
                break;
            }
        }
        return vt;
    }
    public void search_mnv(String makhachhang){
        int id = search_vitri(makhachhang);
        if(id >= 0){
            System.err.println("Tìm thấy khách hàng");
            System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %20s | %20s | %20s | %20s\n","MA KH","TEN KH","DIA CHI KH","SDT KH");
            KH[id].XuatKhachHang();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else{
            System.err.println("Không tìm thấy khách hàng");
        }
    }
    public void search_tnv(String tenkhachhang){
        int id = search_vitri(tenkhachhang);
        if(id >= 0){
            System.err.println("Tìm thấy khách hàng");
            System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %20s | %20s | %20s | %20s | %15s \n","MA KH","TEN KH","DIA CHI KH","SDT KH","CHUC VU");
            KH[id].XuatKhachHang();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else{
            System.err.println("Không tìm thấy khách hàng");
        }
    }
    public KhachHang Set_KH(KhachHang KH){
        int chon;
        LOOP:
        while (true) {            
            System.out.println("============ SỬA THÔNG TIN ================");
            System.out.println("1. Thông tin KH ");
            System.out.println("2. Tên Nhân Viên ");
            System.out.println("3. Mã Nhân Viên ");
            System.out.println("4. Địa Chỉ Nhân Viên ");
            System.out.println("5. Số Điện Thoại Nhân Viên ");
            
            System.out.println("6. Tất cả ");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn :");
            chon = in.nextInt();
            switch(chon){
                case 1:
                        KH.XuatKhachHang();
                        break;
                case 2:
                      System.out.println("Tên KH ban đầu : " +KH.getTenkhachhang());
                      System.out.print("Tên KH :");
                      in.nextLine();
                      KH.setTenkhachhang(in.nextLine());
                    break;
                case 3:
                        System.out.println("Mã KH ban đầu : " + KH.getMakhachhang());
                        System.out.print("Mã KH : ");
                        in.nextLine();
                        KH.setMakhachhang(in.nextLine());
                    break;
                case 4:
                        System.out.println("Địa chỉ khách hàng ban đầu : " + KH.getDiachikhachhang());
                        System.out.print("Địa chỉ khách hàng : ");
                        in.nextLine();
                        KH.setDiachikhachhang(in.nextLine());
                    break;
                case 5:
                        System.out.println("Số điện thoại khách hàng ban đầu : " + KH.getSodienthoaikhachhang());
                        System.out.print("Số điện thoại khách hàng : ");
                        in.nextLine();
                        KH.setSodienthoaikhachhang(in.nextInt());
                    break;
                case 6:
                        System.out.println("Thông tin ban dau :");
                        KH.XuatKhachHang();
                        System.out.print("Mã KH:");
                        in.nextLine();
                        KH.setMakhachhang(in.nextLine());
                        System.out.print("Tên KH:");
                        in.nextLine();
                        KH.setTenkhachhang(in.nextLine());
                        System.out.print("Địa chỉ KH:");
                        in.nextLine();
                        KH.setDiachikhachhang(in.nextLine());
                        System.out.print("Số điện thoại KH: ");
                        in.nextLine();
                        KH.setSodienthoaikhachhang(in.nextInt());
                        System.out.print("Chức vụ KH: ");
                    break;
                    default:
                        System.err.println(" SUA HOAN TAT !!!!!");
                    break LOOP;           
            }
        }
        return KH;
    }
}

