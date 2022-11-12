package response;

import java.io.Serializable;

public class SearchqResponse extends AppResponse implements Serializable {
    private static final long serialVersionUID = 3529685098267757690L;
    private  String response ;



    public SearchqResponse(String question, String tag) {
        this.response = question;

    }

    public String getSearchResponse() {
        return response;
    }




    @Override
    ResponseType getResponseType() {
        return ResponseType.SEARCHQ_RESPONSE;
    }
}
