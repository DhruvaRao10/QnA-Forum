package Controllers;
import com.mysql.cj.xdevapi.Column;
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
import request.QnaRequest;
import request.SearchqRequest;
import response.CreateqResponse;
import response.LoginResponse;
import response.QnaResponse;
import response.SearchqResponse;

import java.io.IOException;

public class QnaController{

     @FXML
     public TextArea results;

     @FXML
     protected void initialize() {

          listqna();

        /*button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You clicked me!");
            }
        }); */
     }
     public void listqna() {
          QnaRequest request = new QnaRequest();

          AppClient.sendRequest(request);
          QnaResponse response = (QnaResponse) AppClient.getResponse();
          System.out.println("BOOOO");
          results.setText(response.getResponse());
          Alert alert;
          alert = new Alert(Alert.AlertType.INFORMATION, " came back from list qna request");
          if (response == null) {
               alert = new Alert(Alert.AlertType.ERROR, "Failed to list qna");
               alert.showAndWait();
          } else {
               alert = new Alert(Alert.AlertType.INFORMATION, "list qna ran successfully");
          }
     }

     public void switchtolandingpage(ActionEvent actionEvent){
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

