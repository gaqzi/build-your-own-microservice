package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SsoEnabledController {
    @GetMapping(path = "/sso/hello", produces = "text/plain")
    @ResponseBody
    public String hello() {
        return "Hello world!";
    }
}
