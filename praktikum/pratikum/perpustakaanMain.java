package pratikum;
import java.util.Scanner;
public class perpustakaanMain {
    public static void main(String[] args) {
        perpus buku = new perpus();
        Scanner input = new Scanner(System.in);
        perpus p = new perpus();
        
        System.out.println("=====================SELAMAT DATANG DI PERPUSTAKAAN=====================");
        System.out.println("Kategori buku yang tersedia yaitu :\n" + "- Teknologi\n" + "- Filsafat\n" + "- Sejarah\n" + "- Agama\n" + "- Psikologi\n" + "- Politik\n" + "- Fiksi\n" + "Silahkan tuliskan kategori buku yang ingin Anda cari(contoh : Teknologi)/ketik Tampilkan untuk mengetahui jumlah buku/ketik Keluar untuk keluar dari program: ");

        String kategori = input.nextLine();
        String hasilPencarian = buku.outputPerpus(kategori);
        System.out.println("---------------------------------------");
        System.out.println(hasilPencarian);
      
    }
       
    }

    

