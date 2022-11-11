package response;

import java.io.Serializable;
import java.net.URL;

public class SignupResponse extends AppResponse implements Serializable {
    private static final long serialVersionUID = 8529685098267757691L;

    private String message;




    public SignupResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

   // public void setMessage(String message) {
     //   this.message = message;
    //}

    @Override
    ResponseType getResponseType() {
        return ResponseType.SIGNUP_RESPONSE;
    }
}
