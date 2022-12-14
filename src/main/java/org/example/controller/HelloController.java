package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.MyConfig;
import org.example.pojo.Student;
import org.example.pojo.StudentLombok;
import org.example.utils.JSONResult;
import org.example.utils.MyAsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

//@Controller
@RestController // 相当于是 @Controller +  @ResponseBody
@Slf4j
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

    @Autowired
    private MyAsyncTask myAsyncTask;
    @GetMapping("getMyConfig")
    public Object getMyConfig(){
        myAsyncTask.publishMsg();
        log.info("This is skip async task execution");
        /**
         * : Completed initialization in 2 ms
         * 2022-11-26 13:31:34.550  INFO 62992 --- [nio-8090-exec-1] org.example.controller.HelloController   : This is skip async task execution
         * 2022-11-26 13:31:39.559  WARN 62992 --- [         task-1] org.example.utils.MyAsyncTask            : Async task finished
         */
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

    @GetMapping("getStudentLombok")
    public JSONResult getStudentLombok(){
        StudentLombok stu = new StudentLombok();
        stu.setName("imooc");
        stu.setAge(18);
        // System.out.println(stu.toString());
        StudentLombok stu2 = new StudentLombok("jack", 20);
        log.info(stu.toString());
        log.debug(stu.toString());
        log.warn(stu.toString());
        log.error(stu.toString());
        return JSONResult.ok(stu2); // {"status":200,"msg":"OK","data":{"name":"jack","age":20}}
        // return JSONResult.errorMsg("Something wrong"); // {status: 500, msg: "Something wrong", data: null}
    };

    // must update userName
    @PostMapping("upload")
    public String upload(MultipartFile file) throws Exception {
        file.transferTo(new File("/Users/userName/Desktop/temp/" + file.getOriginalFilename()));
        return "Upload Successed!";
    }

}
