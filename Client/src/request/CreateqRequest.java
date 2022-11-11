package request;

import java.io.Serializable;

public class CreateqRequest extends AppRequest implements Serializable {
    private static final long serialVersionUID = 2529685098267757690L;


    private String tag;
    private String question;



    public CreateqRequest(String tag, String question) {

        this.tag = tag;
        this.question = question;

    }


    public String getTag() {
        this.tag = tag;
        return tag;
    }


    public String getQuestion() {
        this.question=question;
        return question;
    }


    @Override
    public RequestType getRequestType() {
        return RequestType.CREATEQ_REQUEST;
    }
}
