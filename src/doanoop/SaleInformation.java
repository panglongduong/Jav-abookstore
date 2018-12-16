/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanoop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class SaleInformation {
    private String MaSach;
    private String DateStringStart;
    private String DateStringEnd;
    private int DayStart,DayEnd,MonthStart,MonthEnd,YearStart,YearEnd;
    
    
    public SaleInformation(){}   
    public SaleInformation(String MaSach,String DateStringStart,String DateStringEnd)
    {
        this.MaSach = MaSach;
        this.DateStringStart = DateStringStart;
        setDmyStart(DateStringStart);
        this.DateStringEnd = DateStringEnd;
        setDateStringEnd(DateStringEnd);
    } 
    
    public SaleInformation(SaleInformation d)
    {
        MaSach = d.MaSach;
        DateStringStart = d.DateStringStart;
        setDateStringStart(d.DateStringStart);
        DateStringEnd = d.DateStringEnd;
        setDateStringEnd(d.DateStringEnd);
    }
    
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        boolean dateStart = false,dateEnd = false;
        System.out.print("nhập mã sách bạn muốn giảm giá: ");
        MaSach = sc.nextLine();
        System.out.print("nhập ngày bắt đầu giảm giá cho sản phẩm: ");
        do
        {
            DateStringStart = sc.nextLine();
            setDmyStart(DateStringStart);
            df.setLenient(false);
            try
            {
                df.parse(DateStringStart);
                dateStart = true;
            }
            catch(ParseException e)
            {
                System.out.print("lỗi!!!! vui lòng nhập lại ngày bắt đầu giảm giá: ");
            }
        }while(dateStart == false);
        
        System.out.print("nhập ngày két thúc giảm gá cho sản phẩm: ");
        do
        {
            DateStringEnd = sc.nextLine();
            setDmyEnd(DateStringEnd);
            df.setLenient(false);
            try
            {
                df.parse(DateStringEnd);
                dateEnd = true;
            }
            catch(ParseException e)
            {
                System.out.print("lỗi!!!! vui lòng nhập lại ngày kết thúc giảm giá:");
            }
        }while(dateEnd == false);
    }
    
    public void xuat()
    {
        System.out.println("mã sách giảm giá: "+MaSach);
        System.out.print("bắt đầu từ ngày: "+DateStringStart);
        System.out.println(" đến ngày: "+DateStringEnd);
    }
    // hàm điều khiển class
    public void console()
    {        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String ktra;
        int chon;
        LOOP:do{
            System.out.println("nhập 1 để xuất thông tin sản phẩm!!!");
            System.out.println("nhập 2 để thay đổi mã sách!!!");
            System.out.println("nhập 3 để thay đổi ngày bắt đầu giảm giá");
            System.out.println("nhập 4 để thay đổi ngày kết thúc giảm giá!!!!");
            System.out.println("nhập bất kì để thoát!!!!");
            System.out.print("bạn chọn: ");
            chon = sc.nextInt();
            switch(chon)
            {
                case 1:{
                    xuat();
                    break;
                }
                case 2:{
                    System.out.print("nhập mã sách muốn đổi thành");
                    String masach = sc.nextLine();
                    setMaSach(masach);
                }
                case 3:
                    {
                        System.out.print("nhập ngày tháng năm mới:");
                        DateStringStart = sc.nextLine();
                        df.setLenient(false);
                        try {
                            df.parse(DateStringStart);
                        }catch (ParseException e) {
                            System.out.println("lỗi ngày/tháng/năm không hợp lệ");
                        }
                        break;
                    }
                    case 4:
                    {
                        System.out.print("nhập ngày tháng năm mới:");
                        DateStringEnd = sc.nextLine();
                        df.setLenient(false);
                        try {
                            df.parse(DateStringStart);
                        }catch (ParseException e) {
                            System.out.println("lỗi ngày/tháng/năm không hợp lệ");
                        }
                        break;
                    }
                default:    break LOOP;
            }
            System.out.println("nhập y để tiếp tục!!! để thoát nhập bất kì");
            ktra = sc.nextLine();
        }while(ktra.charAt(0) == 'y');
        
    }
        
    private void setDmyStart(String date){
        String[] output = date.split("/");
        DayStart = Integer.parseInt(output[0]);
        MonthStart = Integer.parseInt(output[1]);
        YearStart = Integer.parseInt(output[2]);
    }
    
    private void setDmyEnd(String date){
        String[] output = date.split("/");
        DayEnd = Integer.parseInt(output[0]);
        MonthEnd = Integer.parseInt(output[1]);
        YearEnd = Integer.parseInt(output[2]);
    }
  
    public String getMasach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getDateStringStart() {
        return DateStringStart;
    }

    public String getDateStringEnd() {
        return DateStringEnd;
    }

    public void setDateStringStart(String dateStringStart) {
        this.DateStringStart = dateStringStart;
    }

    public void setDateStringEnd(String dateStringEnd) {
        this.DateStringEnd = dateStringEnd;
    }

    public int getDayStart() {
        return DayStart;
    }

    public int getDayEnd() {
        return DayEnd;
    }

    public int getMonthStart() {
        return MonthStart;
    }

    public int getMonthEnd() {
        return MonthEnd;
    }

    public int getYearStart() {
        return YearStart;
    }

    public int getYearEnd() {
        return YearEnd;
    }
}
