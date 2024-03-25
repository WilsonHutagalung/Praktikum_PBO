public class Akun {
    protected String Username;
    protected String Password;

    public Akun(String User, String Pass) {
        this.Username = User;
        this.Password = Pass;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}
