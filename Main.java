package tokoKue;

import java.text.DecimalFormat;

public class Main {
    
    public static void main(String[] args) {
     
        Kue[] cake = new Kue[20];
        cake[0] = new KuePesanan("Lapis", 5000, 2);
        cake[1] = new KuePesanan("Cucur", 30000, 2);
        cake[2] = new KuePesanan("Putu Ayu", 45000, 3);
        cake[3] = new KuePesanan("Nastar", 7500, 2);
        cake[4] = new KuePesanan("Cookies", 40000, 3);
        cake[5] = new KuePesanan("Brownis", 35000, 2);
        cake[6] = new KuePesanan("Cheese Cake", 70000, 3);
        cake[7] = new KuePesanan("Putri Salju", 15000, 4);
        cake[8] = new KuePesanan("Bika Ambon", 40000, 2);
        cake[9] = new KuePesanan("Tiramissu", 30000, 2);
        cake[10] = new KueJadi("Rainbow Cake", 60000, 2);
        cake[11] = new KueJadi("Almond Cake", 47000, 3);
        cake[12] = new KueJadi("Chiffon Cake", 65000, 4);
        cake[13] = new KueJadi("Padan Cake", 25000, 2);
        cake[14] = new KueJadi("Red Velvet Cake", 26500, 2);
        cake[15] = new KueJadi("Blueberry Cake", 15000, 2);
        cake[16] = new KueJadi("Strawbery Cake", 17500, 3);
        cake[17] = new KueJadi("Lemon Cake", 7000, 2);
        cake[18] = new KueJadi("Peanut Cake", 38000, 4);
        cake[19] = new KueJadi("Choco Cookies", 7000, 2);

        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("==========Daftar Kue========== ");
        for (Kue k : cake) {
            String jenis = (k instanceof KuePesanan) ? "Kue Pesanan" : "Kue Jadi";
            System.out.println("Nama kue   : " + k.getNama());
            System.out.println("Harga      : Rp " + df.format(k.hitungHarga()));
            System.out.println("Jenis Kue  : " + jenis);
            System.out.println();
        } 

    double totalHargaSemuaKue = 0;
    double totalHargaKuePesanan = 0;
    double totalBeratKuePesanan = 0;
    double totalHargaKueJadi = 0;
    double totalJumlahKueJadi = 0;
    double hargaTertinggi = 0;
    String jenisKueTertinggi = "";
    String namaKueTertinggi = "";

    for (Kue k : cake){
       
        if (k instanceof KuePesanan){
            totalHargaKuePesanan += k.hitungHarga();
            totalBeratKuePesanan += ((KuePesanan) k).getBerat();
        } else if (k instanceof KueJadi){
            totalHargaKueJadi += k.hitungHarga();
            totalJumlahKueJadi += ((KueJadi)k).getJumlah();
        }

        totalHargaSemuaKue += k.hitungHarga();

        if (k.getHarga() > hargaTertinggi){
            hargaTertinggi = k.getHarga();
            namaKueTertinggi = k.getNama();
            jenisKueTertinggi = (k instanceof KuePesanan)? "Kue Pesanan" : "Kue Jadi";
        }
      
    }
    
    System.out.println("==================[S T A T S]==================");
     System.out.println("TOTAL HARGA SEMUA KUE\t: Rp " +  df.format(totalHargaSemuaKue));
     System.out.println();
     System.out.println("TOTAL HARGA KUE PESANAN\t: Rp " +  df.format(totalHargaKuePesanan));
     System.out.println("TOTAL BERAT KUE PESANAN\t: " +  df.format(totalBeratKuePesanan) + " gram");
     System.out.println();
     System.out.println("TOTAL HARGA KUE JADI\t: Rp " + df.format(totalHargaKueJadi));
     System.out.println("TOTAL JUMLAH KUE JADI\t: " +  df.format(totalJumlahKueJadi) + " buah");
     System.out.println();
     System.out.println("KUE DENGAN HARGA TERTINGGI");
     System.out.println("Berdasarkan Jenis\t: " + jenisKueTertinggi);
     System.out.println("Berdasarkan Nama Kue\t: " + namaKueTertinggi);
    
    }
}

