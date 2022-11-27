package org.example.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
public class TeacherBO {
    private String id;

    private String name;

    private Integer age;

    private Integer sex;
}