package request;



import java.io.Serializable;

public class landingpageRequest extends AppRequest implements Serializable {
    private static final long serialVersionUID = 5529685098267757690L;


    private String email;
    private String password;

    public landingpageRequest(String usernameField, String emailIDField , String passwordField) {
    }

    public LoginRequest(String username , String password) {
        this.createq=createq ;
        this.searchq = searchq ;
    }
    public String getUsername() {
        return createq;
    }
    public String getPassword() {
        return searchq;
    }


    @Override
    public RequestType getRequestType() {
        return RequestType.LOGIN_REQUEST;
    }
}

