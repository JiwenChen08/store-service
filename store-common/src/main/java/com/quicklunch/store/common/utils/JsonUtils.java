package com.quicklunch.store.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtils {
    public static final ObjectMapper MAPPER = new ObjectMapper();
    {
        MAPPER.registerModule(new JavaTimeModule());
    }

    public static <T> T parse(String content, Class<T> valueTypeRef) {
        try {
            return (T) MAPPER.readValue(content, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object value) {
        try {
            return MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
