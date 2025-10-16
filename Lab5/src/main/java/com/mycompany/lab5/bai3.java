/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author ICT
 */
public class bai3 {

    static ArrayList<SanPham> ds = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {
            menu();
            System.out.print("Chon chuc nang: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    nhap();
                    break;
                case 2:
                    sapxep();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    giaTrungBinh();
                    break;
                case 5:
                    System.out.println("END GAME!");
                    break;
                default:
                    System.out.println("ERROR!");
            }
        } while (chon != 5);
    }
    public static void menu() {
        System.out.println("\n+---------------- MENU ----------------+");
        System.out.println("|1. Nhap danh sach san pham              |");
        System.out.println("|2. Sap xep giam dan theo gia va xuat    |");
        System.out.println("|3. Tim va xoa san pham theo ten         |");
        System.out.println("|4. Xuat gia trung binh san pham         |");
        System.out.println("|5. Thoat                                |");
        System.out.println("+----------------------------------------+");
    }
    public static void nhap() {
        System.out.print("Nhap so luong san pham: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap san pham thu " + (i + 1) + ": ");
            String ten = sc.nextLine();
            System.out.printf("Nhap gia san pham: ");
            Double gia = Double.parseDouble(sc.nextLine());
            ds.add(new SanPham(ten, gia));
        }
    }
    public static void xuat() {
        System.out.println("----- Danh sach san pham -----");
        for (SanPham sp : ds) {
            System.out.println(sp);
        }
    }
    public static void sapxep() {
        Comparator<SanPham> comp = new Comparator<SanPham>() {
            @Override
            public int compare(SanPham o1, SanPham o2) {
                return o1.donGia.compareTo(o2.donGia);
            }
        };
        Collections.sort(ds, comp);
        Collections.reverse(ds); // để thành giảm dần
        System.out.println("----- Danh sach san pham giam dan -----");
        xuat();
    }

    public static void xoa() {
        System.out.print("Nhap san pham can xoa: ");
        String tenCanXoa = sc.nextLine();
        boolean daXoa = false;
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).ten.equalsIgnoreCase(tenCanXoa)) {
                ds.remove(i);
                daXoa = true;
                System.out.println("Da xoa: " + tenCanXoa);
                break;
            }
        }
        if (!daXoa) {
            System.out.println("Khong tim thay san pham can xoa.");
        }
    }
    public static void giaTrungBinh() {
        if (ds.isEmpty()) {
            System.out.println("Danh sach trong");
            return;
        }
        double tong = 0;
        for (SanPham sp : ds) {
            tong += sp.donGia;
        }
        double tb = tong / ds.size();
        System.out.println("Gia trung binh: " + tb);
    }
}
class SanPham {
    String ten;
    Double donGia;

    public SanPham(String ten, Double donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }
    @Override
    public String toString() {
        return ten + " - " + String.format("%,.0f", donGia);
    }
}

