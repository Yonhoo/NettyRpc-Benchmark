package com.yonhoo.client.nettyRpcClient;

import com.yonhoo.nettyrpc.registry.ConsumerConfig;
import com.yonhoo.user.request.UserResponse;
import com.yonhoo.user.student.Book;
import com.yonhoo.user.student.Student;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Service
public class StudentTest {
    public static final int CONCURRENCY = 32;
    private final Student user;
    private final ConsumerConfig<Student> config;

    public StudentTest() {
        config = new ConsumerConfig<>(Student.class.getName(), 300000, "sync");
        try {
            user = config.refer();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void start() throws RunnerException {
        Options opt = new OptionsBuilder()//
                .include(Client.class.getSimpleName())//
                .warmupIterations(3)//
                .warmupTime(TimeValue.seconds(10))//
                .measurementIterations(3)//
                .measurementTime(TimeValue.seconds(10))//
                .threads(CONCURRENCY)//
                .forks(1)//
                .build();

        new Runner(opt).run();
    }

//    @Benchmark
//    @BenchmarkMode({Mode.Throughput, Mode.AverageTime, Mode.SampleTime})
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public String getUserName() throws Exception {
//        return user.getUserName(UUID.randomUUID().toString());
//    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime, Mode.SampleTime})
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void createUser() throws Exception {
        List<Book> userResponse = user.getBook();
    }

}
