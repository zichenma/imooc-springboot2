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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * POST: http://localhost:8090/teacher/create2
     * RequestBody: {
     *     "name": "imooc2",
     *     "sex": 0,
     *     "age": 20,
     *     "grade": 0,
     *     "classroom": 19,
     *     "skill": ["java", "html", "ios", "jsp", "css", "python"],
     *     "englishName": "ab",
     *     "emal": "sdafsfsaf"
     * }
     *
     * Response: {
     *     "status": 501,
     *     "msg": "error",
     *     "data": {
     *         "englishName": "Teacher's english name should between 1~18",
     *         "grade": "Minimum grade for teacher is 1",
     *         "skill": "At least 2 skills, at most 5 skills",
     *         "classroom": "Teacher's classroom between 1~18"
     *     }
     * }
     * @param teacherBO
     * @param result
     * @return
     */
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
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList) {
            // 获得检验发送错误的某个属性名称
            String field = error.getField();
            // 获得该属性发生错误的信息
            String msg = error.getDefaultMessage();
            errorMap.put(field, msg);
        }
        return errorMap;
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

    /**
     * Request: http://localhost:8090/teacher/get?teacherId=3dccd999-4795-4ea4-bb0f-2b0355044e80
     * Response:
     * {
         status: 200,
         msg: "OK",
         data: {
         id: "3dccd999-4795-4ea4-bb0f-2b0355044e80",
         name: "imooc2",
         age: 20,
         sex: 0
     }
     * @param teacherId
     * @return
     */
    @GetMapping("/get")
    public JSONResult getTeacher(String teacherId) {
        Teacher teacher = teacherService.queryById(teacherId);
        // Query by Condition:
        // List<Teacher> list = teacherService.queryByCondition("imooc1", 0);
        // return JSONResult.ok(list);
        return JSONResult.ok(teacher);
    }
}
