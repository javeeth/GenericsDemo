package beforeGenerics;

import afterGenerics2.entities.*;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BeforeGenericsTest {

    RestClientP1 restClientP1 = new RestClientP1();
    Gson gson = new Gson();

    @Test
    public void happyPathGetEmployeeList(){
        GetEmployeesRsp getEmployeesRsp = restClientP1.getEmployeeList();
        System.out.println(("GetEmployee Response  : \n" + gson.toJson(getEmployeesRsp)));
        Assert.assertEquals(getEmployeesRsp.getStatus(), "success");
    }

    @Test
    public void happyPathGetUserById() {
        GetUserResponse getUserRsp = restClientP1.getUser("1");
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

        PostEmployeeRsp postEmployeeRsp = restClientP1.postEmployee(employee);
        System.out.println(("Post Employee Response  : \n" + gson.toJson(postEmployeeRsp)));
        Assert.assertEquals(postEmployeeRsp.getStatus(), "success");
    }
}
