package org.example;

class employee {
    private String golongan;
    private double gajiPokok;
    private double tunjangan;
    private double thr;
    private double gajike13;
    private double bonus;
    private double pajak;
    private double pendapatan;
    private double gajiBersih;

    //getter
    public String getGolongan() {
        return golongan;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public double getTunjangan() {
        return tunjangan;
    }

    public double getThr() {
        return thr;
    }

    public double getGajike13() {
        return gajike13;
    }

    public double getBonus() {
        return bonus;
    }

    public double getPajak() {
        return pajak;
    }

    public double getPendapatan() {
        return pendapatan;
    }

    public double getGajiBersih() {
        return gajiBersih;
    }


    // setter
    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
    }

    public void setThr(double thr) {
        this.thr = thr;
    }

    public void setGajike13(double gajike13) {
        this.gajike13 = gajike13;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setPajak(double pajak) {
        this.pajak = pajak;
    }

    public void setPendapatan(double pendapatan) {
        this.pendapatan = pendapatan;
    }

    public void setGajiBersih(double gajiBersih) {
        this.gajiBersih = gajiBersih;
    }


    public void calculatePendapatan(double gajiPokok, double tunjangan, double thr, double gajike13, double bonus) {
        pendapatan = (gajiPokok * 12) + tunjangan + thr + gajike13 + bonus;
    }

    public void calculatePajak(double pendapatan, double gajiPokok, double bonus, double tunjanga, double thr, double gajike13) {
        double gajiperbulan = pendapatan / 12;
        if(gajiperbulan <= 5000000) {
            pajak = 0;
        } else {
            pajak = pendapatan * 6/100;
        }
    }

    public void calculateGajiBersih(double pendapatan, double pajak) {
        gajiBersih = pendapatan - pajak;
    }

    public void displayInfo(String golongan, double gajiPokok, double tunjangan, double thr, double gajike13, double bonus, double pajak, double pendapatan, double gajiBersih) {
        System.out.println("Golongan : " + golongan);
        System.out.println("Gaji Pokok : " + gajiPokok);
        System.out.println("Tunjangan : " + tunjangan);
        System.out.println("THR : " + thr);
        System.out.println("Gaji ke-13 : " + gajike13);
        System.out.println("Bonus : " + bonus);
        System.out.println("Pajak : " + pajak);
        System.out.println("Pendapatan : " + pendapatan);
        System.out.println("Gaji Bersih : " + gajiBersih);
    }

}

public class mainEmployee {
    public static void findGolongan(employee bilal, String golongan) {
        int gajiPokok = 0;
        switch (golongan) {
            case "pegawai kontrak":
                gajiPokok = 3700000;
                bilal.setGajiPokok(gajiPokok);
                bilal.setTunjangan(gajiPokok * (10/100));
                bilal.setThr(gajiPokok);
                bilal.setGajike13(gajiPokok);
                bilal.setBonus(gajiPokok * 2);
                break;
            case "pegawai tetap":
                gajiPokok = 3700000;
                bilal.setGajiPokok(gajiPokok);
                bilal.setTunjangan(gajiPokok * (10/100));
                bilal.setThr(gajiPokok * 1.3);
                bilal.setGajike13(gajiPokok);
                bilal.setBonus(gajiPokok * 1.3 * 2);
                break;
            case "supervisor":
                gajiPokok = 5300000;
                bilal.setGajiPokok(gajiPokok);
                bilal.setTunjangan(gajiPokok * (20/100));
                bilal.setThr(gajiPokok * 1.3);
                bilal.setGajike13(gajiPokok);
                bilal.setBonus(gajiPokok * 2 * 2);
                break;
            case "manajer":
                gajiPokok = 7500000;
                bilal.setGajiPokok(gajiPokok);
                bilal.setTunjangan(gajiPokok * (20/100));
                bilal.setThr(gajiPokok * 1.3);
                bilal.setGajike13(gajiPokok);
                bilal.setBonus(gajiPokok * 5 * 2);
                break;
            case "eksekutif":
                gajiPokok = 18000000;
                bilal.setGajiPokok(gajiPokok);
                bilal.setTunjangan(gajiPokok * (20/100));
                bilal.setThr(gajiPokok * 1.3);
                bilal.setGajike13(gajiPokok);
                bilal.setBonus(gajiPokok * 14.1 * 2);
                break;
            default:
                System.out.println("Golongan tidak ditemukan");
        }
    }

    public static void main(String[] args) {
        employee bilal = new employee();
        bilal.setGolongan("eksekutif");
        findGolongan(bilal, bilal.getGolongan());
        bilal.calculatePendapatan(bilal.getGajiPokok(), bilal.getTunjangan(), bilal.getThr(), bilal.getGajike13(), bilal.getBonus());
        bilal.calculatePajak(bilal.getPendapatan(), bilal.getGajiPokok(), bilal.getBonus(), bilal.getTunjangan(), bilal.getThr(), bilal.getGajike13());
        bilal.calculateGajiBersih(bilal.getPendapatan(), bilal.getPajak());
        bilal.displayInfo(bilal.getGolongan(), bilal.getGajiPokok(), bilal.getTunjangan(), bilal.getThr(), bilal.getGajike13(), bilal.getBonus(), bilal.getPajak(), bilal.getPendapatan(), bilal.getGajiBersih());
    }
}
