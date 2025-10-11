//Name : 
//Mssv : 
//Date : 
//Slide:

package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class bai1 {

    public static void main(String[] args) {

        //
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> ds = new ArrayList<>();
        double x;
                int i=0;
        while(true){
            System.out.println("nhap  pt thu "+i+": ");
            System.out.print("nhap x:");
            x = sc.nextDouble();
            ds.add(x);
           sc.nextLine();
            System.out.println("nhap them (Y/N)?");
            String tiepTuc = sc.nextLine();
           // sc.close();
            if(tiepTuc.equalsIgnoreCase("N")){
                break;
            }
            i++;
            
        }
        System.out.println("danh sach so thuc: ");
        double tong = 0;
        for(Double so: ds){
            System.out.println("so"+ds);
            tong+=so;
            
        }
        System.out.println("tong cac so thuc: "+tong);
    }

}
