public class Pantai extends DestinasiWisata{
    private String Jenis;
    private int Jumlah_Kunjungan;

    public Pantai(String Nama, int Tahun, String Lokasi, String Deskripsii, String Jenis, int Kunjungan) {
        super(Nama, Tahun, Lokasi, Deskripsii);
        this.Jenis = Jenis;
        this.Jumlah_Kunjungan = Kunjungan;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String Jenis) {
        this.Jenis = Jenis;
    }

    public int getJumlahKunjungan() {
        return Jumlah_Kunjungan;
    }

    public void setJumlahKunjungan(int Kunjungan) {
        this.Jumlah_Kunjungan = Kunjungan;
    }

    
    @Override
    public void display(int nomor) {
        System.out.printf("| %-3d | %-20s | %-15d | %-15s | %-70s | %-15s | %-16d |\n", nomor, getNama(), getTahunDitemukan(), getLokasi(), getDeskripsi(), getJenis(), getJumlahKunjungan());
    }
    
    @Override
    public void displayTitle() {
        System.out.println("=".repeat(176));
        System.out.println("=".repeat(75) + " LIST DATA DESTINASI PANTAI " + "=".repeat(73));
        System.out.println("=".repeat(176));
        System.out.printf("| %-3s | %-20s | %-15s | %-15s | %-70s | %-15s | %-15s |\n", "No","Nama Destinasi", "Tahun Ditemukan", "Lokasi", "Deskripsi","Jenis", "Jumlah Kunjungan");
        System.out.println("=".repeat(176));
    }
}
