package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sampleFx/login.fxml"));
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(new Scene(root, 750, 300));
//        primaryStage.getScene().getStylesheets().add((new File("src/resources/double_slider.css")).toURI().toString());
//        primaryStage.getScene().getStylesheets().add(getClass().getResource("LoginStylesheet.css").toExternalForm());
        primaryStage.show();

    }

    public static ArrayList<User> users;


    public static void main(String[] args) {
        users = new ArrayList<>();
        //users.add();

        launch(args);
    }
}

