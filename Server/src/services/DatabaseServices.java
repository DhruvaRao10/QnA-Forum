package services;

import main.AppServer;
import request.*;
import response.*;

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

    public static SearchqResponse search(SearchqRequest searchqRequest) {
        System.out.println(" inside 1 search request call ");
        Connection connection = AppServer.getConnection();
        StringBuffer searchStr = new StringBuffer("%");
        searchStr.append(searchqRequest.getSearchkey());
        searchStr.append(new String("%"));

        String query = "SELECT QUESTION FROM QUESTIONS WHERE TAG LIKE ? OR QUESTION LIKE ? ";
        try {
            System.out.println(" inside 2 search call ");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,searchStr.toString());
            preparedStatement.setString(2, searchStr.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuffer results = new StringBuffer();
            int count = 1;
            while(resultSet.next()) {
                String question = resultSet.getString(1);
                results.append("Result "+String.valueOf(count++)+  ": "+ question +" \n\n");
                System.out.println(" search returned " + question);
            }
            return new SearchqResponse(results.toString(),results.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static QnaResponse createQna(QnaRequest createqnaRequest) {
        System.out.println(" inside 1 createqna call ");
        Connection connection = AppServer.getConnection();
        String query = "SELECT Q.QUESTION, A.ANSWER FROM QUESTIONS q,ANSWERS a WHERE a.QUESTION_ID IN (SELECT q.QUESTION_ID FROM QUESTIONS); ";

        try {
            System.out.println(" inside 2 createqns call ");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuffer results = new StringBuffer();
            int count = 1;
            while(resultSet.next()) {
                String question = resultSet.getString(1);
                String answer = resultSet.getString(2);
                results.append("QUESTION - "+String.valueOf(count)+  " : "+ question + " ANSWER - "+
                        String.valueOf(count)+  " : "+ answer +" \n\n");
                System.out.println(" search returned Question = " + question+" and Answer =  "+answer );
                count++;
            }
            return new QnaResponse(results.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}