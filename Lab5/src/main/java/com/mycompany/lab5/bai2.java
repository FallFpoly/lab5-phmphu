/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ICT
 */
public class bai2 {

    static ArrayList<String> ds = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {
            menu();
            System.out.println("chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    nhap();
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    ngauhien();
                    break;
                case 4:
                    sapxep();
                    break;
                case 5:
                    xoa();
                    break;
                case 6:
                    System.out.println("end");
                    break;
                default:
                    System.out.println("chon sai");
        }
        } while (chon != 6);
    }

    public static void menu() {
        System.out.println("+--------------- menu ----------------+");
        System.out.println("|1. Nhập danh sách họ và tên          |");
        System.out.println("|2. Xuất danh sách vừa nhập           |");
        System.out.println("|3. Xuất danh sách ngẫu nhiên         |");
        System.out.println("|4. Xuất danh sách ngẫu nhiên         |");
        System.out.println("|5. Tìm và xóa họ tên nhập từ bàn phím|");
        System.out.println("|6. Thoát                             |");
        System.out.println("+-------------------------------------+");
    }

    public static void nhap() {
        System.out.println("nhap so luong: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("\n nhap ho & ten thu " + i + ": ");
            String hoTen = sc.nextLine();
            ds.add(hoTen);
        }
    }

    public static void xuat() {
        System.out.println("------danh sach------");
        for (String hoTen : ds) {
            System.out.println(hoTen);
        }
    }

    public static void ngauhien() {
        Collections.shuffle(ds);
        System.out.println("------ danh sach ngau nhien ------");
        xuat();
    }

    public static void sapxep() {
        Collections.sort(ds);
        Collections.reverse(ds);
        System.out.println("--- danh sach da sap xep ---");
        xuat();
    }

    public static void xoa() {
        System.out.print("nhap ho & ten can xoa: ");
        String tenCanXoa = sc.nextLine();
        boolean daXoa = false;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).equalsIgnoreCase(tenCanXoa)) {
                ds.remove(i);
                daXoa = true;
                System.out.println("Da xoa: " + tenCanXoa);
                break;
            }
        }
        if (!daXoa) {
            System.out.println("khong tim thay ho & ten can xoa");
        }

    }
    
}
