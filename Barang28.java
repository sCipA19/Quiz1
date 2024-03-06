import java.util.Scanner;
public class Barang28 {
   
        private String kode;
        private String nama;
        private int harga;
        private int stok;
    
    public Barang28(String kode, String nama, int harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
    
    public String getKode() {
        return kode;
    }
    public String getNama() {
        return nama;
    }

    public int getHarga() { 
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String toString() {
        return String.format("| %-5s | %-20s | Rp %-10d | %-5d |", kode, nama, harga, stok);
    }



    public class TransaksiBarang {
  
    private Barang28[] barangs;
    private Pembelian[] pembelians;

    public TransaksiBarang(Barang28[] barangs) {
        this.barangs = barangs;
        this.pembelians = new Pembelian[0];
    }

    public void tampilkanBarang() {
        System.out.println("+---------------------------------------+");
        System.out.println("| Kode | Nama Barang   | Harga   | Stok |");
        System.out.println("+---------------------------------------+");
        for (Barang28 barang : barangs) {
            System.out.println(barang);
        }
        System.out.println("+---------------------------------------+");
        
    }

    public void lakukanPembelian(String kodeBarang, int jumlah) {
        Barang28 barang = findBarangByKode(kodeBarang);
        if (barang != null) {
            if (barang.getStok() >= jumlah) {
                Pembelian pembelian = new Pembelian(barang, jumlah);
                barang.setStok(barang.getStok() - jumlah);
                addPembelian(pembelian);
                System.out.println("Pembelian " + barang.getNama() + " sebanyak " + jumlah + " berhasil!");
            } else {
                System.out.println("Stok barang " + barang.getNama() + " tidak mencukupi!");
            }
        } else {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan!");
        }
    }

    public void tampilkanPembelian() {
        if (pembelians.length > 0) {
            System.out.println("+---------------------------------------+");
            System.out.println("| Nama Barang        | Jumlah | Harga   |");
            System.out.println("+---------------------------------------+");
            for (Pembelian pembelian : pembelians) {
                System.out.println("| " + pembelian.getBarang().getNama() + " | " + pembelian.getJumlah() + " | Rp " + pembelian.getHarga() + " |");
            }
            System.out.println("+---------------------------------------+");
            int totalHarga = 0;
            for (Pembelian pembelian : pembelians) {
                totalHarga += pembelian.getHarga();
            }
            System.out.println("Total Harga: Rp " + totalHarga);
        } else {
            System.out.println("Belum ada pembelian!");
        }
    }

    private Barang28 findBarangByKode(String kodeBarang) {
        for (Barang28 barang : barangs) {
            if (barang.getKode().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }

    private void addPembelian(Pembelian pembelian) {
        Pembelian[] newPembelians = new Pembelian[pembelians.length + 1];
        for (int i = 0; i < pembelians.length; i++) {
            newPembelians[i] = pembelians[i];
        }
        newPembelians[newPembelians.length - 1] = pembelian;
        pembelians = newPembelians;
       
    }
}

public class Pembelian {

    private Barang28 barang;
    private int jumlah;
    private int harga;

    public Pembelian(Barang28 barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
        this.harga = getHarga() * jumlah;
    }

    public Barang28 getBarang() {
        return barang; 
    }

    public int getJumlah() {
        return jumlah; 
    }

    public int getHarga() {
        return harga;
    }
}
}

