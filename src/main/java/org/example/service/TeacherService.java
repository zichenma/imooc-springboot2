package org.example.service;

import org.example.pojo.Teacher;

public interface TeacherService {
    /**
     * 新增 Teacher 到数据库
     * @param teacher
     */
    public void saveTeacher(Teacher teacher);
}
