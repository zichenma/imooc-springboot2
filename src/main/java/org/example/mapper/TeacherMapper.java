package org.example.mapper;

import org.example.my.mapper.MyMapper;
import org.example.pojo.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper extends MyMapper<Teacher> {
}