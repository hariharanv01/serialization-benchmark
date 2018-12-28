package com.serialization.proto;


import com.google.protobuf.InvalidProtocolBufferException;
import com.serialization.entities.generated.Emp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProtoSer {

    private static ProtoSer protoSer = new ProtoSer();

    public Emp.Employee deserialize(byte[] data) {
        try {
            return Emp.Employee.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] serialize(Emp.Employee e) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            e.writeTo(bos);
            return bos.toByteArray();
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public static ProtoSer get() {
        return protoSer;
    }
}
