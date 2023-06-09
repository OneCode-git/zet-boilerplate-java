package com.zetapp.boilerplate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class DemoController {

    @GetMapping
    public void sayHello(){
        try {
            log.info("said hello");
        } catch(Exception e) {
            log.error("error");
        }
    }
}