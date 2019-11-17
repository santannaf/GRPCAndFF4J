package com.example.grpc.user;

import com.example.grpc.User;
import com.example.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {

        System.out.println("Inside login");

        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if(username.equals(password)) {
            // return success message
            response.setResponseCode(0).setResponsemessage("SUCCESS");

        }
        else {
            response.setResponseCode(100).setResponsemessage("INVALID PASSWORD");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

    }

}
