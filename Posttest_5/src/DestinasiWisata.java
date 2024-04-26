public abstract class DestinasiWisata {
    protected String Nama_Destinasi;
    protected int Tahun_DiTemukan;
    protected String Lokasi;
    protected String Deskripsi;
   
    
    public DestinasiWisata(String Nama, int Tahun, String Lokasi, String Deskripsi){
        this.Nama_Destinasi = Nama;
        this.Lokasi = Lokasi;
        this.Tahun_DiTemukan = Tahun;
        this.Deskripsi = Deskripsi;
        
        
    }

    public abstract void displayTitle();

    
    public abstract void display(int nomor);
    

    public void setNama(String Nama){
        this.Nama_Destinasi = Nama;
    }
    public String getNama(){
        return Nama_Destinasi;
    }
    
    public void setTahun(int Tahun){
        this.Tahun_DiTemukan = Tahun;
    }
    public int getTahunDitemukan(){
        return Tahun_DiTemukan;
    }
    
    public void setLokasi(String Lokasi){
        this.Lokasi = Lokasi;
    }
    public String getLokasi(){
        return Lokasi;
    }
    
    public void setDeskripsi (String Deskripsi){
        this.Deskripsi = Deskripsi;
    }
    public String getDeskripsi(){
        return Deskripsi;
    }

}
