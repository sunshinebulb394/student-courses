package com.georgebanin.studentcourses.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.georgebanin.studentcourses.entity.*;
import com.georgebanin.studentcourses.repository.CourseRepository;
import com.georgebanin.studentcourses.repository.CourseStudentRepository;
import com.georgebanin.studentcourses.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseStudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseStudentRepository courseStudentRepository;
    private final ObjectsValidator<Student> studentValidator;
    public void addStudent(Student student){
//        var course = courseRepository.findById(1).get();

        studentValidator.validate(student);
      var stud =   studentRepository.save(Student.builder()
                        .age(student.getAge())
                        .gender(student.getGender())
                        .name(student.getName())
                .build());

    }

    public void addCourse(Course course){
        courseRepository.save(Course.builder()
                .name(course.getName())
                .build());

    }

    public List<?> getStudents(){
     List<StudentRecord> students = studentRepository.findAll().stream()
                .map(std -> {
                    List<String> cou =  std.getRegisteredCourses().stream()
                            .map(c -> c.getCourse().getName()).collect(Collectors.toList());
                   return StudentRecord.builder().id(std.getId()).name(std.getName()).courses(cou).build();

                }).collect(Collectors.toList());
        return students;
    }
    public List<?> getCourses(){
     return courseRepository.findAll();
    }

    public void tieCoursestoStudents(){
        var courses = courseRepository.findAll();
        studentRepository.findAll().forEach(student -> {
            List<CourseStudent> courseStudents = new ArrayList<>();
            courses.forEach(course -> {
                var courseStudent =   CourseStudent.builder()
                        .id(new CourseStudentKey(student.getId(), course.getId()))
                        .course(course)
                        .student(student)
                        .endDate(new Date(2022,10,15))
                        .startDate(new Date(2021,5,12))
                        .build();
                courseStudents.add(courseStudent);
            });
            courseStudentRepository.saveAll(courseStudents);
            student.setRegisteredCourses(courseStudents);
        });
    }

    public List<Cat> consumeRest(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.thecatapi.com/v1/images/search?limit=10";
        List<Cat> cat = restTemplate.getForObject(url, List.class);
        return cat;


    }

    public List<Course> getCourseLike(String name){
        return courseRepository.findByNameLike("%"+name+"%");
    }


}
