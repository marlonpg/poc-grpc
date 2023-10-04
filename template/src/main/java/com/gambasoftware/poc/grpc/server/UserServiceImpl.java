package com.gambasoftware.poc.grpc.server;

import com.gambasoftware.poc.grpc.Data;
import com.gambasoftware.poc.grpc.Request;
import com.gambasoftware.poc.grpc.User;
import com.gambasoftware.poc.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(User.newBuilder()
                .setId("1")
                .setName("Marlon")
                .setEmail("marlon@email.com")
                .setCreatedAt("2023-01-01")
                .build());
        users.add(User.newBuilder()
                .setId("2")
                .setName("John")
                .setEmail("john@email.com")
                .setCreatedAt("2023-01-28")
                .build());
        users.add(User.newBuilder()
                .setId("3")
                .setName("Tom")
                .setEmail("tom@email.com")
                .setCreatedAt("2023-09-28")
                .build());
        users.add(User.newBuilder()
                .setId("4")
                .setName("Rich")
                .setEmail("rich@email.com")
                .setCreatedAt("2023-10-21")
                .build());
    }

    @Override
    public void createUser(Data request, StreamObserver<User> userStreamObserver) {

        User user = User.newBuilder()
//                .setId((users.stream()
//                        .map(User::getId)
//                        .map(Integer::getInteger)
//                        .max(Integer::max).get() + 1) + "")
                .setName(request.getName())
                .setEmail(request.getEmail())
                .setCreatedAt(LocalDate.now().toString())
                .build();

        users.add(user);
        userStreamObserver.onNext(user);
        userStreamObserver.onCompleted();
    }

    @Override
    public void getUsersByCreationDate(Request request, StreamObserver<User> responseObserver) {
        List<User> usersResponse = users.stream()
                .filter(user -> user.getCreatedAt().equals(request.getDate()))
                .collect(Collectors.toList());

        usersResponse.forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}
