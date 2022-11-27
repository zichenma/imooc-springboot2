package org.example.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@ToString
@AllArgsConstructor
public class TeacherBO {
    private String id;
    @NotBlank
    private String name;
    private Integer age;
    @NotNull
    private Integer sex;
}