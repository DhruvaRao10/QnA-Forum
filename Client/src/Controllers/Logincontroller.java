package Controllers;


import main.AppClient;
import request.LoginRequest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import response.LoginResponse;

import java.io.IOException;

public class  Logincontroller {

    @FXML
    public AnchorPane loginPane;
    @FXML
    public Button loginButton;
    @FXML
    public PasswordField passwordField;

    @FXML
    public TextField usernameField;

    @FXML
    public Label signinLabel;
    @FXML
    public Hyperlink signupLink;

    public void login(ActionEvent actionEvent) {
        LoginRequest request = new LoginRequest(usernameField.getText(),passwordField.getText());
        AppClient.sendRequest(request);
        LoginResponse response = (LoginResponse) AppClient.getResponse();
        Alert alert;
        if (response == null) {
            alert = new Alert(Alert.AlertType.ERROR, "Incorrect information. Please try again.");
        } else {
            switchtoLandingpage(actionEvent);
        }

    }

    public void switchToSignup(ActionEvent actionEvent) {
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("../views/signup_view.fxml"));
        Scene scene = null;
        Stage stage = (Stage) signupLink.getScene().getWindow();
        try {
            scene = new Scene(registerLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Sign Up");

    }

    public void switchtoLandingpage(ActionEvent actionEvent){
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("../views/landing_view.fxml"));
        Scene scene = null;
        Stage stage = (Stage) loginButton.getScene().getWindow();
        try {
            scene = new Scene(registerLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Landing Page here");

    }



}
