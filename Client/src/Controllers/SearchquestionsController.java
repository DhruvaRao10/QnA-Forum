package Controllers;
import com.mysql.cj.xdevapi.InsertStatement;
import com.mysql.cj.xdevapi.Table;
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
import request.SearchqRequest;
import response.CreateqResponse;
import response.LoginResponse;
import response.SearchqResponse;

import java.io.IOException;


public class SearchquestionsController {
    public AnchorPane landingpagepane;
    @FXML
    public TextField searchbar;

    @FXML
    public Button search_q;

    @FXML
    public Label qna_namelabel;

    @FXML
    public Hyperlink  searchqlink;

    @FXML
    public Button search;

    @FXML
    public TextArea results;

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
        stage.setTitle("Search  Question");

    }

    public void search(ActionEvent actionEvent) {
        SearchqRequest request = new SearchqRequest(searchbar.getText()) ;

        AppClient.sendRequest(request);
        SearchqResponse response = (SearchqResponse) AppClient.getResponse();
        System.out.println("BOOOO");
        results.setText(response.getSearchResponse());

        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION, " came back from search server");
        if (response == null) {
            alert = new Alert(Alert.AlertType.ERROR, "Failed to search");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION, "Search ran successfully");
            //switchtoLandingpage(actionEvent);
        }
    }

    public void switchtoLandingpage(ActionEvent actionEvent){
        FXMLLoader landingLoader = new FXMLLoader(getClass().getResource("../views/landing_view.fxml"));
        Scene scene = null;

        Stage stage = (Stage) results.getScene().getWindow();
        try {
            scene = new Scene(landingLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Illuminate Landing Page");
    }








}
