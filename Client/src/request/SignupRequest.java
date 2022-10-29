package request;

import java.io.Serializable;

public class SignupRequest extends AppRequest implements Serializable {

    private String userName;
    private String email;
    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String userName, String email, String password) {

        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return userName;
    }

    public void setFirstName(String userName) {
        this.userName = userName;
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
        return RequestType.SIGNUP_REQUEST;
    }
}
