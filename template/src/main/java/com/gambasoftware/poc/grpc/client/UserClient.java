package com.gambasoftware.poc.grpc.client;

import com.gambasoftware.poc.grpc.Data;
import com.gambasoftware.poc.grpc.Request;
import com.gambasoftware.poc.grpc.User;
import com.gambasoftware.poc.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class UserClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        //createUser(channel);

        getUsers(channel);
        channel.shutdown();
    }

    public static void createUser(ManagedChannel channel) {
        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        User response = stub.createUser(Data.newBuilder()
                .setName("Marlon")
                .setEmail("marlon@email.com")
                .build());

        System.out.println(response);
    }


    public static void getUsers(ManagedChannel channel) {
        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        Iterator usersIt = stub.getUsersByCreationDate(Request.newBuilder()
                .setDate("2023-09-28").build());

        while (usersIt.hasNext()) {
            System.out.println(usersIt.next());
        }
    }
}
