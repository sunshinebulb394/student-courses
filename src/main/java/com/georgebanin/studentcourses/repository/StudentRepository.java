package com.georgebanin.studentcourses.repository;

import com.georgebanin.studentcourses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
