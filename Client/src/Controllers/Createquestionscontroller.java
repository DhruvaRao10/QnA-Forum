package Controllers;

import main.AppClient;
import request.CreateqRequest;
import request.LoginRequest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import response.CreateqResponse;
import response.LoginResponse;

import java.io.IOException;


public class Createquestionscontroller {


    public AnchorPane landingpagepane;
    @FXML
    public TextField tagField;

    @FXML
    public TextArea questionField;

    @FXML
    public Button create_q;

    @FXML
    public Button search_q;

    @FXML
    public Label qna_namelabel;

    @FXML
    public Hyperlink createqlink;


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


    public void savequestion(ActionEvent actionEvent) {
        CreateqRequest request = new CreateqRequest(tagField.getText(), questionField.getText());

        AppClient.sendRequest(request);
        CreateqResponse response = (CreateqResponse) AppClient.getResponse();
        Alert alert;
        if (response == null) {
            alert = new Alert(Alert.AlertType.ERROR, "Failed to save question");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION, "Question saved successfully");
            switchtoLandingpage(actionEvent);
        }
    }

    public void switchtoLandingpage(ActionEvent actionEvent) {
        FXMLLoader landingLoader = new FXMLLoader(getClass().getResource("../views/landing_view.fxml"));
        Scene scene = null;

        Stage stage = (Stage) tagField.getScene().getWindow();
        try {
            scene = new Scene(landingLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Landing Page here");
    }

}