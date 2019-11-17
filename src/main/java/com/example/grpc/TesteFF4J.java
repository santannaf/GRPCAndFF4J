package com.example.grpc;

import lombok.RequiredArgsConstructor;
import org.ff4j.FF4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TesteFF4J {

    private final FF4j ff4j;

    @GetMapping(path = "/teste/ff4j")
    public String testController() {

        ff4j.getFeatures().size();

        if (ff4j.check("hello")) return "Helloooooow Worlddddd!!!";

        return "Feature is disabled";
    }
}
