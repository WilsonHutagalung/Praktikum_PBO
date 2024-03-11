public class DestinasiWisata {
    public String Nama_Destinasi;
    public int Tahun_DiTemukan;
    public String Lokasi;
    public String Deskripsi;
    public int Jumlah_Kunjungan;
    
    public DestinasiWisata(String Nama, int Tahun, String Lokasi, String Deskripsi, int Kunjungan){
        this.Nama_Destinasi = Nama;
        this.Lokasi = Lokasi;
        this.Tahun_DiTemukan = Tahun;
        this.Deskripsi = Deskripsi;
        this.Jumlah_Kunjungan = Kunjungan;
    }

    void display(){
        System.out.printf("| %-30s | %-15d | %-15s | %-70s | %-15d  |\n", this.Nama_Destinasi, this.Tahun_DiTemukan, this.Lokasi,this.Deskripsi, this.Jumlah_Kunjungan);
    }
}
