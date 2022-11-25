package org.example.pojo;


// 回车 + enter 自动生成 getter setter
public class Student {
    public String name;
    public Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


// 之前在 spring 中，如果需要初始化一个  class
//<bean id="student">
//    <property name="name" value="jack" />
//    <property name="age"  value="18" />
//</bean>
