package com.jtool.validator;

import org.junit.BeforeClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnotationValidatorTest {

    private final String host = "http://localhost:8099";

    @BeforeClass
    public static void setup() {
        String[] args = new String[0];
        SpringApplication.run(AnnotationValidatorTest.class, args);
    }



}