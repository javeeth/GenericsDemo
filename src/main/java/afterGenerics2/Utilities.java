package afterGenerics2;

import afterGenerics2.entities.GetEmployeesRsp;
import afterGenerics2.entities.GetUserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class Utilities {

    public GetUserResponse deSerializeToGetUserResponse(InputStream input) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(input, GetUserResponse.class);
    }

    public GetEmployeesRsp deSerializeToEmployee(InputStream input) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(input, GetEmployeesRsp.class);
    }


    public <T> T deSerializeJSON(InputStream input, Class<T>  contentClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(input, contentClass);
    }

}
