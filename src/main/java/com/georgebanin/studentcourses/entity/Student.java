package com.georgebanin.studentcourses.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "name must not be null")
    private String name;
    @NotNull(message = "gender must not be null")
    private String gender;
    @NotNull(message = "age must not be null")
    private Integer age;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    List<CourseStudent> registeredCourses;



}
