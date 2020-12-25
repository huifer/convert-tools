package com.github.huifer.comvert.example;

import com.github.huifer.convert.forspring.annotation.EnableCommonConvert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author huifer
 */
@SpringBootApplication
@EnableCommonConvert(scanPackages = {"com.github.huifer.comvert.example.convet"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
