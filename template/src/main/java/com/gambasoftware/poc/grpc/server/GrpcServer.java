package com.gambasoftware.poc.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new UserServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
