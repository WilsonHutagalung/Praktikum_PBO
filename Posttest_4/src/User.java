import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class User extends Akun {
    private static InputStreamReader P = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(P);
    private static ArrayList<DestinasiWisata> DataDestinasi;
    private String priv = "User";
    
    public User(String username, String password, String priv, ArrayList<DestinasiWisata> DataDestinasi) {
        super(username, password);
        this.priv = priv;
        User.DataDestinasi = DataDestinasi;
    }
    
    public String getPriv() {
        return priv;
    }

    private static void clear() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    private static int Cek_int() throws IOException {
        int Cek = 0;
        while (true) {
            try {
                Cek = Integer.parseInt(input.readLine());
                break;
            } catch (NumberFormatException e) {
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
                displayDestinasi();
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
        public static void displayDestinasi() {
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
            if (DataDestinasi.isEmpty()) {
                System.out.println("Data Gunung Kosong.");
            } else {
                clear();
                Gunung gunung  = new Gunung("", 0, "", "", "", 0 ); // Objek sementara untuk memanggil displayTitle
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
            if (DataDestinasi.isEmpty()) {
                System.out.println("Data Pantai Kosong.");
            } else {
                clear();
                Pantai pantai = new Pantai("", 0, "", "", "", 0 ); // Objek sementara untuk memanggil displayTitle
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

    public static boolean MenuUser() throws IOException {
        boolean lanjut = true;
        while (lanjut) {
            clear();
            System.out.println("=".repeat(37));
            System.out.println("===== DATABASE DESTINASI WISATA =====");
            System.out.println("=".repeat(37));
            System.out.println("[1] Lihat Destinasi Wisata");
            System.out.println("[2] Keluar");
            System.out.println("=".repeat(37));
            System.out.print("Pilih menu >> ");
            int Pilih = Cek_int();

            switch (Pilih) {
                case 1:
                    Menu_lihat();
                    break;
                case 2:
                    return false; 
                default:
                    System.out.println("Pilihan tidak valid.");
                }
                lanjut = ulang("Apakah Anda ingin melanjutkan? (y/n)");
            }
            return lanjut;  
    }

}

