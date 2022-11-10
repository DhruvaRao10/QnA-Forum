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


public class Createquestionscontroller {
    public AnchorPane loginPane;
    @FXML
    public Button create_q;

    public Label qnalabel;




    public void create_questions(ActionEvent actionEvent) {
        System.out.println("Create Questions");
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("../views/createquestions_view.fxml"));
        Scene scene = null;
        Stage stage = (Stage) create_q.getScene().getWindow();
        try {
            scene = new Scene(registerLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Sign Up");

    }



}
