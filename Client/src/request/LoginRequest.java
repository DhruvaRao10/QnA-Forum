package request;

import java.io.Serializable;

public class LoginRequest extends AppRequest implements Serializable {
   private String username;
    private String email;
    private String password;

    public LoginRequest(String usernameField, String emailIDField , String passwordField) {
    }

    public LoginRequest(String email, String password) {
        this.username=username;
        this.email = email;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }



    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    @Override
    public RequestType getRequestType() {
        return RequestType.LOGIN_REQUEST;
    }
}
