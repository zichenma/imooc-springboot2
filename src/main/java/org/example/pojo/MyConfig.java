package org.example.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component // 把本配置放入到springboot容器中，使其扫描到
@ConfigurationProperties(prefix = "user")
@PropertySource(value="classpath:MyConfig.properties", encoding = "utf-8")
public class MyConfig {
    public String name;
    public Integer age;
    public String sex;

    // 这里不需要 constructor, 因为属性在 MyConfig.properties 里
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
