package request;

import java.io.Serializable;
import java.net.URL;

public class CreateqRequest extends AppRequest implements Serializable {

    private static final long serialVersionUID = 2529685098267757690L;




    private String tag;
    private String question;


    public CreateqRequest() {
    }

    public CreateqRequest(String tag, String question) {

        this.tag = tag ;
        this.question = question ;
    }


    public String getTag() {
        return tag;
    }


    //  public void setUsername(String username) {
    // this.username = username;
    // }


    public String getQuestion() {
        return question;
    }

    //public void setPassword(String password) {
    //   this.password = password;
    //}

    @Override
    public RequestType getRequestType() {
        return RequestType.CREATEQ_REQUEST;
    }

}

