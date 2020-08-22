package afterGenerics2.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import afterGenerics2.entities.RestRequest;
import afterGenerics2.entities.RestResponse;

import static io.restassured.RestAssured.given;

public class RestAssuredClientBase {

    public <T> RestResponse<T> postRequest(RestRequest restRequest, Class<T> responseClass){

        RestAssured.baseURI = restRequest.getEndpoint();
        RestAssured.basePath = restRequest.getRequestUri();

        Response response =  given().contentType(ContentType.JSON)
                .body(restRequest.getRequestObject())
                .post()
                .then()
                .extract()
                .response();

        return mapResponse(responseClass, response);
    }

    public <T> RestResponse<T> getResponse(RestRequest restRequest, Class<T> responseClass){

        RestAssured.baseURI = restRequest.getEndpoint();
        RestAssured.basePath = restRequest.getRequestUri();

        Response response =  given()
                .get()
                .then()
                .extract()
                .response();

        return mapResponse(responseClass, response);
    }

    private <T> RestResponse<T> mapResponse(Class<T> responseClass, Response response) {

        RestResponse<T> apiResponse = new RestResponse<T>();

        apiResponse.setApiResponseBody(response.as(responseClass));
        apiResponse.setStatusCode(response.statusCode());
        apiResponse.setResponseHeaders(response.getHeaders());
        return apiResponse;
    }

}
