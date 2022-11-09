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
        String query = "INSERT INTO STUDENT ( FIRST_NAME, LAST_NAME, EMAIL, PASS) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(2, signupRequest.getUsername());
            preparedStatement.setString(4, signupRequest.getEmail());
            preparedStatement.setString(5, signupRequest.getPassword());
            int res = preparedStatement.executeUpdate();
            if (res != 1) {
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
        String query = "SELECT  EMAIL, FIRST_NAME, LAST_NAME FROM STUDENT WHERE EMAIL = ? AND PASS = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, loginRequest.getUsername());
            preparedStatement.setString(1, loginRequest.getEmail());
            preparedStatement.setString(2, loginRequest.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String email = resultSet.getString(2);
                String username = resultSet.getString(4);
                String emailID =resultSet.getString(4);;
                return new LoginResponse(username,emailID);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
