import java.io.*;
import java.util.*;

public class Main {
    private static InputStreamReader P = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(P);
    private static ArrayList<DestinasiWisata> DataDestinasi = new ArrayList<>();
    private static ArrayList<Akun> DataAkun = new ArrayList<>();

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

    public static void main(String[] args) throws IOException {
        DataDestinasi.add(new DestinasiWisata("Derawan", 2005, "Berau", "keindahan bawah lautnya", 350000));
        DataDestinasi.add(new DestinasiWisata("Taman Nasional Bunaken", 1991, "Manado", "keindahan bawah laut  dengan ragam terumbu karang", 54000));
        // DataAkun.add(new Akun("Wilson", "035"));
        DataAkun.add(Akun.createAkun("Wilson", "035"));
        Menu_Login();
    }

    private static void Menu_Login() throws NumberFormatException, IOException{    
        while(true){
            clear();
            System.out.println("=".repeat(34));
            System.out.println("=".repeat(11) + " MENU LOGIN " + "=".repeat(11));
            System.out.println("=".repeat(34));
            System.out.println(" [1] LOGIN    (Terdaftar)      ");
            System.out.println(" [2] REGISTER (Belum Terdaftar)");
            System.out.println(" [3] EXIT                      ");
            System.out.println("=".repeat(34));
            System.out.print("Masukkan pilihan Anda >> ");
            int pilih = Cek_int();
            switch(pilih){
                case 1:
                    Login();
                    break;
                case 2:
                    Register();
                    break;
                case 3:
                    keluarProgram();
                    break;
                default:
                    System.out.println("=".repeat(22));
                    System.err.println("pilihan Anda tidak ada");
                    System.out.println("=".repeat(22));
                    break;
            }
        }
        
    }
    
    private static void Register() throws IOException{
        clear();
        System.out.println("=".repeat(29));
        System.out.println("=    DAFTARKAN AKUN ANDA    =");
        System.out.println("=".repeat(29));
        System.out.print("Masukkan Username >> ");
        String User = input.readLine();
        System.out.print("Masukkan Password >> ");
        String Pass = input.readLine();
        // Akun newakun = new Akun(User, Pass);
        Akun newakun = Akun.createAkun(User, Pass);
        DataAkun.add(newakun);
        System.out.println("=".repeat(33));
        System.out.println("Data berhasil diTambahkan!!");
        System.out.println("=".repeat(33));
        System.out.println("");
        System.out.println("Silahkan Lakukan Login");
        System.out.println("");
        System.out.println("Tekan enter untuk melanjutkan. . .");input.readLine();
        Login();
    }

    private static void Login() throws IOException {
        clear();
        System.out.println("==============================");
        System.out.println("=      LOGIN AKUN ANDA       =");
        System.out.println("==============================");
        System.out.print("Masukkan Username >> ");
        String user = input.readLine();
        System.out.print("Masukkan Password >> ");
        String pass = input.readLine();
        
        boolean bool = false;
        for (Akun akun : DataAkun) {
            if (akun.getUsername().equals(user) && akun.getPassword().equals(pass)) {
                clear();
                System.out.println("===================");
                System.out.println("Anda Berhasil Masuk");
                System.out.println("===================");
                System.out.println("Tekan enter untuk melanjutkan...");
                input.readLine();
                MenuUtama();
                bool = true;
                break;
            }
        }
        
        if (!bool) {
            clear();
            System.out.println("=================================");
            System.out.println("Username atau Password Anda Salah");
            System.out.println("=================================");
            System.out.println("Tekan enter untuk melanjutkan...");
            input.readLine();
            Login(); // Kembali ke menu login setelah kesalahan
        }
    }
    

