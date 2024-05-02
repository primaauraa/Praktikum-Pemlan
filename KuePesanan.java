package tokoKue;

public class KuePesanan extends Kue {

    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }
    
    public double getBerat(){
        return berat;
    }

    public double hitungHarga(){
        return super.getHarga() * berat;

    }
}
