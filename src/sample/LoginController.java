package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Main.users;

public class LoginController {
    @FXML
    Button btn_RegisterFirst;
    @FXML
    TextField txtPassword, txtLogin;
    @FXML
    Label lbl_Login, lbl_Password, lbl_Finish;

    public void btnRegisterAction() {
        Parent registrationForm = null;
        try {
            registrationForm = FXMLLoader.load(getClass().getResource("sampleFx/registration.fxml"));
            Stage RegistrationStage = new Stage();

            RegistrationStage.setTitle("Registration form");
            RegistrationStage.setScene(new Scene(registrationForm, 630, 300));
            RegistrationStage.show();
            btn_RegisterFirst.getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnLoginTrue(ActionEvent actionEvent) {
        String login = txtLogin.getText();
        String password = txtPassword.getText();
        int counter = 0;
        int counter2 = 0;
        for (User user : users) {
            if (user.login.toString().contains(login) & login.contains(user.login.toString())) {
                counter++;
                lbl_Login.setText("");
                for (Password password1 : user.password.getPasswords().values()) {
                    if (password1.getPassword().contains(password) & password.contains(password1.getPassword()) & password1.isActive()) {
                        System.out.println("Welcome to you page!");
                        lbl_Password.setText("");
                        lbl_Finish.setText("Welcome to you page!!!");
                        counter2++;
                    }

                }

            }


        }
        if (counter == 0) {
            System.out.println("Incorrect login");
            lbl_Login.setText("Incorrect login");
            lbl_Finish.setText("");

            return;
        }
        else if(counter2==0){
            System.out.println("Incorrect password");
            lbl_Password.setText("Incorrect password");
            lbl_Finish.setText("");

            return;
        }
    }
}