package response;

import java.io.Serializable;

public class SearchqResponse extends AppResponse implements Serializable {
    private static final long serialVersionUID = 3529685098267757690L;
    private final String searchkey ;



    public SearchqResponse(String question, String tag) {
        this.searchkey = searchkey;

    }

    public String getSearchkey() {
        return searchkey;
    }




    @Override
    ResponseType getResponseType() {
        return ResponseType.SEARCHQ_RESPONSE;
    }
}
