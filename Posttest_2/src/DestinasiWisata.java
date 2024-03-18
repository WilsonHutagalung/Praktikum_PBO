public class DestinasiWisata {
    private String Nama_Destinasi;
    private int Tahun_DiTemukan;
    private String Lokasi;
    private String Deskripsi;
    private int Jumlah_Kunjungan;
    
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

    public void setNama(String Nama_Baru){
        this.Nama_Destinasi = Nama_Baru;
    }
    public String getNama(){
        return Nama_Destinasi;
    }
    
    public void setTahun(int Tahun_Baru){
        this.Tahun_DiTemukan = Tahun_Baru;
    }
    public int getTahunDitemukan(){
        return Tahun_DiTemukan;
    }
    
    public void setLokasi(String Lokasi_Baru){
        this.Lokasi = Lokasi_Baru;
    }
    public String getLokasi(){
        return Lokasi;
    }
    
    public void setDeskripsi (String Deskripsi_Baru){
        this.Deskripsi = Deskripsi_Baru;
    }
    public String getDeskripsi(){
        return Deskripsi;
    }
    
    public void setJumlahKunjungan (int Kunjungan_Baru){
        this.Jumlah_Kunjungan = Kunjungan_Baru;
    }
    public int getJumlahKunjungan(){
        return Jumlah_Kunjungan;
    }

}
