package org.example.service.impl;

import org.example.mapper.TeacherMapper;
import org.example.pojo.Teacher;
import org.example.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;

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

    // 如果没有事务，则会新创建一个事务
    // Propagation.SUPPORTS: 如果有事务则按照事务执行，如果没有则没有， 一般可能在查询中会用到
    // Propagation.MANDATORY:如果存在事务，则按照事务执行，没有事务则抛出异常
    // Propagation.REQUIRED_NEW: 无论怎样都会创建一个新的事务去执行
    // Propagation.NOT_SUPPORTED: 以非事务方式执行，如果当前存在事务，则事务会被挂起
    // Propagation.NEVER: 永远不使用事务，以非事务方式执行，如果有事务则抛出异常
    // Propagation.NESTED: 创建子事务去运行
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testTrans() {
        // 1. 新增数据
        // 2. 修改数据
        // 3. 模拟发生异常
        // 4. 观察 1和2 步骤所发生的数据变动， 有没有影响到数据库
        // 5. 处理事务，实现事务的回滚，不让先前的书库入库
        Teacher teacher = new Teacher();


        String tId = UUID.randomUUID().toString();
        teacher.setId(tId);
        teacher.setName(tId);
        teacher.setSex(2);
        teacherMapper.insert(teacher);

        int a = 100 / 0;

        Teacher teacherUpdate = new Teacher();
        teacherUpdate.setId("3dccd999-4795-4ea4-bb0f-2b0355044e80");
        teacherUpdate.setName("1001 updated");
        teacherUpdate.setSex(3);
        teacherMapper.updateByPrimaryKeySelective(teacherUpdate);
    }
}
