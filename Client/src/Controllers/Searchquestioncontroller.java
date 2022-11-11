package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.AppClient;
import request.SignupRequest;
import response.SignupResponse;

import java.io.IOException;
import java.util.ArrayList;


public class Searchquestioncontroller {

    int i=0;
    @FXML
    public AnchorPane searchpane ;

    @FXML
    public TableView questionkeytable;

    @FXML
    public TableColumn   questionkeycolumn ;

    @FXML
    public TextField searchbar;

    @FXML
    public Label searchlabel ;

    @FXML
     public TableView <String> tableview ;
    ArrayList<String>searchlist  = new ArrayList<String>();

    Scanner q_string = new Scanner(System.in);
        while(searchlist.size()!=null){
        searchlist.add(q_string.nextLine());
    }

    public void search(ActionEvent event)
    {
        tableview.getquestions().clear();
        tableview.getquestions().addAll(searchlist(searchbar.getText(),searchlist));
    }

        @Override
       public void initialize(URL url , ResourceBundle resourceBundle)
        {
            tableview.getquestions().addAll(searchlist);


    }


}
