package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Teacher;
import org.example.pojo.bo.TeacherBO;
import org.example.service.TeacherService;
import org.example.utils.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("create2")
    public JSONResult createTeacher2(@RequestBody TeacherBO teacherBO) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherBO, teacher); // 拷贝对象属性 (from, to)
        String tId = UUID.randomUUID().toString();
        teacher.setId(tId);
        teacherService.saveTeacher(teacher);
        return JSONResult.ok();
    }

    @PostMapping("create")
    public JSONResult createTeacher() {
        Teacher teacher = new Teacher();
        String tId = UUID.randomUUID().toString();
        teacher.setId(tId);
        teacher.setName("Imooc");
        teacher.setAge(18);
        teacher.setSex(1);

        teacherService.saveTeacher(teacher);
        return JSONResult.ok();
    }
}
