
package doanoop;

import java.util.Scanner;

public class BillDetails {
    private String MaSach;
    private int SoLuong;
    private float GiaSach;
    private float ThanhTien;
    
    public BillDetails(){}  

    public BillDetails(String MaSach, int SoLuong, float GiaSach) {
        this.MaSach = MaSach;
        this.SoLuong = SoLuong;
        this.GiaSach = GiaSach;
    }
    
    public BillDetails(BillDetails d)
    {
        MaSach = d.MaSach;
        SoLuong = d.SoLuong;
        GiaSach = d.GiaSach;
    }
    
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhập mã sách muốn mua");
        MaSach = sc.nextLine();
        System.out.print("nhập số lượng muốn mua: ");
        SoLuong = sc.nextInt();
        System.out.print("nhập giá mỗi cuốn sách; ");
        GiaSach = sc.nextFloat();
    }
    //hàm dùng để xuất chi tiết hóa đơn
    public void xuat()
    {
        System.out.printf("%s",MaSach);
        System.out.printf("%20d",SoLuong);
        System.out.printf("%20f\n",tinhTien());
    }
    //hàm điều khiển class
    public void console()
    {
        Scanner sc = new Scanner(System.in);
        int chon;
        String ktra;
        LOOP:do{
            System.out.println("nhập 2 để thay đổ mã sách");
            System.out.println("nhập 3 để thay đổi số lượng");
            System.out.println("nhập 4 để thay đổi giá tiền");
            System.out.println("nhập bất kì để thoát");
            System.out.print("bạn chọn: ");
            chon = sc.nextInt();
            switch(chon){
                case 1:{
                    xuat();
                    break;
                }
                case 2:{
                    System.out.print("nhập mã sách bạn muốn đổi thành: ");
                    String masach = sc.nextLine();
                    setMaSach(masach);
                    break;
                }
                case 3:{
                    System.out.print("nhập số lượng muốn đổi thành: ");
                    int soluong = sc.nextInt();
                    setSoLuong(soluong);
                    break;
                }
                case 4:{
                    System.out.print("nhập giá sách muốn đổi thành");
                    float giasach = sc.nextFloat();
                    setGiaSach(giasach);
                    break;
                }
                default:    break LOOP;
            }
            System.out.println("nhập y để tiếp tục!!! để thoát nhập bất kì");
            ktra = sc.nextLine();
        }while(ktra.charAt(0) == 'y');
    }
    
    public float tinhTien()
    {
        return ThanhTien = SoLuong * GiaSach; 
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaSach() {
        return GiaSach;
    }

    public void setGiaSach(float GiaSach) {
        this.GiaSach = GiaSach;
    }
}
