import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Admin extends Akun {
    private static InputStreamReader P = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(P);
    private static List<Gunung> Data_Gunung;
    private static List<Pantai> Data_Pantai;
    private static ArrayList<DestinasiWisata> DataDestinasi = new ArrayList<>();
    private String Priv = "Admin";

    public Admin(String Username, String Password, String Priv, ArrayList<DestinasiWisata> DataDestinasi) {
        super(Username, Password);
        this.Priv = Priv;
        Admin.DataDestinasi = DataDestinasi;
        Data_Gunung = new ArrayList<>();
        Data_Pantai = new ArrayList<>();
    }

    public List<Gunung> getGunung(){
        return Data_Gunung;
    }

    public List<Pantai> getPantai(){
        return Data_Pantai;
    }

    public ArrayList<DestinasiWisata> getDataDestinasi() {
        return DataDestinasi;
    }
    

    public String getPriv() {
        return Priv;
    }
    
    private static void clear(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }  
    
    private static int Cek_int() throws IOException{
        int Cek = 0;
        while (true){
            try{
                Cek = Integer.parseInt(input.readLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Harap Masukkan Nilai Integer . . . ");
                
            }
        }
        return Cek;

    }

    private static boolean ulang(String message) throws IOException {
        System.out.print("\n" + message + " ");
        String pilihan = input.readLine();
        return pilihan.equalsIgnoreCase("y");
    }

    public static boolean MenuUtama() throws IOException {
        boolean lanjut = true;
        while (lanjut) {
            clear();
            System.out.println("=".repeat(37));
            System.out.println("===== DATABASE DESTINASI WISATA =====");
            System.out.println("=".repeat(37));
            System.out.println("[1] Tambah Data Destinasi Wisata");
            System.out.println("[2] Lihat Data Destinasi Wisata");
            System.out.println("[3] Update Data Destinasi Wisata");
            System.out.println("[4] Hapus Data Destinasi Wisata");
            System.out.println("[5] Keluar");
            System.out.println("=".repeat(37));
            System.out.print("Pilih menu >> ");
            int Pilih = Cek_int();

            switch (Pilih) {
                case 1:
                    Menu_Tambah();
                    break;
                case 2:
                    Menu_lihat();
                    break;
                case 3:
                    Menu_Update();
                    break;
                case 4:
                    HapusData();
                    break;
                case 5:
                    return false; 
                default:
                    System.out.println("Pilihan tidak valid.");
                }
                lanjut = ulang("Apakah Anda ingin melanjutkan? (y/n)");
            }
            return lanjut;  
    }

    public static void Menu_Tambah() throws IOException{
        clear();
        System.out.println("=".repeat(41));
            System.out.println("=".repeat(7) + "   TAMBAH DESTINASI WISATA " + "=".repeat(7));
            System.out.println("=".repeat(41));
            System.out.println(" [1] Destinasi Gunung  ");
            System.out.println(" [2] Destinasi Pantai  ");
            System.out.println(" [3] Back              ");
            System.out.println("=".repeat(41));
            System.out.print("Masukkan pilihan Anda >> ");
        int pilih =  Cek_int();
        switch(pilih){
            case 1 :
                Tambah_Gunung();  
                break;          
            case 2 :
                Tambah_Pantai();   
                break;
            case 3:
                System.out.println("Kembali. . .");
                System.out.print("Tekan ENTER untuk melanjutkan");input.readLine();              
            default :
                System.out.println("Pilihan tidak valid.");
                System.out.print("Tekan ENTER untuk melanjutkan");input.readLine();            
        }
    }

    public static void Tambah_Gunung() throws IOException {
        System.out.print("\nMasukkan Banyak Data >> ");
        int banyak = Cek_int();
        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println("===========================");
            System.out.println("Data Ke- " + (DataDestinasi.size() + 1));
            System.out.print("Nama Destinasi\t>> ");
            String Nama = input.readLine();
            System.out.print("Tahun Ditemukan\t>> ");
            int tahun = Cek_int();
            System.out.print("Lokasi\t\t>> ");
            String lokasi = input.readLine();
            System.out.print("Deskripsi\t>> ");
            String deskripsi = input.readLine();
            System.out.print("Jumlah Kunjungan>> ");
            int jumlahKunjungan = Cek_int();
            DataDestinasi.add(new Gunung(Nama, tahun, lokasi, deskripsi, "Gunung", jumlahKunjungan));
        }
        System.out.println("===============================");
        System.out.println("Data Berhasil Ditambahkan . . .");
        System.out.println("===============================");  
    }
    
    public static void Tambah_Pantai() throws IOException {
        System.out.print("\nMasukkan Banyak Data >> ");
        int banyak = Cek_int();
        for (int i = 0; i < banyak; i++) {
            System.out.println();
            System.out.println("===========================");
            System.out.println("Data Ke- " + (DataDestinasi.size() + 1));
            System.out.print("Nama Destinasi\t>> ");
            String Nama = input.readLine();
            System.out.print("Tahun Ditemukan\t>> ");
            int tahun = Cek_int();
            System.out.print("Lokasi\t\t>> ");
            String lokasi = input.readLine();
            System.out.print("Deskripsi\t>> ");
            String deskripsi = input.readLine();
            System.out.print("Jumlah Kunjungan>> ");
            int jumlahKunjungan = Cek_int();
            DataDestinasi.add(new Pantai(Nama, tahun, lokasi, deskripsi, "Pantai", jumlahKunjungan));
        }
        System.out.println("===============================");
        System.out.println("Data Berhasil Ditambahkan . . .");
        System.out.println("===============================");
    }
    
    
    public static void Menu_lihat() throws IOException {
        clear();
        System.out.println("=".repeat(34));
        System.out.println("=".repeat(7) + "   LIHAT DESTINASI " + "=".repeat(7));
        System.out.println("=".repeat(34));
        System.out.println(" [1] Semua Destinasi   ");
        System.out.println(" [2] Destinasi Gunung  ");
        System.out.println(" [3] Destinasi Pantai  ");
        System.out.println(" [4] Back              ");
        System.out.println("=".repeat(34));
        System.out.print("Masukkan pilihan Anda >> ");
        int pilih =  Cek_int();
        switch (pilih) {
                case 1 :
                    DisplayDestinasi();
                    break;
                case 2 :
                    displayGunung();   
                    break;             
                case 3 :
                    displayPantai();  
                    break;             
                case 4 :
                    System.out.println("Kembali. . .");
                    System.out.print("Tekan ENTER untuk melanjutkan");input.readLine();               
                default :
                System.out.println("Pilihan tidak valid.");
                    System.out.print("Tekan ENTER untuk melanjutkan");input.readLine();               
            }
        }

    public static void DisplayDestinasi() {
        clear();
        if (DataDestinasi.isEmpty()) {
            System.out.println("Data Destinasi Kosong.");
        } else {
            clear();
            DestinasiWisata wisata  = new DestinasiWisata("", 0, "", "" ); // Objek sementara untuk memanggil displayTitle
            wisata.displayTitle();
            int No = 1;
            for (DestinasiWisata destinasi : DataDestinasi) {
                if (destinasi instanceof Gunung) {
                    ((Gunung) destinasi).display(No++);
                } else if (destinasi instanceof Pantai) {
                    ((Pantai) destinasi).display(No++);
                } else {
                    destinasi.display(No++);
                }
            }
            System.out.println("=".repeat(176));
        }
    }

    public static void displayGunung() {
        clear();
        if (DataDestinasi.isEmpty()) {
            System.out.println("Data Gunung Kosong.");
        } else {
            clear();
            Gunung gunung = new Gunung("", 0, "", "", "", 0); // Objek sementara untuk memanggil displayTitle
            gunung.displayTitle();
            int No = 1;
            for (DestinasiWisata destinasi : DataDestinasi) {
                if (destinasi instanceof Gunung) {
                    ((Gunung) destinasi).display(No++);
                }
            }
            System.out.println("=".repeat(176));
        }
    }

    public static void displayPantai() {
        clear();
        if (DataDestinasi.isEmpty()) {
            System.out.println("Data Pantai Kosong.");
        } else {
            clear();
            Pantai pantai = new Pantai("", 0, "", "", "", 0); // Objek sementara untuk memanggil displayTitle
            pantai.displayTitle();
            int No = 1;
            for (DestinasiWisata destinasi : DataDestinasi) {
                if (destinasi instanceof Pantai) {
                    ((Pantai) destinasi).display(No++);
                }
            }
            System.out.println("=".repeat(176));
        }
    }

    public static void Menu_Update() throws IOException {
        clear();
        System.out.println("=".repeat(41));
        System.out.println("=".repeat(7) + "   UPDATE DESTINASI WISATA " + "=".repeat(7));
        System.out.println("=".repeat(41));
        System.out.println(" [1] Destinasi Gunung  ");
        System.out.println(" [2] Destinasi Pantai  ");
        System.out.println(" [3] Back              ");
        System.out.println("=".repeat(41));
        System.out.print("Masukkan pilihan Anda >> ");
        int pilih =  Cek_int();
        switch(pilih){
            case 1 :
                UpdateDataGunung();     
                break;          
            case 2 :
                UpdateDataPantai();     
                break;           
            default :
                System.out.println("Kembali. . .");
                System.out.print("Tekan ENTER untuk melanjutkan");input.readLine();               
        }
    }
  
    public static void UpdateDataPantai() throws IOException {
        System.out.println();
        if (Admin.DataDestinasi.isEmpty()) {
            System.out.println("Data destinasi masih kosong.");
            System.out.println("Tekan Enter untuk melanjutkan...");
            input.readLine();
        } else {
            System.out.println("UPDATE DATA DESTINASI");
            System.out.println();
            System.out.println("Daftar Destinasi:");
            DisplayDestinasi();
            System.out.println();
            System.out.print("Masukkan Nomor Destinasi yang ingin diUbah >>> ");
            int nomorDestinasi = Integer.parseInt(input.readLine());
            int index = nomorDestinasi - 1;
            if (index >= 0 && index < Admin.DataDestinasi.size()) {
                DestinasiWisata destinasi = Admin.DataDestinasi.get(index);
                if (destinasi instanceof Pantai) {
                    Pantai Pantai = (Pantai) destinasi;
                    DisplayDestinasi();
                    System.out.println();
                    System.out.println("=".repeat(30));
                    System.out.println("[1] Ubah Nama Destinasi Wisata");
                    System.out.println("[2] Ubah Tahun DiTemukan");
                    System.out.println("[3] Ubah Lokasi");
                    System.out.println("[4] Ubah Deskripsi");
                    System.out.println("[5] Ubah Jumlah Pengunjung");
                    System.out.println("=".repeat(30));
                    System.out.print("Masukkan Nomor Data yang ingin diUbah >>> ");
                    int nomorData = Integer.parseInt(input.readLine());
                    switch (nomorData) {
                        case 1:
                            System.out.print("Masukkan Nama Destinasi Baru >> ");
                            Pantai.setNama(input.readLine());
                            break;
                        case 2:
                            System.out.print("Masukkan Tahun DiTemukan Baru >> ");
                            Pantai.setTahun(Integer.parseInt(input.readLine()));
                            break;
                        case 3:
                            System.out.print("Masukkan Lokasi Baru >> ");
                            Pantai.setLokasi(input.readLine());
                            break;
                        case 4:
                            System.out.print("Masukkan Deskripsi Baru >> ");
                            Pantai.setDeskripsi(input.readLine());
                            break;
                        case 5:
                            System.out.print("Masukkan Jumlah Pengunjung Baru >> ");
                            Pantai.setJumlahKunjungan(Integer.parseInt(input.readLine()));
                            break;
                        default:
                            System.out.println("Nomor Data tidak Valid !!!");
                            break;
                    }
                    System.out.println("Data Berhasil diUpdate!");
                } else {
                    System.out.println("Destinasi yang dipilih Bukan Pantai.");
                }
            } else {
                System.out.println("Nomor Destinasi tidak Valid.");
            }
        }
    }
    
    public static void UpdateDataGunung() throws IOException {
        System.out.println();
        if (Admin.DataDestinasi.isEmpty()) {
            System.out.println("Data destinasi masih kosong.");
            System.out.println("Tekan Enter untuk melanjutkan...");
            input.readLine();
        } else {
            System.out.println("UPDATE DATA DESTINASI");
            System.out.println();
            System.out.println("Daftar Destinasi:");
            DisplayDestinasi();
            System.out.println();
            System.out.print("Masukkan Nomor Destinasi yang ingin diUbah >>> ");
            int nomorDestinasi = Integer.parseInt(input.readLine());
            int index = nomorDestinasi - 1;
            if (index >= 0 && index < Admin.DataDestinasi.size()) {
                DestinasiWisata destinasi = Admin.DataDestinasi.get(index);
                if (destinasi instanceof Gunung) {
                    Gunung Gunung= (Gunung) destinasi;
                    DisplayDestinasi();
                    System.out.println();
                    System.out.println("=".repeat(30));
                    System.out.println("[1] Ubah Nama Destinasi Wisata");
                    System.out.println("[2] Ubah Tahun DiTemukan");
                    System.out.println("[3] Ubah Lokasi");
                    System.out.println("[4] Ubah Deskripsi");
                    System.out.println("[5] Ubah Jumlah Pengunjung");
                    System.out.println("=".repeat(30));
                    System.out.print("Masukkan Nomor Data yang ingin diUbah >>> ");
                    int nomorData = Integer.parseInt(input.readLine());
                    switch (nomorData) {
                        case 1:
                            System.out.print("Masukkan Nama Destinasi Baru >> ");
                            Gunung.setNama(input.readLine());
                            break;
                        case 2:
                            System.out.print("Masukkan Tahun DiTemukan Baru >> ");
                            Gunung.setTahun(Integer.parseInt(input.readLine()));
                            break;
                        case 3:
                            System.out.print("Masukkan Lokasi Baru >> ");
                            Gunung.setLokasi(input.readLine());
                            break;
                        case 4:
                            System.out.print("Masukkan Deskripsi Baru >> ");
                            Gunung.setDeskripsi(input.readLine());
                            break;
                        case 5:
                            System.out.print("Masukkan Jumlah Pengunjung Baru >> ");
                            Gunung.setJumlahKunjungan(Integer.parseInt(input.readLine()));
                            break;
                        default:
                            System.out.println("Nomor Data tidak Valid !!!");
                            break;
                    }
                    System.out.println("Data Berhasil diUpdate!");
                } else {
                    System.out.println("Destinasi yang dipilih bukan Gunung.");
                }
            } else {
                System.out.println("Nomor Destinasi tidak Valid.");
            }
        }
    }
    
    
    
    private static void HapusData() throws IOException {
        clear();
        System.out.println("=".repeat(61));
        System.out.println("=".repeat(13) + " HAPUS DATA DESTINASI WISATA ALAM " + "=".repeat(13));
        System.out.println("=".repeat(61));
        DisplayDestinasi();
        System.out.print("Masukkan Nomor Data Destinasi yang ingin dihapus >> ");
        int NomorHapus = Cek_int(); 
        if (NomorHapus >= 1 && NomorHapus <= DataDestinasi.size()) {
            DataDestinasi.remove(NomorHapus - 1); 
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }
}

