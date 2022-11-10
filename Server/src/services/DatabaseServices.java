package services;

import main.AppServer;
import request.LoginRequest;
import request.SignupRequest;
import response.LoginResponse;
import response.SignupResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                String password =resultSet.getString(2);;
                return new LoginResponse(username,password);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
