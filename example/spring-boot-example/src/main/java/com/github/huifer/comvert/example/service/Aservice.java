package com.github.huifer.comvert.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author huifer
 */
@Service
public class Aservice {
    @Autowired
    private ApplicationContext context;

    public String a() {
        return "aaaa";
    }
}
