package api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Properties;
import java.util.TreeMap;

public class Helper {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static String getObjectMapper(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * 50);
    }



}
