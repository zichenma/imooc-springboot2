package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController // 相当于是 @Controller +  @ResponseBody
public class HelloController {

    // @RequestMapping("hello")
    // @ResponseBody
    @GetMapping("hello")
   //  @PostMapping("hello")
//    @DeleteMapping
//    @PutMapping
    public String hello() {
        return "Hello World~~";
    }
}
