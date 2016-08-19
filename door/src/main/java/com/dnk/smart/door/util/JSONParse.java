package com.dnk.smart.door.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParse {

    public static String toJSON(Object Object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        String json = null;
        try {
            json = mapper.writeValueAsString(Object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
