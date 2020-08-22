package afterGenerics1;

import afterGenerics2.entities.*;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {

    RestClientS1 restClientS1 = new RestClientS1();
    Gson gson = new Gson();

    @Test
    public void happyPathGetEmployeeList(){
        GetEmployeesRsp getEmployeesRsp = restClientS1.getEmployeeList();
        System.out.println(("GetEmployee Response  : \n" + gson.toJson(getEmployeesRsp)));
        Assert.assertEquals(getEmployeesRsp.getStatus(), "success");
    }

    @Test
    public void happyPathGetUserById() {
        GetUserResponse getUserRsp = restClientS1.getUser("1");
        System.out.println(("Get User Response  : \n" + gson.toJson(getUserRsp)));
        Assert.assertEquals(getUserRsp.getData().getId(), 1);
    }

    @Test
    public void happyPathPostEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setAge("25");
        employee.setName("Dhoni");
        employee.setSalary("100000");

        PostEmployeeRsp postEmployeeRsp = restClientS1.postEmployee(employee);
        System.out.println(("Post Employee Response  : \n" + gson.toJson(postEmployeeRsp)));
        Assert.assertEquals(postEmployeeRsp.getStatus(), "success");
    }
}
