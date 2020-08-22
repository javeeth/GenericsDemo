package afterGenerics2.restassured;

import afterGenerics2.entities.*;

import java.util.Map;

public class RestAssuredClient {

    private RestAssuredClientBase iRestClient;

    public RestAssuredClient() {
        this.iRestClient = new RestAssuredClientBase();
    }

    public RestResponse<PostEmployeeRsp> postEmployee(Employee requestObject){
        RestRequest restRequest = getRestRequest("http://dummy.restapiexample.com", "/api/v1/create", requestObject);
        return iRestClient.postRequest(restRequest, PostEmployeeRsp.class);
    }

    public RestResponse<GetEmployeesRsp> getEmployeeList() {
        RestRequest restRequest = getRestRequest("http://dummy.restapiexample.com", "/api/v1/employees");
        return iRestClient.getResponse(restRequest, GetEmployeesRsp.class);
    }

    public RestResponse<EmployeeInfo> getEmployee(String employeeId){
        RestRequest restRequest = getRestRequest("http://dummy.restapiexample.com", String.format("/api/v1/employee/%s", employeeId));
        return iRestClient.getResponse(restRequest, EmployeeInfo.class);
    }

    public RestResponse<GetUserResponse> getUser(String userId){
        RestRequest restRequest = getRestRequest("https://reqres.in", String.format("/api/users/%s", userId));
        return iRestClient.getResponse(restRequest, GetUserResponse.class);
    }





    private RestRequest getRestRequest(String endpoint, String requestUri){
        return getRestRequest(endpoint, requestUri, null, null);
    }

    private <T> RestRequest getRestRequest(String endpoint, String requestUri, T requestObject){
        return getRestRequest(endpoint, requestUri, requestObject, null);
    }

    private <T> RestRequest getRestRequest(String endpoint, String requestUri, T requestObject, Map<String, String> header){
        RestRequest restRequest = new RestRequest();
        restRequest.setEndpoint(endpoint);
        restRequest.setRequestObject(requestObject);
        restRequest.setRequestUri(requestUri);
        restRequest.setHeaderMap(header);
        return restRequest;
    }

}
