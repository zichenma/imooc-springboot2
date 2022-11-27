package org.example.service.impl;

import org.example.mapper.TeacherMapper;
import org.example.pojo.Teacher;
import org.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

// 既然是 service 的实现，而且需要放到 springboot 容器里，供 controller 调用, 所以需要 @Service
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherMapper.insert(teacher);
    }

    @Override
    public Teacher queryById(String id) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        return teacher;
    }

    // 根据一个条件去进行查询

//    @Override
//    public List<Teacher> queryByCondition(String name, Integer sex) {
//        Example example = new Example(Teacher.class);
//        Example.Criteria criteria = example.createCriteria();
//        //相当于 WHERE name={name} AND sex={sex}
//        criteria.andEqualTo("name", name);
//        criteria.andEqualTo("sex", sex);
//        List<Teacher> teacherList = teacherMapper.selectByExample(example);
//        return teacherList;
//    }

    // 根据一个条件对象去进行查询
    @Override
    public List<Teacher> queryByCondition(String name, Integer sex) {
        // 条件对象 (只适用于严格查询, 模糊查询等则需要用 Criteria）
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSex(sex);
        List<Teacher> teacherList = teacherMapper.select(teacher);
        return teacherList;
    }

    // 也可以返回一个 int， MyBatis 会返回一个 int (1: 成功，0：没有变化) 标识更改成功与否
    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        // 删除对象/数据有三种方式
        // 1. 根据主键删除
       //  teacherMapper.deleteByPrimaryKey(teacher.getId());
        // 2. 根据对象中的匹配值条件做删除, 如果是空的属性则不做匹配，条件满足则删除所有entry
       // teacherMapper.delete(teacher);
        // 3. 根据构建的 example  进行条件删除
        Example example = new Example(Teacher.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", teacher.getName());
        teacherMapper.deleteByExample(example);
    }
}
