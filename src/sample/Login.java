package sample;

public class Login {
    String login;

    public Login(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public static int isValid(String login){

        int counter = 0;
        if (login.length()< Constants.LOGIN_LENGTH)
            return 1;
        for (char c: login.toCharArray())
        {
            if (Character.isAlphabetic(c) && Character.isDigit(c))
            {
                counter++;
                break;
            }
        }
        return 0;
    }
}
