package com.serialization;

import com.serialization.entities.Employee;
import com.serialization.entities.generated.Emp;
import com.serialization.json.JacksonSer;
import com.serialization.proto.ProtoSer;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final Employee e = new Employee(1, "Once", System.currentTimeMillis(),
                Arrays.asList("D1", "D2", "D3"));

        System.out.println(new JacksonSer().deserialize(new JacksonSer().serialize(e)).getName());

        ProtoSer proto = new ProtoSer();
        byte[] b = proto.serialize(Emp.Employee.newBuilder()
                .setId(1)
                .setGreeting("Once")
                .setDob(System.currentTimeMillis())
                .addDepts("D1")
                .addDepts("D2")
                .addDepts("D3")
                .build());
        System.out.println(proto.deserialize(b).getGreeting());
    }
}
