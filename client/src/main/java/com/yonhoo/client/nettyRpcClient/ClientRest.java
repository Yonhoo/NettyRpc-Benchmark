package com.yonhoo.client.nettyRpcClient;

import org.openjdk.jmh.runner.RunnerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientRest {
    @Autowired
    private Client client;

    @Autowired
    private StudentTest student;

    @GetMapping("/start")
    public void start() throws RunnerException {
        student.start();
    }
}
