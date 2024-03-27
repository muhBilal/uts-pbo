package org.example;

import java.util.Random;

class Animals {
    private String name;
    private int jumlah;
    private double berat;
    private int stok;
    private int hargaSatuan;
    private int hargaTotal;

    public void setName(String name) {
        this.name = name;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public void setHargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public String getName() {
        return name;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getBerat() {
        return berat;
    }

    public int getStok() {
        return stok;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    public int getHargaTotal() {
        return hargaTotal;
    }

    public void calculateHargaTotal(int stok, int hargaSatuan) {
        hargaTotal = stok * hargaSatuan;
    }

    public void displayInfo(String name, int jumlah, double berat, int stok, int hargaSatuan, int hargaTotal) {
        System.out.println("Nama Hewan : " + name);
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Berat : " + berat);
        System.out.println("Stok : " + stok);
        System.out.println("Harga Satuan : " + hargaSatuan);
        System.out.println("Harga Total : " + hargaTotal);
        System.out.println();
    }
}

class totalHargaSemua {
    private int totalHargaSemua;

    public void setTotalHargaSemua(Animals[] hewan) {
        int total = 0;
        for (Animals animal : hewan) {
            total += animal.getHargaTotal();
        }
        this.totalHargaSemua = total;
    }

    public int getTotalHargaSemua() {
        return totalHargaSemua;
    }
}

public class mainAnimals {
    public static double generateRandomWeight(double min, double max) {
        Random random = new Random();
        return (int) (min + (max - min) * random.nextDouble());
    }

    public static void main(String[] args) {
        Animals[] hewan = new Animals[21];

        System.out.println("===============================");
        System.out.println("Hewan Kambing Jantan");
        System.out.println("===============================");
        for (int i = 0; i < 6; i++) {
            hewan[i] = new Animals();
            hewan[i].setName("kambing jantan");
            hewan[i].setJumlah(1);
            hewan[i].setBerat(generateRandomWeight(19, 24));
            hewan[i].setStok(hewan[i].getJumlah());
            hewan[i].setHargaSatuan(1000000);
            hewan[i].calculateHargaTotal(hewan[i].getJumlah(), hewan[i].getHargaSatuan());
            hewan[i].displayInfo(hewan[i].getName(), hewan[i].getJumlah(), hewan[i].getBerat(), hewan[i].getStok(), hewan[i].getHargaSatuan(), hewan[i].getHargaTotal());
        }

        System.out.println("===============================");
        System.out.println("Hewan Kambing Betina");
        System.out.println("===============================");
        for (int i = 6; i < 11; i++) { // Menggunakan indeks yang berbeda
            hewan[i] = new Animals();
            hewan[i].setName("kambing betina");
            hewan[i].setJumlah(1);
            hewan[i].setBerat(generateRandomWeight(16, 22));
            hewan[i].setStok(hewan[i].getJumlah());
            hewan[i].setHargaSatuan(2000000);
            hewan[i].calculateHargaTotal(hewan[i].getJumlah(), hewan[i].getHargaSatuan());
            hewan[i].displayInfo(hewan[i].getName(), hewan[i].getJumlah(), hewan[i].getBerat(), hewan[i].getStok(), hewan[i].getHargaSatuan(), hewan[i].getHargaTotal());
        }

        System.out.println("===============================");
        System.out.println("Hewan Anakan Kambing");
        System.out.println("===============================");
        for (int i = 11; i < 21; i++) { // Menggunakan indeks yang berbeda
            hewan[i] = new Animals();
            hewan[i].setName("anakan kambing");
            hewan[i].setJumlah(1);
            hewan[i].setBerat(generateRandomWeight(2.2, 3.0));
            hewan[i].setStok(hewan[i].getJumlah());
            hewan[i].setHargaSatuan(500000);
            hewan[i].calculateHargaTotal(hewan[i].getJumlah(), hewan[i].getHargaSatuan());
            hewan[i].displayInfo(hewan[i].getName(), hewan[i].getJumlah(), hewan[i].getBerat(), hewan[i].getStok(), hewan[i].getHargaSatuan(), hewan[i].getHargaTotal());
        }

        totalHargaSemua totalHarga = new totalHargaSemua();
        totalHarga.setTotalHargaSemua(hewan);
        System.out.println("Total Harga Semua Hewan : " + totalHarga.getTotalHargaSemua());
    }
}
