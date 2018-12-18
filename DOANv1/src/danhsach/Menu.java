
package danhsach;
import java.io.*;
import java.util.*;


import java.io.IOException;

public class Menu {
    Scanner in = new Scanner(System.in);
     
    public static void main(String []args) throws IOException
    {
        
        Scanner a = new Scanner(System.in);
        
        
        DanhSachNhanVien  ds = new DanhSachNhanVien();
        DanhSachKhachHang kh = new DanhSachKhachHang();
        DanhSachNhaCungCap ncc = new  DanhSachNhaCungCap();
        
        int check = 0;
        int  b = dangnhap();
        if(b == -2)   check = 1;   
         
        System.out.print("\n==============CUA HANG SACH==============");
        System.out.print("\n------------------MENU--------------------");
        System.out.print("\n| 1.Quan ly  nhan vien                   |"
		        		+"\n| 2.Quan ly khach hang                   |"
		        		+"\n| 3.Quan ly nha cung cap                 |"
		        		+"\n| 4----------------------------------    |"
		        		+"\n| 5.----------------------------------   |"
		        		+"\n| 6.----------------------------------   |"
		        		+"\n| 7.----------------------------------   |"
		        		+"\n| 8.----------------------------------   |"
		        		+"\n| 9.----------------------------------   |"
		        		+"\n| 10.Thoat                               |");
        System.out.print("\n+----------------------------------------+");
        
        System.out.print("\nHay chon muc:");
        int muc = a.nextInt();
        
        while(muc!= 10)          // khac 10 thi nhay vao day
        {
      
        switch(muc)
        {
            case 1:
                if(check == 0)
                {
                    ds.docfile();
                    ds.instruction();
                    //ds.XuatDanhSach();
                    ds.ghifile();
                }
                else  System.out.println("Nguoi dung khong co chuc nang nay!");
                 break;   
            case 2:
                kh.docfile();
                kh.instruction();
                //kh.XuatDanhSach();
                kh.ghifile();
                break;
            case 3: 
           
                ncc.docfile();
                ncc.instruction();
                //ncc.XuatDanhSach();
                ncc.ghifile();
                break;
            case 4: break;
            case 5: break;
            case 6: break;
            case 7: break;
            case 8: break;
            case 9: break;
            default: System.out.println("Lua chon khong hop le. xin vui long nhap lai!");
           
         }
        System.out.print("\n==============CUA HANG SACH==============");
        System.out.print("\n------------------MENU--------------------");
        System.out.print("\n| 1.Quan ly  nhan vien                   |"
		        		+"\n| 2.Quan ly khach hang                   |"
		        		+"\n| 3.Quan ly nha cung cap                 |"
		        		+"\n| 4----------------------------------    |"
		        		+"\n| 5.----------------------------------   |"
		        		+"\n| 6.----------------------------------   |"
		        		+"\n| 7.----------------------------------   |"
		        		+"\n| 8.----------------------------------   |"
		        		+"\n| 9.----------------------------------   |"
		        		+"\n| 10.Thoat                               |");
        System.out.print("\n+----------------------------------------+");
        
        System.out.print("\nHay chon muc:");
         muc = a.nextInt();
       }
        
        System.out.print("\nDa thoat cac muc! \n----THE END----\n");   //khi muc = 10 
          
    }
    public static int dangnhap()
    {
        
        String tk,mk;
        Scanner scan = new Scanner(System.in);
        /*System.out.print("Tai Khoan :");
        tk = scan.nextLine();
        System.out.print("Mat Khau :");
        mk = scan.nextLine();
        
        while((!tk.equals("admin") || !mk.equals("admin")) && (!tk.equals("duong") || !mk.equals("duong")))
        {
            System.err.printf("Tài khoản không đúng \n");
            System.out.print("Tai Khoan :");
            tk = scan.nextLine();
            System.out.print("Mat Khau :");
            mk = scan.nextLine();
            
        }
        if(tk.equals("duong") && mk.equals("duong") ) return -2;
        return -1;}*/
        
        do{
            
        System.out.print("Tai Khoan :");
        tk = scan.nextLine();
        System.out.print("Mat Khau :");
        mk = scan.nextLine();
        if((!tk.equals("admin") || !mk.equals("admin")) && (!tk.equals("duong") || !mk.equals("duong")))
        {
            System.err.printf("Tài khoản không đúng . xin vui lòng kiểm tra lại\n");
        }
        if(tk.equals("duong") && mk.equals("duong"))  return -2;
        }while((!tk.equals("admin") || !mk.equals("admin")) && (!tk.equals("duong") || !mk.equals("duong")));
        return -1;
    }
    
    


    }
