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
    public AnchorPane landingpagepane;
    @FXML
    public TextField tagField;

    @FXML
    public TextField questionField;

    @FXML
    public Button create_q;

    @FXML
    public Button search_q;

    @FXML
    public Label qna_namelabel;

    @FXML
    public Hyperlink  createqlink;

    @FXML
    public Button saveQuestion ;




    public void switchToCreate(ActionEvent actionEvent) {
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("../views/Createquestions_view.fxml"));
        Scene scene = null;
        Stage stage = (Stage) createqlink.getScene().getWindow();
        try {
            scene = new Scene(registerLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Create Question");

    }











}
