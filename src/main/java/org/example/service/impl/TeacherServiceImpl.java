package org.example.service.impl;

import org.example.mapper.TeacherMapper;
import org.example.pojo.Teacher;
import org.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 既然是 service 的实现，而且需要放到 springboot 容器里，供 controller 调用, 所以需要 @Service
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }
}
