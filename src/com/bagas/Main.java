package com.bagas;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Selamat datang di Bagas Tower");
        // input nama
        String nama = namaInput();
        System.out.println("Hello "+nama+"! Selamat datang!");

        // input lantai penjemputan
        int lantaiPenjemputan = lantaiInput("penjemputan");

        // input lantai tujuan
        int lantaiTujuan = lantaiInput("tujuan");

        // lantai awal dipilih secara acak
        int lantaiAwal = randomLantaiAwal();

        // notifikasi jika lantai penjemputan dan tujuan yang dipilih sama
        if (lantaiPenjemputan == lantaiTujuan){
            System.out.println("Saat ini anda berada di lantai yang sama yaitu lantai "+lantaiPenjemputan);
            System.out.println("Sehingga anda tidak perlu naik lift. Terimakasih");
            return;
        }

        // lift bekerja
        liftBergerak(lantaiTujuan,lantaiPenjemputan,lantaiAwal);
        System.out.println("Terima kasih, anda sudah di lantai tujuan");

    }

    public static String namaInput(){
        System.out.println("Tolong masukkan nama adnda (minimal 5 karakter) : ");

        Scanner scanner = new Scanner(System.in);
        String nama = scanner.next();

        // cek jumlah karakter yg diinput (minimal 5)
        if (nama.length()<5){
            System.out.println("Nama anda harus lebih dari 4 karakter!");
            return namaInput();
        }else {
            return nama;
        }
    }

    public static int lantaiInput(String penjemputanOrTujuan){
        System.out.println("Silahkan masukkan lantai "+penjemputanOrTujuan+" (1-10): ");

        Scanner scanner = new Scanner(System.in);
        int lantai = scanner.nextInt();

        // cek lantai antara 1-10
        if (lantai >=1 && lantai <=10){
           return lantai;
        }else {
            System.out.println("Lantai yang anda masukkan harus di rentang 1-10!");
            return lantaiInput(penjemputanOrTujuan);
        }
    }

    public static int randomLantaiAwal(){
        Random random = new Random();
        int lantaiAwal = random.nextInt(10) +1;

        System.out.println("Saat ini lift berada di lantai: "+lantaiAwal);
        return lantaiAwal;
    }

    public static void liftBergerak(int lantaiTujuan, int lantaiPenjemputan, int lantaiAwal){
        System.out.println("Mohon menunggu, lift akan segera bergerak menjemput anda");

        if (lantaiAwal<lantaiPenjemputan){
            for (int i = 0; i <  lantaiPenjemputan -lantaiAwal ; i++) {
                System.out.println("Lift naik ke lantai : "+ (lantaiAwal+(i+1)) );
            }
        }else {
            for (int i = 0; i < lantaiAwal - lantaiPenjemputan; i++) {
                System.out.println("Lift turun ke lantai : "+ (lantaiAwal-(i+1)) );
            }
        }

        System.out.println("Lift sudah sampai di lokasi penjemputan, pintu lift terbuka");
        System.out.println("Silakan masuk, Anda akan diantar ke lantai tujuan");

        if (lantaiTujuan<lantaiPenjemputan){
            for (int i = 0; i <  lantaiPenjemputan -lantaiTujuan ; i++) {
                System.out.println("Lift turun ke lantai : "+ (lantaiPenjemputan-(i+1)) );
            }
        }else {
            for (int i = 0; i < lantaiTujuan - lantaiPenjemputan; i++) {
                System.out.println("Lift naik ke lantai : "+ (lantaiPenjemputan+(i+1)) );
            }
        }

        System.out.println("Liift sudah sampai di lokasi tujuan, pintu lift terbuka");
    }
}
