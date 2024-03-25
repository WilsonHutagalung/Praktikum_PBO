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

    public void display(int No) {
        System.out.printf("| %-3d | %-20s | %-15d | %-15s | %-70s | %-15s | %-15d  |\n",No, this.Nama_Destinasi, this.Tahun_DiTemukan, this.Lokasi, this.Deskripsi, this.Jenis, this.Jumlah_Kunjungan);
    }

}
