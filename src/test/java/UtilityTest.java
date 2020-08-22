import afterGenerics2.entities.GetEmployeesRsp;
import afterGenerics2.entities.GetUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import afterGenerics2.Utilities;
import afterGenerics2.entities.Employee;
import afterGenerics2.entities.EmployeeInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UtilityTest {

    Utilities utilities = new Utilities();

    @Test
    public void validateEmployeeInfoJSON() throws IOException {

        InputStream input = new FileInputStream((System.getProperty("user.dir"))
                        + "/src/test/resources/User.json");

        GetUserResponse getUserRsp = utilities.deSerializeToGetUserResponse(input);
        Assert.assertEquals(getUserRsp.getData().getId(), 2);
    }

    @Test
    public void validateEmployeesJSON() throws IOException {

        InputStream input = new FileInputStream((System.getProperty("user.dir"))
                + "/src/test/resources/Employee.json");

        GetEmployeesRsp employeeInfo = utilities.deSerializeToEmployee(input);
        Assert.assertEquals(employeeInfo.getStatus(), "success");
    }

    @Test
    public void validateGenericDeserializationMethod() throws IOException {
        InputStream input = new FileInputStream((System.getProperty("user.dir"))
                + "/src/test/resources/User.json");

        GetUserResponse getUserResponse = utilities.deSerializeJSON(input, GetUserResponse.class);
        Assert.assertEquals(getUserResponse.getData().getId(), 2);

        input = new FileInputStream((System.getProperty("user.dir"))
                + "/src/test/resources/Employee.json");

        GetEmployeesRsp employee = utilities.deSerializeJSON(input, GetEmployeesRsp.class);
        Assert.assertEquals(employee.getStatus(), "success");
    }












    public static <T> void checkList(List<?> myList, T obj){
        if(myList.contains(obj)){
            System.out.println("The list contains the element: " + obj);
        } else {
            System.out.println("The list does not contain the element: " + obj);
        }
    }


    public static <T extends Number> void copy1(List<T> dest, List<T> src) { }

    public static void copy(List<? extends Number> dest, List<? extends Number> src) {}
}
