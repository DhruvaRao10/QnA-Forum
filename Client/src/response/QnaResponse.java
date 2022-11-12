package response;

import java.io.Serializable;

public class QnaResponse extends AppResponse implements Serializable {
    private static final long serialVersionUID = 3529685098267757691L;
    private  String response ;



    public QnaResponse(String response) {
        this.response = response;

    }

    public String getResponse() {
        return response;
    }




    @Override
    ResponseType getResponseType() {
        return ResponseType.QNA_RESPONSE;
    }
}
