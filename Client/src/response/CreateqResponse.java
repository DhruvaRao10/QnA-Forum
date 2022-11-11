package response;

import java.io.Serializable;

public class CreateqResponse extends AppResponse implements Serializable {
    private static final long serialVersionUID = 4529685098267757690L;
    private final String  tag;
    private final String  question;


    public CreateqResponse(String question, String tag) {
        this.tag = tag;
        this.question= question ;
    }

    public String getTag() {
        return tag;
    }


    public String getQuestion() {
        return question;
    }

    @Override
    ResponseType getResponseType() {
        return ResponseType.CREATEQ_RESPONSE;
    }
}
