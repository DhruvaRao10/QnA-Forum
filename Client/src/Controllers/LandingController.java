package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.AppClient;
import request.CreateqRequest;
import request.LoginRequest;
import response.LoginResponse;

import java.io.IOException;

public class LandingController {


    @FXML
    public AnchorPane landingpagepane;
    @FXML
    public Button create_q;
    @FXML
    public Button search_q;

    @FXML
    public Hyperlink createqlink;

    @FXML
    public Hyperlink searchqlink;

    public void createquestions(ActionEvent actionEvent) {
        switchtoQuestionspage(actionEvent);
    }

    public void searchquestions(ActionEvent actionEvent) {
        switchtoSearchpage(actionEvent);
    }

    public void switchtoQuestionspage(ActionEvent actionEvent) {
        FXMLLoader qLoader = new FXMLLoader(getClass().getResource("../views/createquestions_view.fxml"));
        Scene scene = null;

        Stage stage = (Stage) create_q.getScene().getWindow();
        try {
            scene = new Scene(qLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Create Questions Page");
    }
    public void switchtoSearchpage(ActionEvent actionEvent) {
        FXMLLoader sLoader = new FXMLLoader(getClass().getResource("../views/Searchquestions_view.fxml"));
        Scene scene = null;

        Stage stage = (Stage) search_q.getScene().getWindow();
        try {
            scene = new Scene(sLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Search Page");
    }


}