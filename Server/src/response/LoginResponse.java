package response;

import java.io.Serializable;

public class LoginResponse extends AppResponse implements Serializable {
    private static final long serialVersionUID = 8529685098267757690L;


    private final   String username;
    public  String  emailID;





    public LoginResponse(String username , String emailID) {

        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public String getEmailID(){return emailID;}


    @Override
    ResponseType getResponseType() {
        return ResponseType.LOGIN_RESPONSE;
    }
}
