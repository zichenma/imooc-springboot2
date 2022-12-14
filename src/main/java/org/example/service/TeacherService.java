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

    /**
     *  根据条件删除 teacher
     * @param teacher
     */
    public void deleteTeacher(Teacher teacher);

    /**
     *  用于演示事务
     */
    public void  testTrans();

    /**
     *  用于演示 SQL 语句 Query
     * @param id
     * @return
     */
    public Teacher queryByIdCustom(String id);

}
