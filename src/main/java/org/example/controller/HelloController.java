package org.example.controller;

import org.example.pojo.MyConfig;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private MyConfig myConfig;

    @GetMapping("getMyConfig")
    public Object getMyConfig(){
        return myConfig;
    };

    @Value("${self.custom.config.sdkSecrect}")
    private String sdkSecrect;
    @Value("${self.custom.config.host}")
    private String host;

    @Value("${self.custom.config.port}")
    private String port;
    @Value("${app.name.xxx.yyy.zzz}")
    private String xyz;

    @GetMapping("getYmlCustomConfig")
    public Object getYmlCustomConfig(){
        return sdkSecrect + ";\t" + host + ":" + port + ";\t" + xyz;
    };

}
