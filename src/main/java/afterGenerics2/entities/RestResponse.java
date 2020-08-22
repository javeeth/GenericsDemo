package afterGenerics2.entities;

import io.restassured.http.Headers;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResponse<T> {

    private int statusCode;
    private T apiResponseBody;
    private Headers responseHeaders;
}
