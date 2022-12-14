package main;

import request.*;
import request.CreateqRequest;
import response.QnaResponse;
import response.SearchqResponse;
import services.DatabaseServices;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLOutput;

public class ClientHandler implements Runnable {
    Socket socket;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    public ClientHandler(Socket socket) throws Exception {
        this.socket = socket;
        this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        this.objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        System.out.println("Client connected... waiting for requests.");
        while (true) {
            try {
                AppRequest request = (AppRequest) objectInputStream.readObject();
                System.out.println("Received request");
                switch (request.getRequestType()) {
                    case LOGIN_REQUEST -> {
                        System.out.println("Client wants to login!");
                        LoginRequest loginRequest = (LoginRequest) request;
                        System.out.println("Username: " + loginRequest.getUsername());
                        System.out.println("Password:"+loginRequest.getPassword());
                        objectOutputStream.writeObject(DatabaseServices.loginUser(loginRequest));
                        objectOutputStream.flush();
                    }
                    case SIGNUP_REQUEST -> {
                        System.out.println("Client wants to signup!");
                        SignupRequest signupRequest = (SignupRequest) request;
                        System.out.println("Email: " + signupRequest.getEmail());
                        objectOutputStream.writeObject(DatabaseServices.createUser(signupRequest));
                        objectOutputStream.flush();
                    }
                    case CREATEQ_REQUEST -> {
                        System.out.println("Client wants to create a question!");
                        CreateqRequest qRequest = (CreateqRequest) request;
                        System.out.println("Tag : " + qRequest.getTag());
                        objectOutputStream.writeObject(DatabaseServices.createQuestion(qRequest));
                        objectOutputStream.flush();
                    }
                    case SEARCHQ_REQUEST -> {
                        System.out.println("Client wants to search for questions!");
                        SearchqRequest sRequest = (SearchqRequest) request;
                        System.out.println("Tag : " + sRequest.getSearchkey());
                        SearchqResponse resp = DatabaseServices.search(sRequest);
                        System.out.println(" search response to client is "+resp.getSearchResponse());
                        objectOutputStream.writeObject(resp);
                        objectOutputStream.flush();
                    }

                    case QNA_REQUEST -> {
                        System.out.println("Client wants to view list of all question and answers !");
                        QnaRequest qnaRequest = (QnaRequest) request;
                        System.out.println();
                        objectOutputStream.writeObject(DatabaseServices.createQna(qnaRequest));
                        objectOutputStream.flush();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println("Client disconnected!");

        try {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        } catch (Exception ignored) {

        }
    }
}
