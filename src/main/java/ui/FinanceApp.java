package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinanceApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personal Finance Tracker - Login");

        Label lblUser = new Label("Username:");
        TextField txtUser = new TextField();

        Label lblPass = new Label("Password:");
        PasswordField txtPass = new PasswordField();

        Button btnLogin = new Button("Login");
        Button btnRegister = new Button("Register");

        btnLogin.setOnAction(e -> {
            // Later: call UserDAO.login(txtUser.getText(), txtPass.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "Login clicked! (connect DAO later)");
            alert.show();
        });

        btnRegister.setOnAction(e -> {
            // Later: call UserDAO.registerUser()
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "Register clicked! (connect DAO later)");
            alert.show();
        });

        VBox layout = new VBox(10, lblUser, txtUser, lblPass, txtPass, btnLogin, btnRegister);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
