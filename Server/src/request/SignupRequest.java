package request;

import java.io.Serializable;

public class SignupRequest extends AppRequest implements Serializable {


    private String username;
    private String email;
    private String password;

    public SignupRequest() {
    }

    public SignupRequest( String username,String email, String password) {


        this.username = username;
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
        return RequestType.SIGNUP_REQUEST;
    }
}
