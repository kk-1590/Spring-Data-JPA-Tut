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

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Kartik");
        System.out.println("students = " + studentList);
    }

    @Test
    public void printStudentByLastName() {
        List<Student> studentList = studentRepository.findByLastName("Sharma");
        System.out.println("students = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("oh");
        System.out.println("students = " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> studentList = studentRepository.findByGuardian_guardianName("ABC");
        System.out.println("students = " + studentList);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("Mohit", "Sharma");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailAddress("kk@abc.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailId() {
        String sname = studentRepository.getStudentFirstNameByEmailAddress("kk@abc.com");
        System.out.println("sname = " + sname);
    }

    @Test
    public void printStudentByEmailIdNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("kk@abc.com");
        System.out.println("student = " + student);
    }
}