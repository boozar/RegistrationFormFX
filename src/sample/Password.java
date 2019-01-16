package sample;

import java.util.Date;

public class Password
{
    Date registrationDate;
    private String password;
    private boolean isActive;

    public Date getRegistrationDate()
    {
        return registrationDate;
    }


    public String getPassword()
    {
        return password;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Password(String password)
    {
        this.password = password;
        this.isActive = true;
        this.registrationDate = new Date();
    }



    public static int isValid(String password)
    {
//        RegistrationController utilToRegLable = new RegistrationController();

        int counter = 0;

        //todo check minimal length
        if (password.length() < Constants.PASSWORD_LENGTH) {
            //          utilToRegLable.lbl_PasswordReg.setText("Password length must be at least " + Constants.PASSWORD_LENGTH + " chars");
            return 1;

        }
        //todo Validation UpperCase
        for (char c: password.toCharArray())
        {
            if (Constants.UpperCaseSymbols.contains(c+""))
            {
                counter++;
                break;
            }
        }
        if (counter == 0) {
            //           utilToRegLable.lbl_PasswordReg.setText("Password must contain at least 1 UpperCase char");
            return 2;
        }

        //todo Validation LowerCase
        counter = 0;
        for (char c: password.toCharArray())
        {
            if (Character.isLowerCase(c))
            {
                counter++;
                break;
            }
        }
        if (counter == 0) {
            //          utilToRegLable.lbl_PasswordReg.setText("Password must contain at least 1 lowerCase char");
            return 3;
        }

        //todo Validation Number
        counter = 0;
        for (char c: password.toCharArray())
        {
            if (Character.isDigit(c))
            {
                counter++;
                break;
            }
        }
        if (counter == 0){
            //        utilToRegLable.lbl_PasswordReg.setText("Password must contain at least 1 digit char");
            return 4;
        }


        //todo Validation NonAlphaAndNonNumber
        counter = 0;
        for (char c: password.toCharArray())
        {
            if (!Character.isAlphabetic(c) && !Character.isDigit(c))
            {
                counter++;
                break;
            }
        }
        if (counter == 0) {
            //         utilToRegLable.lbl_PasswordReg.setText("Password must contain at least 1 non-symbol and non-digit char");
            return 5;
        }
        //     utilToRegLable.lbl_FinishReg.setText("Registration is complete!");

        return 0;
    }
}
