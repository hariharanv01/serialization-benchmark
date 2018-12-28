package com.serialization.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.serialization.entities.Employee;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoSer {

    private final Kryo KRYO;

    private static KryoSer kryoSer;

    private KryoSer() {
        KRYO = new Kryo();
        KRYO.register(Employee.class);
    }

    public byte[] serialize(Employee employee) {
        try (Output output = new Output(new ByteArrayOutputStream());
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            output.setOutputStream(os);
            KRYO.writeObject(output, employee);
            return output.toBytes();
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
    }

    public Employee deserialize(byte[] b) {
        try (Input input = new Input(b)) {
            return KRYO.readObject(input, Employee.class);
        }
    }

    public static KryoSer get() {
        if (kryoSer == null) {
            synchronized (KryoSer.class) {
                if (kryoSer == null)
                    kryoSer = new KryoSer();
            }
        }
        return kryoSer;
    }
}
