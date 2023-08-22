package com.georgebanin.studentcourses.repository;

import com.georgebanin.studentcourses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findByNameLike(String course);
}
