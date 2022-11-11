package response;

import java.io.Serializable;

public class CreateqResponse extends AppResponse implements Serializable {
    private static final long serialVersionUID = 4529685098267757690L;


     public    String tag;
    public  String  question;

    public CreateqResponse(String  tag , String question) {

        this.tag = tag;
        this.question =question ;

    }


    public String getTag() {
        return tag;
    }

    public String getQuestion(){return question;}


    @Override
    ResponseType getResponseType() {
        return ResponseType.CREATEQ_RESPONSE;
    }
}
