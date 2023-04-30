package utilities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;


public class ObjectMapper01
{

    public static <T> T convertToJson(String json, Class<T> cls) {//Generic Method

        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
