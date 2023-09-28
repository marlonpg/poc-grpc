package com.gambasoftware.poc.grpc.client;

import com.gambadeveloper.poc.grpc.Data;
import com.gambadeveloper.poc.grpc.User;
import com.gambadeveloper.poc.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        User response = stub.createUser(Data.newBuilder()
                .setName("Marlon")
                .setEmail("marlon@email.com")
                .build());

        System.out.println(response);
        channel.shutdown();
    }
}
