package org.example.controller;

import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 依赖注入
    @Autowired
    private Student student;

    // 控制反转（IOC）： 本来需要在控制层 new student 对象，但是现在把 new 对象从控制层，放到了容器, 这样做的目的是为了更好的解耦
    @GetMapping("getStudent")
    public Object getStudent(){
        return student;
    };
}
