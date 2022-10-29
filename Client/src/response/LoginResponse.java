package response;

import java.io.Serializable;

public class LoginResponse extends AppResponse implements Serializable {
    private final String userName,emailID;


    public LoginResponse(String userName, String emailID) {
        this.userName = userName;
        this.emailID = emailID;
    }

    public String getFirstName() {
        return userName;
    }


    public String getEmailID() {
        return emailID;
    }

    @Override
    ResponseType getResponseType() {
        return ResponseType.LOGIN_RESPONSE;
    }
}
