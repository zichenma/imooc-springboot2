package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Teacher;
import org.example.pojo.bo.TeacherBO;
import org.example.service.TeacherService;
import org.example.utils.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("create2")
    public JSONResult createTeacher2(@Valid @RequestBody TeacherBO teacherBO, BindingResult result) {

        // 判断 BindingResult 是否有错误， 错误信息会包含在里面，如果有则直接 return
        if (result.hasErrors()) {
            Map<String, String> map = getErrors(result);
            return JSONResult.errorMap(map);
        }
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherBO, teacher); // 拷贝对象属性 (from, to)
        String tId = UUID.randomUUID().toString();
        teacher.setId(tId);
        teacherService.saveTeacher(teacher);
        return JSONResult.ok();
    }

    public Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = (List<FieldError>) result.getFieldError();
        for (FieldError error: errorList) {
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field, msg);
        }
        return map;
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
