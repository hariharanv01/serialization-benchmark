package benchmark;

import com.serialization.json.JacksonSer;
import com.serialization.json.JacksonSmileSer;
import com.serialization.kryo.KryoSer;
import com.serialization.proto.ProtoSer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

import static com.serialization.Constants.*;

public class SerializerBenchmark {

    @Benchmark
    public void jacksonSerialization() {
        JacksonSer.get().serialize(EMPLOYEE);
    }

    @Benchmark
    public void jacksonDeserialization() {
        JacksonSer.get().deserialize(EMPLOYEE_BYTE_JACKSON);
    }

    @Benchmark
    public void jacksonSmileSerialization() {
        JacksonSmileSer.get().serialize(EMPLOYEE);
    }

    @Benchmark
    public void jacksonSmileDeserialization() {
        JacksonSmileSer.get().deserialize(EMPLOYEE_BYTE_JACKSON_SMILE);
    }

    @Benchmark
    public void protobufSerialization() {
        ProtoSer.get().serialize(EMPLOYEE_PROTO);
    }

    @Benchmark
    public void protobufDeserialization() {
        ProtoSer.get().deserialize(EMPLOYEE_BYTE_PROTO);
    }

    @Benchmark
    public void kryoSerialization() {
        KryoSer.get().serialize(EMPLOYEE);
    }

    @Benchmark
    public void kryoDeserialization() {
        KryoSer.get().deserialize(EMPLOYEE_BYTE_KRYO);
    }

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(new String[]{"-rf", "json"});
    }
}
