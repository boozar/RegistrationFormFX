package sample;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Passwords
{

    private HashMap<String, Password> passwords;



    public Passwords()
    {
        passwords = new HashMap<>();
    }


    public HashMap<String, Password> getPasswords()
    {
        return passwords;
    }

    /**
     *
     * @param password - New user password
     * @return true if password succesfully added
     */

    public void addPassword(String password)
    {
        Password password1 = new Password(password);

        if(Password.isValid(password)==0){
            passwords.put(Calendar.getInstance().getTime().toString(), password1);

            for (Password password2 : passwords.values()){
                System.out.println(password2.getPassword());
                if (password2.equals(password1) ) {
                    password2.setActive(true);
                } else {
                    password2.setActive(false);
                    System.out.println("Password no active");
                }
            }
        }

        // todo Check if password is valid (Password.isValid)

        // todo create new Password

        // todo make all previous passwords inactive

        // todo add to current list

    }


    public boolean checkPassword(String password)
    {
        for (Password password1: passwords.values()){
            if (password1.getPassword().contains(password) & password.contains(password1.getPassword()))
                return true;

        }

        return false;

        //todo check if this password equals to active


    }
}
