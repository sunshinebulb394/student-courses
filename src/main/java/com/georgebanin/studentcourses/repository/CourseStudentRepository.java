package com.georgebanin.studentcourses.repository;

import com.georgebanin.studentcourses.entity.CourseStudent;
import com.georgebanin.studentcourses.entity.CourseStudentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudent,CourseStudentKey> {

}
