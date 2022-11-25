package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.MyConfig;
import org.example.pojo.Student;
import org.example.pojo.StudentLombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController // 相当于是 @Controller +  @ResponseBody
@RequestMapping("stu")
@Slf4j
public class StuController {

    @GetMapping("get")
    public String getStu() {
        return "query Stu";
    }

    @PostMapping("create")
    public String createStu() {
        return "create Stu";
    }

    @PutMapping("update")
    public String updateStu() {
        return "update Stu";
    }

    @DeleteMapping("delete")
    public String deleteStu() {
        return "delete Stu";
    }


}
