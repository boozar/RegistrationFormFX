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

public class RegistrationController {
    @FXML
    TextField txtRegLogin;
    @FXML
    TextField txtRegPassword;
    @FXML
    Button btnBackWelcome;

    @FXML
    public Label lbl_LoginReg, lbl_PasswordReg, lbl_FinishReg;

    public RegistrationController() {
    }

    public void btnRegistrationAction() {
        String loginNew = txtRegLogin.getText();
        String passwordNew = txtRegPassword.getText();
        lbl_LoginReg.setText("");
        lbl_PasswordReg.setText("");
        lbl_FinishReg.setText("");

        // check if login exists
        for (User user : users) {
            if (user.login.equals(loginNew)) {
                lbl_LoginReg.setText("Login is already used!");
                return;
            }
        }
        System.out.println("User is new");
        lbl_LoginReg.setText("✓");

        //check if login valid
        int errCodeLogin = Login.isValid(loginNew);
        System.out.println(ErrorsInfo.getMessageForLogin(errCodeLogin));
        if(errCodeLogin > 0){
            lbl_LoginReg.setText("Incorrect login");
            return;
        }

        // check if password valid
        int errCodePassword = Password.isValid(passwordNew);
        System.out.println(ErrorsInfo.getMessageForPassword(errCodePassword));

        if (errCodePassword > 0) {
            lbl_PasswordReg.setText("Incorrect password!");
            return;

        }

        lbl_PasswordReg.setText("✓");
        lbl_FinishReg.setText("You are registered!");
        Passwords passwords = new Passwords();
        passwords.addPassword(passwordNew);
        User user = new User(loginNew, passwords);
        users.add(user);
        System.out.println("Total users: " + users.size());

    }

    public void btnBackWelcomeAction(ActionEvent actionEvent) {

        Parent welcomeForm = null;
        try {
            welcomeForm = FXMLLoader.load(getClass().getResource("sampleFx/login.fxml"));
            Stage WelcomeStage = new Stage();
            WelcomeStage.setTitle("Welcome form");
            WelcomeStage.setScene(new Scene(welcomeForm, 750, 300));
            //        WelcomeStage.getScene().getStylesheets().add(0, "LoginStylesheet");
            WelcomeStage.show();
            btnBackWelcome.getScene().getWindow().hide();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}