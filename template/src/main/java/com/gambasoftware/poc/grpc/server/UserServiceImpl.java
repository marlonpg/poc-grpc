package com.gambasoftware.poc.grpc.server;

import com.gambadeveloper.poc.grpc.Data;
import com.gambadeveloper.poc.grpc.User;
import com.gambadeveloper.poc.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void createUser(Data request, StreamObserver<User> userStreamObserver) {

        User user = User.newBuilder()
                .setId("100")
                .setName("Marlon")
                .setEmail("marlon@email.com")
                .build();

        userStreamObserver.onNext(user);
        userStreamObserver.onCompleted();
    }
}
