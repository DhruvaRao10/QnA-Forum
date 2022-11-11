package request;

import java.io.Serializable;
import java.net.URL;

public class CreateqRequest extends AppRequest implements Serializable {

    private static final long serialVersionUID = 2529685098267757690L;




    private String email;
    private String password;
    private String username;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {

        this.password = password;
        this.username = username ;
    }


    public String getUsername() {
        return username;
    }


    //  public void setUsername(String username) {
    // this.username = username;
    // }


    public String getPassword() {
        return password;
    }

    //public void setPassword(String password) {
    //   this.password = password;
    //}

    @Override
    public RequestType getRequestType() {
        return RequestType.LOGIN_REQUEST;
    }

}

