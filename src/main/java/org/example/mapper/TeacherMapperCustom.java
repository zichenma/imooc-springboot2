package org.example.mapper;

import org.example.my.mapper.MyMapper;
import org.example.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 如果没有 @Repository 则在 serviceImpl 注入的时候，会报错
public interface TeacherMapperCustom {
    public List<Teacher> getTeacherById(String teacherId);
}