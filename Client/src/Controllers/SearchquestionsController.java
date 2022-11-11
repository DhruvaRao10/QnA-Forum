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


public class SearchquestionsController {
    public AnchorPane landingpagepane;
    @FXML
    public Button create_q;

    @FXML
    public Button search_q;

    @FXML
    public Label qna_namelabel;

    @FXML
    public Hyperlink  searchqlink;


    public void switchToSearch(ActionEvent actionEvent) {
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("../views/Searchquestions_view.fxml"));
        Scene scene = null;
        Stage stage = (Stage) searchqlink.getScene().getWindow();
        try {
            scene = new Scene(registerLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Create Question");

    }











}
