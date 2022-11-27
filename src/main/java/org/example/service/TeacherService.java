package org.example.service;

import org.example.pojo.Teacher;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface TeacherService {
    /**
     * 新增 Teacher 到数据库
     * @param teacher
     */
    public void saveTeacher(Teacher teacher);

    /**
     * 根据条件查询 teacher 的 list 结果集
     * @param id
     */
    public Teacher queryById(String id);

    public List<Teacher> queryByCondition(String name, Integer sex);

    /**
     * 修改 teacher 到数据库
     * @param teacher
     * @return
     */
    public void updateTeacher(Teacher teacher);
}
