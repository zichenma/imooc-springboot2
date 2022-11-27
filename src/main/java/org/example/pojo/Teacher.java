package org.example.pojo;

import javax.persistence.*;

@Table(name = "teacher")
// @Data 这个也可以用 data, 但是不推荐，因为如果有对该类新的扩展，则当前类会被覆盖，不便于维护, 因此不建议使用 data 在与数据相连时
public class Teacher {
    @Id
    private String id;

    private String name;

    private Integer age;

    private Integer sex;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
}