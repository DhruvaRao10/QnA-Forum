package request;

import java.io.Serializable;
import java.net.URL;

public class SearchqRequest extends AppRequest implements Serializable {

    private static final long serialVersionUID = 3529685098267757690L;


    private String searchkey;


    public SearchqRequest() {
    }

    public SearchqRequest(String  searchkey) {

        this.searchkey=searchkey ;
    }


    public String getSearchkey() {
        return searchkey;
    }


    //  public void setUsername(String username) {
    // this.username = username;
    // }



    //public void setPassword(String password) {
    //   this.password = password;
    //}

    @Override
    public RequestType getRequestType() {
        return RequestType.SEARCHQ_REQUEST;
    }

}
