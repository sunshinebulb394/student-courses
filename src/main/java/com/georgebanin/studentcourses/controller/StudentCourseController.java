package com.georgebanin.studentcourses.controller;

import com.georgebanin.studentcourses.entity.Course;
import com.georgebanin.studentcourses.entity.Student;
import com.georgebanin.studentcourses.service.CourseStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentCourseController {

    private final CourseStudentService service;

    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
        service.addStudent(student);
        return "student created";
    }
    @PostMapping("/course")
    public String addCourse(@RequestBody Course course){
        service.addCourse(course);
        return "course created";
    }

    @GetMapping("/students")
    public List<?> getStudents(){
        return service.getStudents();
    }
    @GetMapping("/courses")
    public List<?> getCourses(){
        return service.getCourses();
    }

    @GetMapping("/cats")
    public List<?>getCats(){return service .consumeRest();}

    @GetMapping("/courses/like/{name}")
    public List<Course> getCourseLike(@PathVariable String name){
        return service.getCourseLike(name);
    }
}
