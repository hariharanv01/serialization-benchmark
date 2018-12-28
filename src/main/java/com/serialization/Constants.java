package com.serialization;

import com.serialization.entities.Employee;
import com.serialization.json.JacksonSer;
import com.serialization.json.JacksonSmileSer;
import com.serialization.kryo.KryoSer;
import com.serialization.proto.ProtoSer;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

    public static final Employee EMPLOYEE = new Employee(1, "Once", System.currentTimeMillis(),
            new ArrayList<>(Arrays.asList("D1", "D2", "D3")));

    public static final byte[] EMPLOYEE_BYTE_JACKSON = JacksonSer.get().serialize(EMPLOYEE);

    public static final byte[] EMPLOYEE_BYTE_JACKSON_SMILE = JacksonSmileSer.get().serialize(EMPLOYEE);

    public static final byte[] EMPLOYEE_BYTE_KRYO = KryoSer.get().serialize(EMPLOYEE);

    public static final com.serialization.entities.generated.Emp.Employee EMPLOYEE_PROTO =
            com.serialization.entities.generated.Emp.Employee.newBuilder()
                    .setId(1)
                    .setGreeting("Once")
                    .setDob(System.currentTimeMillis())
                    .addDepts("D1")
                    .addDepts("D2")
                    .addDepts("D3")
                    .build();

    public static final byte[] EMPLOYEE_BYTE_PROTO = ProtoSer.get().serialize(EMPLOYEE_PROTO);
}
