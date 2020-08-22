package afterGenerics1;

import afterGenerics2.entities.*;

import java.util.Map;


public class RestClientS1 {

    private RestClientBaseS1 iRestClient = new RestClientBaseS1();

    public PostEmployeeRsp postEmployee(Employee requestObject){
        RestRequest restRequest = getRestRequest("http://dummy.restapiexample.com", "/api/v1/create", requestObject);
        return iRestClient.postRequest(restRequest);
    }

    public GetEmployeesRsp getEmployeeList(){
        RestRequest restRequest = getRestRequest("http://dummy.restapiexample.com", "/api/v1/employees");
        return iRestClient.getEmployees(restRequest);
    }

    public GetUserResponse getUser(String userId){
        RestRequest restRequest = getRestRequest("https://reqres.in", String.format("/api/users/%s", userId));
        return iRestClient.getUser(restRequest);
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
