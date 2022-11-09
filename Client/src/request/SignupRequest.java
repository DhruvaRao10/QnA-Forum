package request;

import java.io.Serializable;

public class SignupRequest extends AppRequest implements Serializable {

    private String email;
    private String password;
    private String username;



    public SignupRequest(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;
    }


    public String getUsername(String username) {
        this.username = username;
        return username;
    }


    public String getEmail() {
        this.email = email;
        return email;
    }


    public String getPassword() {
        this.password=password;
        return password;
    }


    @Override
    public RequestType getRequestType() {
        return RequestType.SIGNUP_REQUEST;
    }
}
