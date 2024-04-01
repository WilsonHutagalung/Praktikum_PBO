import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static InputStreamReader P = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(P);
    private static ArrayList<DestinasiWisata> DataDestinasi = new ArrayList<>();
    private static ArrayList<Akun> DataAkun = new ArrayList<>();
    
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

    private static void keluarProgram() {
        System.out.println("Keluar dari program. Terima Kasih dan Sampai jumpa!");
        System.exit(0);
    }
    
    public static ArrayList<DestinasiWisata> getDataDestinasi() {
        return DataDestinasi;
    }
    
    public static void main(String[] args) throws IOException {
        DataDestinasi.add(new Gunung("Bromo", 1991, "Jawa Timur", "Gunung Berapi aktif dengan pemandangan matahari terbit yang indah", "Gunung", 1500));
        DataDestinasi.add(new Pantai("Kuta", 1970, "Bali", "Pantai yang terkenal dengan ombaknya yang cocok untuk berselancar", "Pantai", 750));

        DataAkun.add(new Admin("Admin", "Admin", "Admin", DataDestinasi));
        DataAkun.add(new User("Wilson", "035", "User", DataDestinasi));

        while (true) {
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
            switch (pilih) {
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

    // private static void Register() throws IOException {
    //     clear();
    //     System.out.println("=".repeat(36));
    //     System.out.println("=".repeat(5) + " DAFTARKAN AKUN ANDA " + "=".repeat(5));
    //     System.out.println("=".repeat(36));
    //     System.out.println("Pilih Jenis Akun:");
    //     System.out.println("[1] Admin");
    //     System.out.println("[2] User");
    //     System.out.println("=".repeat(36));
    //     System.out.print("Masukkan pilihan >> ");
    //     int Jenis_Akun = Cek_int();
    
    //     switch (Jenis_Akun) {
    //         case 1:
    //             System.out.print("Masukkan Username Admin >> ");
    //             String usernameAdmin = input.readLine();
    //             System.out.print("Masukkan Password Admin >> ");
    //             String passwordAdmin = input.readLine();
    //             Admin newAdmin = new Admin(usernameAdmin, passwordAdmin, "Admin", DataDestinasi);
    //             DataAkun.add(newAdmin);
    //             System.out.println("=".repeat(33));
    //             System.out.println("Data Admin berhasil ditambahkan!");
    //             System.out.println("=".repeat(33));
    //             break;
    //         case 2:
    //             System.out.print("Masukkan Username User >> ");
    //             String usernameUser = input.readLine();
    //             System.out.print("Masukkan Password User >> ");
    //             String passwordUser = input.readLine();
    //             User newUser = new User(usernameUser, passwordUser, "User", DataDestinasi);
    //             DataAkun.add(newUser);
    //             System.out.println("=".repeat(33));
    //             System.out.println("Data User berhasil ditambahkan!");
    //             System.out.println("=".repeat(33));
    //             break;
    //         default:
    //             System.out.println("=".repeat(22));
    //             System.err.println("Pilihan jenis akun tidak valid");
    //             System.out.println("=".repeat(22));
    //             break;
    //     }
    //     System.out.println("");
    //     System.out.println("Silahkan Lakukan Login");
    //     System.out.println("");
    //     System.out.println("Tekan enter untuk melanjutkan. . .");
    //     input.readLine();
    //     Login();
    // }

    private static void Register() throws IOException {
        clear();
        System.out.println("=".repeat(36));
        System.out.println("=".repeat(5) + " DAFTARKAN AKUN ANDA " + "=".repeat(5));
        System.out.println("=".repeat(36));
        System.out.println("Pilih Jenis Akun:");
        System.out.println("[1] Admin");
        System.out.println("[2] User");
        System.out.println("=".repeat(36));
        System.out.print("Masukkan pilihan >> ");
        int Jenis_Akun = Cek_int();
    
        switch (Jenis_Akun) {
            case 1:
                Register("Admin");
                break;
            case 2:
                Register("User");
                break;
            default:
                System.out.println("=".repeat(22));
                System.err.println("Pilihan jenis akun tidak valid");
                System.out.println("=".repeat(22));
                break;
        }
        
        System.out.println("");
        System.out.println("Silahkan Lakukan Login");
        System.out.println("");
        System.out.println("Tekan enter untuk melanjutkan. . .");
        input.readLine();
        Login();
    }
    // Penggunaan Overloading
    private static void Register(String jenisAkun) throws IOException {
        clear();
        System.out.println("=".repeat(36));
        System.out.println("=".repeat(5) + " DAFTARKAN AKUN ANDA " + "=".repeat(5));
        System.out.println("=".repeat(36));
        
        System.out.print("Masukkan Username " + jenisAkun + " >> ");
        String username = input.readLine();
        System.out.print("Masukkan Password " + jenisAkun + " >> ");
        String password = input.readLine();
    
        switch (jenisAkun) {
            case "Admin":
                Admin newAdmin = new Admin(username, password, "Admin", DataDestinasi);
                DataAkun.add(newAdmin);
                System.out.println("=".repeat(33));
                System.out.println("Data Admin berhasil ditambahkan!");
                System.out.println("=".repeat(33));
                break;
            case "User":
                User newUser = new User(username, password, "User", DataDestinasi);
                DataAkun.add(newUser);
                System.out.println("=".repeat(33));
                System.out.println("Data User berhasil ditambahkan!");
                System.out.println("=".repeat(33));
                break;
            default:
                System.out.println("=".repeat(22));
                System.err.println("Pilihan jenis akun tidak valid");
                System.out.println("=".repeat(22));
                break;
        }
    }

    private static void Login() throws IOException {
        clear();
        System.out.println("=".repeat(30));
        System.out.println("=      LOGIN AKUN ANDA       =");
        System.out.println("=".repeat(30));
        System.out.print("Masukkan Username >> ");
        String user = input.readLine();
        System.out.print("Masukkan Password >> ");
        String pass = input.readLine();

        boolean Login = false;
        for (Akun akun : DataAkun) {
            if (akun.getUsername().equals(user) && akun.getPassword().equals(pass)) {
                clear();
                System.out.println("=".repeat(19));
                System.out.println("Anda Berhasil Masuk");
                System.out.println("=".repeat(19));
                System.out.println("Tekan enter untuk melanjutkan...");
                input.readLine();
                if (akun instanceof Admin) {
                    Admin.MenuUtama();
                } else if (akun instanceof User) {
                    User.MenuUser();
                }
                Login = true;
                break;
            }
        }
        if (!Login) {
            clear();
            System.out.println("=".repeat(33));
            System.out.println("Username atau Password Anda Salah");
            System.out.println("=".repeat(33));
            System.out.println("Tekan Enter Untuk Melanjutkan...");
            input.readLine();
            Login();
        }
    }
}
