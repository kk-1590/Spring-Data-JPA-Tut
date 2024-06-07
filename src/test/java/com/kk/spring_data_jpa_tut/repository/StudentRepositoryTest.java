package com.kk.spring_data_jpa_tut.repository;

import com.kk.spring_data_jpa_tut.entity.Guardian;
import com.kk.spring_data_jpa_tut.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("kk@abc.com")
                .firstName("Kartik")
                .lastName("Kh")
//                .guardianName("ABC")
//                .guardianEmail("abc@def.com")
//                .guardianMobile("9999888989")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .guardianEmail("abc@gmail.com")
                .guardianName("ABC")
                .guardianMobile("92789472424")
                .build();


        Student student = Student.builder()
                .firstName("Mohit")
                .lastName("Sharma")
                .emailId("mohit@abc.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }
}