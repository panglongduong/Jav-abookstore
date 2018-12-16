
package danhsach;



import doanoop.NhaCungCap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class DanhSachNhaCungCap {
    private int v;
   Scanner in = new Scanner(System.in);
    NhaCungCap [] NCC = new NhaCungCap[100];

    public DanhSachNhaCungCap() {
    }
    public DanhSachNhaCungCap(int v){
        NCC = new NhaCungCap[v];
        for (int i = 0; i < v; i++) {
            NCC[i]= new NhaCungCap();
            NCC[i].NhapNhaCungCap();
        }
    }
    public void NhapDanhSach(){
        System.out.print("Nhập số lượng nhà cung cấp:");
        v=in.nextInt();
        for(int i=0;i<v;i++)
        {
            NCC[i] = new NhaCungCap();
            NCC[i].NhapNhaCungCap();
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
            NCC[i].XuatNhaCungCap();
        }        
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void them(int slct){
        NCC = Arrays.copyOf(NCC, v+slct + 1);//
        for(int i=v; i<v+slct; i++)
        {   
            NCC[i] = new NhaCungCap();
            System.out.println("Nhập nhà cung cấp thứ " + i + " :");
            NCC[i].NhapNhaCungCap();
        }
        v+=slct;
    }
    public void xoa(String manhacungcap){
        int id = search_vitri(manhacungcap);
        System.out.println("\n  "+id);
        System.out.println("\n v =  "+v);
        if(id >= 0){
            for(int i=id; i<v; i++){
                
                NCC[i]=NCC[i+1];
            }
            v--;
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
            System.err.println("KHONG CO NCC CAN SUA");
        }
    }
    public void timkiem(){
        int chon = 0;
        Scanner in= new Scanner(System.in);
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
                    in.nextLine();
                    System.out.println("Nhập mã nhà cung cấp cần tìm : ");
                    String manhacungcaptk = in.nextLine();
                    search_mnv(manhacungcaptk);
                    break;
                case 2:
                    in.nextLine();
                    System.out.println("Nhập tên nhà cung cấp  : ");
                    String tennhacungcaptk = in.nextLine();
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
        while(true){
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
                    System.out.println("Số lượng khách hàng hiện tại:" +v);
                    System.out.println("Danh sách khách hàng vừa nhập:");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("   %20s | %20s | %20s | %20s \n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC");     
                    for(int i=0;i<v;i++)
                    {
                        System.out.print(i);
                        NCC[i].XuatNhaCungCap();
                    }        
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    in.nextLine();                                      
                    System.out.println("Nhập mã nhà cung cấp cần xóa:");
                    String ma123 = in.nextLine();
                    xoa(ma123);
                    int demstt=0;
                  //  for(int i=0;i<;i++)
                    System.out.println("Số lượng khách hàng hiện tại:" +v);
                    System.out.println("Danh sách nhà cung cấp vừa nhập:");
                    System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("   %20s | %20s | %20s | %20s  \n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC");     
                    for(int i=0;i<v;i++)
                    {
                        System.out.print(i);
                        NCC[i].XuatNhaCungCap();
                    }        
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    in.nextLine();                                        
                    System.out.println("nhập mã nhà cung cấp cần sửa:");
                    String manhacungcaps = in.nextLine();
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
            if(NCC[i].getManhacungcap().equals(manhacungcap)){
                vt = i;
                break;
            }
        }
        return vt;
    }
        public int search_vitri1(String tennhacungcap){
        int vt = -1;
        for(int i= 0; i<v;i++){
            if(NCC[i].getTennhacungcap().equals(tennhacungcap)){
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
            NCC[id].XuatNhaCungCap();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else{
            System.err.println("Không tìm thấy nhà cung cấp");
        }
    }
    public void search_tnv(String tennhacungcap){
        int id = search_vitri1(tennhacungcap);
        
        System.out.println("  "+id+tennhacungcap);
        if(id >= 0){
            System.err.println("Tìm thấy nhà cung cấp");
            System.out.printf("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %20s | %20s | %20s | %20s\n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC");
            NCC[id].XuatNhaCungCap();
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
            System.out.println("2. Tên Nhà Cung Cấp ");
            System.out.println("3. Mã Nhà Cung Cấp ");
            System.out.println("4. Địa Chỉ Nhà Cung Cấp ");
            System.out.println("5. Số Điện Thoại Nhà Cung Cấp ");            
            System.out.println("6. Tất cả ");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn :");
            chon = in.nextInt();
            switch(chon){
                case 1:
                        NCC.XuatNhaCungCap();
                        break;
                case 2:
                      System.out.println("Tên NCC ban đầu : " +NCC.getTennhacungcap());
                      System.out.print("Tên NCC :");
                      in.nextLine();
                      NCC.setTennhacungcap(in.nextLine());
                    break;
                case 3:
                        System.out.println("Mã NCC ban đầu : " + NCC.getManhacungcap());
                        System.out.print("Mã NCC : ");
                        in.nextLine();
                        NCC.setManhacungcap(in.nextLine());
                    break;
                case 4:
                        System.out.println("Địa chỉ nhà cung cấp ban đầu : " + NCC.getDiachinhacungcap());
                        System.out.print("Địa chỉ nhà cung cấp : ");
                        in.nextLine();
                        NCC.setDiachinhacungcap(in.nextLine());
                    break;
                case 5:
                        System.out.println("Số điện thoại nhà cung cấp ban đầu : " + NCC.getSodienthoainhacungcap());
                        System.out.print("Số điện thoại nhà cung cấp : ");
                        in.nextLine();
                        NCC.setSodienthoainhacungcap(in.nextLine());
                    break;
                case 6:
                        System.out.println("Thông tin ban dau :");
                        NCC.XuatNhaCungCap(); 
                        in.nextLine();
                        System.out.print("Mã NCC:");
                        String moi1=in.nextLine();
                        NCC.setManhacungcap(moi1);
                        System.out.print("Tên NCC:");                        
                        NCC.setTennhacungcap(in.nextLine());
                        System.out.print("Địa chỉ NCC:");                        
                        NCC.setDiachinhacungcap(in.nextLine());
                        System.out.print("Số điện thoại NCC: ");
                        NCC.setSodienthoainhacungcap(in.nextLine());
                        break;
                    default:                   
                    break LOOP;           
            }
        }
        return NCC;
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
                mnv = NCC[i].getManhacungcap();
                tennv = NCC[i].getTennhacungcap();
                diachi = NCC[i].getDiachinhacungcap();
                sdt = NCC[i].getSodienthoainhacungcap();
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
    System.out.printf("  %20s | %20s | %20s | %20s \n","MA NCC","TEN NCC","DIA CHI NCC","SDT NCC");    
        Scanner sc = new Scanner(f);
        try{
            String s;
            String[] outFile;
            while(sc.hasNext())
            {
                s = sc.nextLine();
                NCC[v] = new NhaCungCap();
                NCC[v].docfile(f,s);
                v++;
            }
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        sc.close();
        NCC = Arrays.copyOf(NCC,v+1);
    }
}