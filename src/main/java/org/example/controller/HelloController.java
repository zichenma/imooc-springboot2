package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // 相当于是 @Controller +  @ResponseBody
public class HelloController {

    @RequestMapping("hello")
    // @ResponseBody
    public String hello() {
        return "Hello World ~~";
    }
}
