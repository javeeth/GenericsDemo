package afterGenerics1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import afterGenerics2.entities.*;

import static io.restassured.RestAssured.given;

public class RestClientBaseS1 {

    public PostEmployeeRsp postRequest(RestRequest restRequest){

        RestAssured.baseURI = restRequest.getEndpoint();
        RestAssured.basePath = restRequest.getRequestUri();

        Response response =  given().contentType(ContentType.JSON)
                .body(restRequest.getRequestObject())
                .post()
                .then()
                .extract()
                .response();

        return response.as(PostEmployeeRsp.class);
    }

    public GetEmployeesRsp getEmployees(RestRequest restRequest) {

        RestAssured.baseURI = restRequest.getEndpoint();
        RestAssured.basePath = restRequest.getRequestUri();

        Response response =  given()
                .get()
                .then()
                .extract()
                .response();

        return response.as(GetEmployeesRsp.class);
    }

    public GetUserResponse getUser(RestRequest restRequest) {

        RestAssured.baseURI = restRequest.getEndpoint();
        RestAssured.basePath = restRequest.getRequestUri();

        Response response =  given()
                .get()
                .then()
                .extract()
                .response();

        return response.as(GetUserResponse.class);
    }

    public EmployeeInfo getEmployee(RestRequest restRequest){

        RestAssured.baseURI = restRequest.getEndpoint();
        RestAssured.basePath = restRequest.getRequestUri();

        Response response =  given()
                .get()
                .then()
                .extract()
                .response();

        return response.as(EmployeeInfo.class);
    }

}