    private static void MenuUtama() throws IOException {
        boolean lanjut = true;
        while (lanjut) {
            clear();
            System.out.println("=".repeat(37));
            System.out.println("===== DATABASE DESTINASI WISATA =====");
            System.out.println("=".repeat(37));
            System.out.println("1. Tambah Data Destinasi Wisata");
            System.out.println("2. Lihat Data Destinasi Wisata");
            System.out.println("3. Update Data Destinasi Wisata");
            System.out.println("4. Hapus Data Destinasi Wisata");
            System.out.println("5. Keluar");
            System.out.println("=".repeat(37));
            System.out.print("Pilih menu: ");
            int Pilih = Cek_int();

            switch (Pilih) {
                case 1:
                    TambahData();
                    break;
                case 2:
                    TampilkanData();
                    break;
                case 3:
                    UpdateData();
                    break;
                case 4:
                    HapusData();
                    break;
                case 5:
                    keluarProgram();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

            lanjut = ulang("Apakah Anda ingin melanjutkan? (y/n)");
        }
    }

    private static void TambahData() throws IOException {
        clear();
        System.out.println("=".repeat(47));
        System.out.println("===== TAMBAH DATA DESTINASI WISATA ALAM =====");
        System.out.println("=".repeat(47));
        System.out.print("Masukkan Nama Destinasi: ");
        String Nama = input.readLine();
        System.out.print("Masukkan Tahun DiTemukan: ");
        int Tahun= Cek_int();
        System.out.print("Masukkan Lokasi: ");
        String Lokasi = input.readLine();
        System.out.print("Masukkan Deskripsi: ");
        String Deskripsi = input.readLine();
        System.out.print("Masukkan Jumlah Kunjungan: ");
        int Jumlah_Kunjungan = Cek_int();
        DestinasiWisata wisata = new DestinasiWisata(Nama,  Tahun,  Lokasi,  Deskripsi,  Jumlah_Kunjungan);
        DataDestinasi.add(wisata);
        System.out.println("Data Destinasi Wisata Alam Berhasil DiTambahkan!!.");
    }

    private static void TampilkanData() {
        clear();
        System.out.println("=".repeat(162));
        System.out.println("=".repeat(65) + " LIST DATA DESTINASI WISATA ALAM " + "=".repeat(64));
        System.out.println("=".repeat(162));
        System.out.printf("| %-30s | %-15s | %-15s | %-70s | %-15s |\n", "Nama Destinasi", "Tahun Ditemukan", "Lokasi", "Deskripsi", "Jumlah Kunjungan");
        System.out.println("=".repeat(162));
        if (DataDestinasi != null && !DataDestinasi.isEmpty()) {
            for (int i = 0; i < DataDestinasi.size(); i++) {
                DataDestinasi.get(i).display();
            }
        } else {
            System.out.println("Data Destinasi Wisata Alam Kosong!!.");
        }
        System.out.println("=".repeat(162));
    }

    private static void UpdateData() throws IOException {
        clear();
        System.out.println("=".repeat(71));
        System.out.println("=".repeat(18) + " UPDATE DATA DESTINASI WISATA ALAM " + "=".repeat(18));
        System.out.println("=".repeat(71));
        System.out.print("Masukkan Nama Destinasi Wisata Alam Yang Ingin DiUpdate: ");
        String UpdateData = input.readLine();
        boolean ditemukan = false;
        for (DestinasiWisata Destinasi : DataDestinasi) {
            if (Destinasi.getNama().equalsIgnoreCase(UpdateData)) {
                ditemukan = true;
                System.out.println("Data ditemukan. Silakan masukkan data baru:");
                System.out.print("Masukkan Nama Destinasi: ");
                String Nama = input.readLine();
                System.out.print("Masukkan Lokasi: ");
                String Lokasi = input.readLine();
                System.out.print("Masukkan Deskripsi: ");
                String Deskripsi = input.readLine();
                System.out.print("Masukkan Tahun DiTemukan: ");
                int Tahun = Cek_int();
                System.out.print("Masukkan Jumlah Kunjungan: ");
                int Kunjungan = Cek_int();
                
                Destinasi.setNama(Nama);
                Destinasi.setLokasi(Lokasi); ;
                Destinasi.setDeskripsi(Deskripsi); ;
                Destinasi.setTahun(Tahun); ;
                Destinasi.setJumlahKunjungan(Kunjungan); ;
                System.out.println("Data berhasil diupdate.");
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    private static void HapusData() throws IOException {
       clear();
        System.out.println("=".repeat(61));
        System.out.println("=".repeat(13) + " UPDATE DATA DESTINASI WISATA ALAM " + "=".repeat(13));
        System.out.println("=".repeat(61));
        System.out.print("Masukkan nama Destinasi yang akan dihapus: ");
        String HapusData = input.readLine();
        boolean ditemukan = false;
        for (DestinasiWisata Destinasi : DataDestinasi) {
            if (Destinasi.getNama().equalsIgnoreCase(HapusData)) {
                ditemukan = true;
                DataDestinasi.remove(Destinasi);
                System.out.println("Data berhasil dihapus!!.");
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    private static void keluarProgram() {
        System.out.println("Keluar dari program. Sampai jumpa!");
        System.exit(0);
    }
}
