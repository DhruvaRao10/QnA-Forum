package services;

import main.AppServer;
import request.LoginRequest;
import request.SignupRequest;
import request.CreateqRequest;
import response.CreateqResponse;
import response.LoginResponse;
import response.SignupResponse;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime; // import the LocalTime class
public class DatabaseServices {

    public static SignupResponse createUser(SignupRequest signupRequest) {
        Connection connection = AppServer.getConnection();
        String query = "INSERT INTO USERS (USERNAME,EMAILID,PASS,ROLE) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, signupRequest.getUsername());
            preparedStatement.setString(2, signupRequest.getEmail());
            preparedStatement.setString(3, signupRequest.getPassword());
            preparedStatement.setInt (4, 0);
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
            if(resultSet.next()){
                String username = resultSet.getString(1);
                String emailID=resultSet.getString(2);;
                System.out.println(" username : "+username);
                System.out.println("emailid  :"+emailID);
                return new LoginResponse(username,emailID);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static CreateqResponse createQuestion(CreateqRequest createqRequest) {
        System.out.println(" inside 1 createquestions call ");
        Connection connection = AppServer.getConnection();
        String query = "INSERT INTO QUESTIONS (TAG,QUESTION,USAGE_COUNT,CREATED_TIME,TIME_LAST_REFERRED) VALUES (?,?,?,?,?)";
        try {
            System.out.println(" inside 2 createquestions call ");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,createqRequest.getTag());
            preparedStatement.setString(2, createqRequest.getQuestion());
            preparedStatement.setInt(3, 1);
            preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(LocalDateTime.now()));

            int result =  preparedStatement.executeUpdate();
            if (result == 1) {
                // wont come here
                return  new CreateqResponse(createqRequest.getTag(),createqRequest.getQuestion());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
