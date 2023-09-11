package com.yonhoo.server.nettyRpcServer;


import com.yonhoo.nettyrpc.server.NettyServer;
import com.yonhoo.nettyrpc.server.NettyServerBuilder;
import com.yonhoo.nettyrpc.server.ServerServiceDefinition;
import com.yonhoo.server.student.StudentImpl;
import com.yonhoo.server.user.UserImpl;
import com.yonhoo.user.request.User;
import com.yonhoo.user.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;

@RestController
@RequestMapping("server")
public class Server {

    @GetMapping("/start")
    public void start() throws Exception {
        ServerServiceDefinition userService =
                new ServerServiceDefinition(User.class.getName(),
                        new UserImpl(),
                        User.class,
                        1,
                        Executors.newFixedThreadPool(32),
                        10);

        NettyServer nettyServer = NettyServerBuilder.forAddress("127.0.0.1", 13458)
                .addService(userService)
                .build();

        nettyServer.start();
    }

    @GetMapping("/student")
    public void student() throws Exception {
        ServerServiceDefinition userService =
                new ServerServiceDefinition(Student.class.getName(),
                        new StudentImpl(),
                        Student.class,
                        1,
                        Executors.newFixedThreadPool(32),
                        10);

        NettyServer nettyServer = NettyServerBuilder.forAddress("127.0.0.1", 13458)
                .addService(userService)
                .build();

        nettyServer.start();
    }
}
