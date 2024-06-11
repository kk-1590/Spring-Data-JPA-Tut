package com.kk.spring_data_jpa_tut.repository;

import com.kk.spring_data_jpa_tut.entity.Course;
import com.kk.spring_data_jpa_tut.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course = Course.builder()
                .title("DAA")
                .credit(7)
                .build();

        Course course1 = Course.builder()
                .title("DBMS")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Sachin")
                .lastName("Gupta")
//                .courses(List.of(course,course1))
                .build();

        teacherRepository.save(teacher);
    }
}