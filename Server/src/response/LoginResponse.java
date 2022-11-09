package response;

import java.io.Serializable;

public class LoginResponse extends AppResponse implements Serializable {
    public  String emailID ;
    public  String username;




    public LoginResponse(String username , String emailID) {

        this.emailID = emailID;
        this.username = username;
    }


    public String getLastName() {
        return username;
    }

    public String getEmailID() {
        return emailID;
    }

    @Override
    ResponseType getResponseType() {
        return ResponseType.LOGIN_RESPONSE;
    }
}
