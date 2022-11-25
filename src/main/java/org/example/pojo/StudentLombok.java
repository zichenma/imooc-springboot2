package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // 生成get和set方法
@ToString // 生成 toString 方法
@NoArgsConstructor // 生成默认构造函数
@AllArgsConstructor // 生成全参数的构造函数
public class StudentLombok {
    public String name;
    public Integer age;
}
