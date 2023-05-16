package api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Properties;
import java.util.TreeMap;

public class Helper {

    static ObjectMapper objectMapper = new ObjectMapper();

    // Object mapper function to convert object to string
    public static String getObjectMapper(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    // Function to generate random number
    public static int generateRandomNumber() {
        return (int) (Math.random() * 50);
    }



}
