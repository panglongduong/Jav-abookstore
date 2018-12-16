
package danhsach;

import doanoop.NhaCungCap;

import java.util.Arrays;
import java.util.Scanner;
public class DanhSachNhaCungCap {
    private int v;
    Scanner in = new Scanner(System.in);
    NhaCungCap [] NCC;

    public DanhSachNhaCungCap() {
    }

    public DanhSachNhaCungCap(int v){
        NCC = new NhaCungCap[v];
        for (int i = 0; i < v; i++) {
            NCC[i]= new NhaCungCap();
            NCC[i].nhapnhacungcap();
        }
    }
    public void NhapDanhSach(){
        System.out.print("Nhập số lượng nhà cung cấp:");
        v=in.nextInt();
        NCC=new NhaCungCap[v];
        for(int i=0;i<v;i++)
        {
            NCC[i] = new NhaCungCap();
            NCC[i].nhapnhacungcap();
        }
    }
    public void XuatDanhSach(){
        System.out.println("Số lượng nhà cung cấp hiện tại:" +v);
        System.out.println("Danh sach nhà cung cấp vừa nhập");
        System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("   %20s | %20s | %20s | %20s \n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC");     
        for(int i=0; i< v;i++)
        {
            System.out.print(i);
            NCC[i].xuatnhacungcap();
        }        
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void them(int slct){
        NCC = Arrays.copyOf(NCC, v+slct);
        for(int i=v; i<v+slct; i++)
        {   
            NCC[i] = new NhaCungCap();
            System.out.println("Nhập nhà cung cấp thứ " + i + " :");
            NCC[i].nhapnhacungcap();
        }
        v+=slct;
    }
    public void xoa(String manhacungcap){
        int id = search_vitri(manhacungcap);
        if(id >= 0){
            for(int i=id; i<v; i++){
                NCC[i]=NCC[i+1];
                v--;
            }
            System.err.println("Đã xóa nhà cung cấp!!!");
        }
        else{
            System.err.println("Không có nhà cung cấp cần xóa!!!");
        }
    }
    public void sua(String manhacungcap){
        int id = search_vitri(manhacungcap);
        if(id >= 0){
            NhaCungCap nv = new NhaCungCap();
            nv = (NhaCungCap) NCC[id];
            Set_NCC(nv);
            NCC[id]=nv;
        }
        else{
            System.err.println("NCCONG CO NCC CAN SUA");
        }
    }
    public void timkiem(){
        int chon = 0;
        Scanner sc= new Scanner(System.in);
        LOOP:
        while (true) {
            System.out.println("============ TÌM THÔNG TIN ================");
            System.out.println("1.Tìm mã nhà cung cấp");
            System.out.println("2.Tìm tên nhà cung cấp");
            System.out.println("3.Thoát");
            System.out.println("Nhập lựa chọn : ");
            chon = in.nextInt();
            switch(chon){
                case 1:
                    System.out.println("Nhập mã nhà cung cấp cần tìm : ");
                    String manhacungcaptk = sc.nextLine();
                    search_mnv(manhacungcaptk);
                    break;
                case 2:
                    System.out.println("Nhập tên nhà cung cấp sản phẩm : ");
                    String tennhacungcaptk = sc.nextLine();
                    search_tnv(tennhacungcaptk);
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
            System.out.println("1.thêm số lượng NCC");
            System.out.println("2.xóa NCC");
            System.out.println("3.Sửa NCC");
            System.out.println("4.Tìm NCC");
            System.out.println("5.Thoát");
            System.out.println("Nhập lựa chọn : ");
            chon = in.nextInt();
            switch(chon){
                case 1:
                    System.out.println("Nhập số lượng NCC cần thêm:");
                    int slct=in.nextInt();
                    them(slct);
                    System.out.println("Số lượng nhà cung cấp hiện tại:" +v);
                    System.out.println("Danh sách nhà cung cấp vừa nhập:");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("   %20s | %20s | %20s | %20s \n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC");     
                    for(int i=0;i<v;i++)
                    {
                        System.out.print(i);
                        NCC[i].xuatnhacungcap();
                    }        
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Nhập mã nhà cung cấp cần xóa:");
                    String manhacungcap = sc.nextLine();
                    xoa(manhacungcap);
                    System.out.println("Số lượng nhà cung cấp hiện tại:" +v);
                    System.out.println("Danh sách nhà cung cấp vừa nhập:");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("   %20s | %20s | %20s | %20s  \n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC");     
                    for(int i=0;i<v;i++)
                    {
                        System.out.print(i);
                        NCC[i].xuatnhacungcap();
                    }        
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("nhập mã nhà cung cấp cần sửa:");
                    String manhacungcaps = sc.nextLine();
                    sua(manhacungcaps);
                    break;
                case  4:
                    timkiem();
                    break;
                default:
                    break LOOP;
            }
        }
    }
    public int search_vitri(String manhacungcap){
        int vt = -1;
        for(int i= 0; i<v;i++){
            if(NCC[i].getManhacc().equals(manhacungcap)){
                vt = i;
                break;
            }
        }
        return vt;
    }
    public void search_mnv(String manhacungcap){
        int id = search_vitri(manhacungcap);
        if(id >= 0){
            System.err.println("Tìm thấy nhà cung cấp");
            System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %20s | %20s | %20s | %20s\n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC");
            NCC[id].xuatnhacungcap();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else{
            System.err.println("Không tìm thấy nhà cung cấp");
        }
    }
    public void search_tnv(String tennhacungcap){
        int id = search_vitri(tennhacungcap);
        if(id >= 0){
            System.err.println("Tìm thấy nhà cung cấp");
            System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %20s | %20s | %20s | %20s | %15s \n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC","CHUC VU");
            NCC[id].xuatnhacungcap();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else{
            System.err.println("Không tìm thấy nhà cung cấp");
        }
    }
    public NhaCungCap Set_NCC(NhaCungCap NCC){
        int chon;
        LOOP:
        while (true) {            
            System.out.println("============ SỬA THÔNG TIN ================");
            System.out.println("1. Thông tin NCC ");
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
                        NCC.xuatnhacungcap();
                        break;
                case 2:
                      System.out.println("Tên NCC ban đầu : " +NCC.getTennhacc());
                      System.out.print("Tên NCC :");
                      in.nextLine();
                      NCC.setTennhacc(in.nextLine());
                    break;
                case 3:
                        System.out.println("Mã NCC ban đầu : " + NCC.getManhacc());
                        System.out.print("Mã NCC : ");
                        in.nextLine();
                        NCC.setManhacc(in.nextLine());
                    break;
                case 4:
                        System.out.println("Địa chỉ nhà cung cấp ban đầu : " + NCC.getDiachi());
                        System.out.print("Địa chỉ nhà cung cấp : ");
                        in.nextLine();
                        NCC.setDiachi(in.nextLine());
                    break;
                case 5:
                        System.out.println("Số điện thoại nhà cung cấp ban đầu : " + NCC.getSdt());
                        System.out.print("Số điện thoại nhà cung cấp : ");
                        in.nextLine();
                        NCC.setSdt(in.nextLine());
                    break;
                case 6:
                        System.out.println("Thông tin ban dau :");
                        NCC.xuatnhacungcap();
                        System.out.print("Mã NCC:");
                        in.nextLine();
                        NCC.setManhacc(in.nextLine());
                        System.out.print("Tên NCC:");
                        in.nextLine();
                        NCC.setTennhacc(in.nextLine());
                        System.out.print("Địa chỉ NCC:");
                        in.nextLine();
                        NCC.setDiachi(in.nextLine());
                        System.out.print("Số điện thoại NCC: ");
                        in.nextLine();
                        NCC.setSdt(in.nextLine());
                        System.out.print("Chức vụ NCC: ");
                    break;
                    default:
                        System.err.println(" SUA HOAN TAT !!!!!");
                    break LOOP;           
            }
        }
        return NCC;
    }
}

