package com.georgebanin.studentcourses;

import com.georgebanin.studentcourses.service.CourseStudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCoursesApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CourseStudentService service){
//		return args-> {
//			service.tieCoursestoStudents();
//		};
//	}


}
