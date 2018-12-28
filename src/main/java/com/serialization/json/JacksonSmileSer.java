package com.serialization.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import com.serialization.entities.Employee;

import java.io.IOException;
import java.util.Arrays;

public class JacksonSmileSer {

    private final static ObjectMapper mapper = new ObjectMapper(new SmileFactory());

    private static JacksonSmileSer jacksonSer = new JacksonSmileSer();

    private static final Employee e = new Employee(1, "Once", System.currentTimeMillis(),
            Arrays.asList("D1", "D2", "D3"));

    private static byte[] b;

    public Employee deserialize(byte[] ser) {
        try {
            return mapper.readValue(ser, Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] serialize(Employee e) {
        try {
            return mapper.writeValueAsBytes(e);
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public static JacksonSmileSer get() {
        return jacksonSer;
    }

    public static Employee getE() {
        return e;
    }

    public static byte[] getB() {
        if (b == null) {
            synchronized (JacksonSmileSer.class) {
                if (b == null) {
                    b = jacksonSer.serialize(getE());
                }
            }
        }
        return b;
    }
}
