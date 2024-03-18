public class Akun{
    private String Username;
    private String Password;

    private Akun(String User, String Pass){
        this.Username = User;
        this.Password = Pass;
    }

    public static Akun createAkun(String User, String Pass) {
        return new Akun(User, Pass);
    }

    public void setUsername(String User_Baru){
        this.Username = User_Baru;
    }
    public String getUsername(){
        return Username;
    }
    
    public void setPassword(String Pass_Baru){
        this.Password = Pass_Baru;
    }
    public String getPassword(){
        return Password;
    }
}