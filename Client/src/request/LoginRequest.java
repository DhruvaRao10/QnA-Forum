package request;

import java.io.Serializable;

public class LoginRequest extends AppRequest implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String username;
    private String email;
    private String password;

    public LoginRequest(String usernameField, String emailIDField , String passwordField) {
    }

    public LoginRequest(String username , String password) {
        this.username=username;
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
