package sample;


import javafx.scene.Node;

import java.util.Date;

import static sample.RegistrationController.*;

public class ErrorsInfo
{

    public static String getMessageForLogin(int code){
        switch (code){
            case 0:
                return "login is valid";
            case  1:
                return "Login length must be at least " + Constants.LOGIN_LENGTH + " chars";
            case 2:
                return "Login should not contain non-symbol and non-digit char";
            default:
                return "Unknown error";
        }
    }

    public static String getMessageForPassword(int code)
    {

        switch (code)
        {
            case 0 :
                return "No error";
            case 1 :
                return "Password length must be at least " + Constants.PASSWORD_LENGTH + " chars";
            case 2:
                return "Password must contain at least 1 UpperCase char";
            case 3:
                return "Password must contain at least 1 lowerCase char";
            case 4:
                return "Password must contain at least 1 digit char";
            case 5:
                return "Password must contain at least 1 non-symbol and non-digit char";
            case 6:
                return "Thise login is already used";
            default:
                return "Unknown error";
        }

    }
}
