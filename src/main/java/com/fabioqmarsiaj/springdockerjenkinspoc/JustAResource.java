package com.fabioqmarsiaj.springdockerjenkinspoc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class JustAResource {

    @PostMapping
    public String aResource(){
        return "Welcome to the API";
    }
}
