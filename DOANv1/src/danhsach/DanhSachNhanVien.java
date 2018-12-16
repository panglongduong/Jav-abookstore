
package danhsach;



import doanoop.NhanVien;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class DanhSachNhanVien {
    private int v;
   Scanner in = new Scanner(System.in);
    NhanVien [] NV = new NhanVien[100];

    public DanhSachNhanVien() {
    }
    public DanhSachNhanVien(int v){
        NV = new NhanVien[v];
        for (int i = 0; i < v; i++) {
            NV[i]= new NhanVien();
            NV[i].NhapNhanVien();
        }
    }
    public void NhapDanhSach(){
        System.out.print("Nhập số lượng nhân viên:");
        v=in.nextInt();
        for(int i=0;i<v;i++)
        {
            NV[i] = new NhanVien();
            NV[i].NhapNhanVien();
        }
    }
    public void XuatDanhSach(){
        System.out.println("Số lượng nhân viên hiện tại:" +v);
        System.out.println("Danh sach nhân viên vừa nhập");
        System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("   %20s | %20s | %20s | %20s \n","MA NV","TEN NV","DIA CHI NV","SDT NV");     
        for(int i=0; i< v;i++)
        {
            System.out.print(i);
            NV[i].XuatNhanVien();
        }        
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void them(int slct){
        NV = Arrays.copyOf(NV, v+slct + 1);//
        for(int i=v; i<v+slct; i++)
        {   
            NV[i] = new NhanVien();
            System.out.println("Nhập nhân viên thứ " + i + " :");
            NV[i].NhapNhanVien();
        }
        v+=slct;
    }
    public void xoa(String manhanvien){
        int id = search_vitri(manhanvien);
        System.out.println("\n  "+id);
        System.out.println("\n v =  "+v);
        if(id >= 0){
            for(int i=id; i<v; i++){
                
                NV[i]=NV[i+1];
            }
            v--;
            System.err.println("Đã xóa nhân viên!!!");
        }
        else{
            System.err.println("Không có nhân viên cần xóa!!!");
        }
    }
    public void sua(String manhanvien){
        int id = search_vitri(manhanvien);
        if(id >= 0){
            NhanVien nv = new NhanVien();
            nv = (NhanVien) NV[id];
            Set_NV(nv);
            NV[id]=nv;
        }
        else{
            System.err.println("KHONG CO NV CAN SUA");
        }
    }
    public void timkiem(){
        int chon = 0;
        Scanner in= new Scanner(System.in);
        LOOP:
        while (true) {
            System.out.println("============ TÌM THÔNG TIN ================");
            System.out.println("1.Tìm mã nhân viên");
            System.out.println("2.Tìm tên nhân viên");
            System.out.println("3.Thoát");
            System.out.println("Nhập lựa chọn : ");
            chon = in.nextInt();
            switch(chon){
                case 1:
                    in.nextLine();
                    System.out.println("Nhập mã nhân viên cần tìm : ");
                    String manhanvientk = in.nextLine();
                    search_mnv(manhanvientk);
                    break;
                case 2:
                    in.nextLine();
                    System.out.println("Nhập tên nhân viên  : ");
                    String tennhanvientk = in.nextLine();
                    search_tnv(tennhanvientk);
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
        while(true){
            System.out.println("1.thêm số lượng NV");
            System.out.println("2.xóa NV");
            System.out.println("3.Sửa NV");
            System.out.println("4.Tìm NV");
            System.out.println("5.Thoát");
            System.out.println("Nhập lựa chọn : ");
            chon = in.nextInt();
            switch(chon){
                case 1:
                    System.out.println("Nhập số lượng NV cần thêm:");
                    int slct=in.nextInt();
                    them(slct);
                    System.out.println("Số lượng khách hàng hiện tại:" +v);
                    System.out.println("Danh sách khách hàng vừa nhập:");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("   %20s | %20s | %20s | %20s \n","MA NV","TEN NV","DIA CHI NV","SDT NV");     
                    for(int i=0;i<v;i++)
                    {
                        System.out.print(i);
                        NV[i].XuatNhanVien();
                    }        
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    in.nextLine();                                      
                    System.out.println("Nhập mã nhân viên cần xóa:");
                    String ma123 = in.nextLine();
                    xoa(ma123);
                    int demstt=0;
                  //  for(int i=0;i<;i++)
                    System.out.println("Số lượng khách hàng hiện tại:" +v);
                    System.out.println("Danh sách nhân viên vừa nhập:");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("   %20s | %20s | %20s | %20s  \n","MA NV","TEN NV","DIA CHI NV","SDT NV");     
                    for(int i=0;i<v;i++)
                    {
                        System.out.print(i);
                        NV[i].XuatNhanVien();
                    }        
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    in.nextLine();                                        
                    System.out.println("nhập mã nhân viên cần sửa:");
                    String manhanviens = in.nextLine();
                    sua(manhanviens);
                    break;
                case  4:
                    timkiem();
                    break;
                default:
                    break LOOP;
            }
        }
    }
    public int search_vitri(String manhanvien){
        int vt = -1;
        for(int i= 0; i<v;i++){
            if(NV[i].getManhanvien().equals(manhanvien)){
                vt = i;
                break;
            }
        }
        return vt;
    }
        public int search_vitri1(String tennhanvien){
        int vt = -1;
        for(int i= 0; i<v;i++){
            if(NV[i].getTennhanvien().equals(tennhanvien)){
                vt = i;
                break;
            }
        }
        return vt;
    }
    public void search_mnv(String manhanvien){
        int id = search_vitri(manhanvien);
        if(id >= 0){
            System.err.println("Tìm thấy nhân viên");
            System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %20s | %20s | %20s | %20s\n","MA NV","TEN NV","DIA CHI NV","SDT NV");
            NV[id].XuatNhanVien();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else{
            System.err.println("Không tìm thấy nhân viên");
        }
    }
    public void search_tnv(String tennhanvien){
        int id = search_vitri1(tennhanvien);
        
        System.out.println("  "+id+tennhanvien);
        if(id >= 0){
            System.err.println("Tìm thấy nhân viên");
            System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %20s | %20s | %20s | %20s\n","MA NV","TEN NV","DIA CHI NV","SDT NV");
            NV[id].XuatNhanVien();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else{
            System.err.println("Không tìm thấy nhân viên");
        }
    }
    public NhanVien Set_NV(NhanVien NV){
        int chon;
        LOOP:
        while (true) {            
            System.out.println("============ SỬA THÔNG TIN ================");
            System.out.println("1. Thông tin NV ");
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
                        NV.XuatNhanVien();
                        break;
                case 2:
                      System.out.println("Tên NV ban đầu : " +NV.getTennhanvien());
                      System.out.print("Tên NV :");
                      in.nextLine();
                      NV.setTennhanvien(in.nextLine());
                    break;
                case 3:
                        System.out.println("Mã NV ban đầu : " + NV.getManhanvien());
                        System.out.print("Mã NV : ");
                        in.nextLine();
                        NV.setManhanvien(in.nextLine());
                    break;
                case 4:
                        System.out.println("Địa chỉ nhân viên ban đầu : " + NV.getDiachinhanvien());
                        System.out.print("Địa chỉ nhân viên : ");
                        in.nextLine();
                        NV.setDiachinhanvien(in.nextLine());
                    break;
                case 5:
                        System.out.println("Số điện thoại nhân viên ban đầu : " + NV.getSodienthoainhanvien());
                        System.out.print("Số điện thoại nhân viên : ");
                        in.nextLine();
                        NV.setSodienthoainhanvien(in.nextLine());
                    break;
                case 6:
                        System.out.println("Thông tin ban dau :");
                        NV.XuatNhanVien(); 
                        in.nextLine();
                        System.out.print("Mã NV:");
                        String moi1=in.nextLine();
                        NV.setManhanvien(moi1);
                        System.out.print("Tên NV:");                        
                        NV.setTennhanvien(in.nextLine());
                        System.out.print("Địa chỉ NV:");                        
                        NV.setDiachinhanvien(in.nextLine());
                        System.out.print("Số điện thoại NV: ");
                        NV.setSodienthoainhanvien(in.nextLine());
                        break;
                    default:                   
                    break LOOP;           
            }
        }
        return NV;
    }


public void ghifile() throws IOException{
    
    String mnv;
    String tennv;
    String diachi;
    String sdt;
    File f = new File("testfile.txt");        //ghi file
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        try{
            for(int i =0 ; i<v ; i++)
            {
                mnv = NV[i].getManhanvien();
                tennv = NV[i].getTennhanvien();
                diachi = NV[i].getDiachinhanvien();
                sdt = NV[i].getSodienthoainhanvien();
                pw.write(mnv+"_");
                pw.write(tennv+"_");
                pw.write(diachi+"_");
                pw.write(sdt+"\r\n");
            }
        }catch(Exception e){
            System.out.println("lỗi đọc file: "+e);
        }
        pw.close();
        bw.close();
        fw.close();
        
    }
public void docfile() throws FileNotFoundException{
    File f = new File("testfile.txt");
    v=0;
    System.out.printf("  %20s | %20s | %20s | %20s \n","MA NV","TEN NV","DIA CHI NV","SDT NV");    
        Scanner sc = new Scanner(f);
        try{
            String s;
            String[] outFile;
            while(sc.hasNext())
            {
                s = sc.nextLine();
                NV[v] = new NhanVien();
                NV[v].docfile(f,s);
                v++;
            }
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        sc.close();
        NV = Arrays.copyOf(NV,v+1);
    }
}