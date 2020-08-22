package afterGenerics2;

import afterGenerics2.entities.*;
import afterGenerics2.restassured.RestAssuredClient;
import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTests {

    RestAssuredClient restAssuredClient = new RestAssuredClient();
    Gson gson = new Gson();

    @Test
    public void happyPathGetEmployeeList() {
        RestResponse<GetEmployeesRsp> getEmployeesRsp = restAssuredClient.getEmployeeList();
        System.out.println(("Get Employees Response  : \n" + gson.toJson(getEmployeesRsp.getApiResponseBody())));
        Assert.assertEquals(getEmployeesRsp.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(getEmployeesRsp.getApiResponseBody().getStatus(), "success");
        String header = getEmployeesRsp.getResponseHeaders().getValue("Content-Type");
        System.out.println(header);
    }

    @Test
    public void happyPathGetUser() {
        RestResponse<GetUserResponse> getUserRsp = restAssuredClient.getUser("1");
        System.out.println(("Get User Response  : \n" + gson.toJson(getUserRsp.getApiResponseBody())));
        Assert.assertEquals(getUserRsp.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(getUserRsp.getApiResponseBody().getData().getId(), 1);
    }

    @Test
    public void happyPathPostEmployee() {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setAge("25");
        employee.setName("Dhoni");
        employee.setSalary("100000");


        RestResponse<PostEmployeeRsp> postEmployeeRsp = restAssuredClient.postEmployee(employee);
        System.out.println(("Post Employee Response  : \n" + gson.toJson(postEmployeeRsp.getApiResponseBody())));
        Assert.assertEquals(postEmployeeRsp.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(postEmployeeRsp.getApiResponseBody().getStatus(), "success");
    }
}
