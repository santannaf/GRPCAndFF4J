package com.example.grpc;

import com.example.grpc.user.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
//		System.out.println("starting GRPC Server");
//		Server server = ServerBuilder.forPort(9090).addService(
//
//				new UserService()).build();
//
//		server.start();
//		System.out.println("server started at "+ server.getPort());
//		server.awaitTermination();

		SpringApplication.run(GrpcApplication.class, args);
	}

}
