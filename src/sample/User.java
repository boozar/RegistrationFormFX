package sample;

public class User
{
    String login;
    Passwords password;

    public User(String login, Passwords password)
    {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Passwords getPassword() {
        return password;
    }

    public void setPassword(Passwords password) {
        this.password = password;
    }
}
