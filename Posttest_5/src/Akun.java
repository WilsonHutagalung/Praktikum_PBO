public class Akun {
    protected final String Username;
    protected final String Password;

    public Akun(final String User, final String Pass) {
        this.Username = User;
        this.Password = Pass;
    }

    public final String getUsername() {
        return Username;
    }

    public final String getPassword() {
        return Password;
    }
}
