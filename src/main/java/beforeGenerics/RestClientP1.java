package beforeGenerics;

import afterGenerics2.entities.*;


public class RestClientP1 {

    private RestClientBaseP1 iRestClient = new RestClientBaseP1();

    public PostEmployeeRsp postEmployee(Employee requestObject){
        return iRestClient.postRequest("http://dummy.restapiexample.com", "/api/v1/create", requestObject);
    }

    public GetEmployeesRsp getEmployeeList(){
        return iRestClient.getEmployees("http://dummy.restapiexample.com", "/api/v1/employees");
    }

    public GetUserResponse getUser(String userId){
        return iRestClient.getUser("https://reqres.in", String.format("/api/users/%s", userId));
    }

}
