package request;

import java.io.Serializable;

public class LoginRequest extends AppRequest implements Serializable {

    private String email;
    private String password;
    private String username;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
        this.username = username ;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.LOGIN_REQUEST;
    }

}
