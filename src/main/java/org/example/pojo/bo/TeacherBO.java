package org.example.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;


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

    @Min(value = 1, message = "Minimum grade for teacher is 1")
    @Max(value = 6, message = "Maximum grade for teacher is 6")
    private Integer grade;

    @Range(min = 1, max = 18, message = "Teacher's classroom between 1~18")
    private Integer classroom;

    @Size(min = 2, max = 5, message = "At least 2 skills, at most 5 skills")
    private List<String> skill;

    @Length(min = 3, max = 8, message = "Teacher's english name should between 1~18")
    private String englishName;

    @Email(message = "Incorrect email format")
    private String email;
}