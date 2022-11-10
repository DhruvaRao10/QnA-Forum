package response;

import java.io.Serializable;

public class LoginResponse extends AppResponse implements Serializable {
    public  String username;




    public LoginResponse(String username , String emailID) {

        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    @Override
    ResponseType getResponseType() {
        return ResponseType.LOGIN_RESPONSE;
    }
}
