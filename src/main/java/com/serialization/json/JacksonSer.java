package com.serialization.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.serialization.entities.Employee;

import java.io.IOException;

public class JacksonSer {

    private final static ObjectMapper mapper = new ObjectMapper();
    private final static ObjectReader reader = mapper.readerFor(Employee.class);
    private final static ObjectWriter writer = mapper.writerFor(Employee.class);

    private static JacksonSer jacksonSer = new JacksonSer();

    public Employee deserialize(byte[] ser) {
        try {
            return reader.readValue(ser);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] serialize(Employee e) {
        try {
            return writer.writeValueAsBytes(e);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public static JacksonSer get() {
        return jacksonSer;
    }
}
