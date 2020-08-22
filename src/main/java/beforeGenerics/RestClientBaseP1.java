package beforeGenerics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import afterGenerics2.entities.*;

import static io.restassured.RestAssured.given;

public class RestClientBaseP1 {

    public GetEmployeesRsp getEmployees(String baseURI, String basePath){

        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;

        Response response =  given()
                .get()
                .then()
                .extract()
                .response();

        return response.as(GetEmployeesRsp.class);
    }

    public GetUserResponse getUser(String baseURI, String basePath){

        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;

        Response response =  given()
                .get()
                .then()
                .extract()
                .response();

        return response.as(GetUserResponse.class);
    }

    public PostEmployeeRsp postRequest(String baseURI, String basePath, Employee restRequest){

        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;

        Response response =  given().contentType(ContentType.JSON)
                .body(restRequest)
                .post()
                .then()
                .extract()
                .response();

        return response.as(PostEmployeeRsp.class);
    }

}
