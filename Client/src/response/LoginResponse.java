package response;

import java.io.Serializable;

public class LoginResponse extends AppResponse implements Serializable {
    private final String username;
    private final String password;


    public LoginResponse(String username, String emailID) {
        this.username = username;
        this.password= emailID;
    }

    public String getUserName() {
        return username;
    }


    public String getEmailID() {
        return password;
    }

    @Override
    ResponseType getResponseType() {
        return ResponseType.LOGIN_RESPONSE;
    }
}
