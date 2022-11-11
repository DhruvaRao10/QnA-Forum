package services;

import javafx.stage.Stage;
import jdk.internal.icu.text.UTF16;
import main.AppServer;
import request.CreateqRequest;
import request.LoginRequest;
import request.SignupRequest;
import request.CreateqRequest;
import response.CreateqResponse;
import response.LoginResponse;
import response.SignupResponse;
import response.CreateqResponse;


import java.sql.*;
import java.time.LocalTime;

public class DatabaseServices {

    public static SignupResponse createUser(SignupRequest signupRequest) {
        Connection connection = AppServer.getConnection();
        String query = "INSERT INTO USERS (USERNAME,EMAILID,PASS,ROLE) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, signupRequest.getUsername());
            preparedStatement.setString(2, signupRequest.getEmail());
            preparedStatement.setString(3, signupRequest.getPassword());
            preparedStatement.setInt(4, 0);
            int result = preparedStatement.executeUpdate();
            if (result != 1) {
                return new SignupResponse("FAILED!");
            } else {
                return new SignupResponse("SUCCESS!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new SignupResponse("FAILED!");
    }

    public static LoginResponse loginUser(LoginRequest loginRequest) {
        Connection connection = AppServer.getConnection();
        String query = "SELECT  USERNAME,EMAILID FROM USERS WHERE USERNAME=? AND PASS= ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, loginRequest.getUsername());
            preparedStatement.setString(2, loginRequest.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString(1);
                String emailID = resultSet.getString(2);
                ;
                System.out.println(" username : " + username);
                System.out.println("emailid  :" + emailID);
                return new LoginResponse(username, emailID);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }






       /public static CreateqResponse createQuestion(CreateqRequest createqRequest) {
            Connection connection = AppServer.getConnection();

            String query = "INSERT INTO QUESTION,TAGS FROM USERS WHERE QUESTION=? AND TAGS=?;";
            String query = "INSERT INTO QUESTION(TAG,QUESTION,USAGE_COUNT,CREATED_TIME,TIME_LAST_REFERRED) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,createqRequest.getQuestion());
            preparedStatement.setString(2,createqRequest.getTag());
            preparedStatement.setInt(3,0);
            Timestamp LocalTime;
            preparedStatement.setTimestamp(2, LocalTime());
            preparedStatement.setTime

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
            }
                String tag     = resultSet.getString(1);
                String question = resultSet.getString(2);

                System.out.println(" tag :"+tag);
                System.out.println("question :"+question);
                return new CreateqResponse(tag,question);
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }






