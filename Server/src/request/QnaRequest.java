package request;

import java.io.Serializable;
import java.net.URL;

public class QnaRequest extends AppRequest implements Serializable {

    private static final long serialVersionUID = 4529685098267757691L;




    @Override
    public RequestType getRequestType() {
        return RequestType.QNA_REQUEST;
    }

}
