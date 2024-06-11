package com.kk.spring_data_jpa_tut.repository;

import com.kk.spring_data_jpa_tut.entity.Course;
import com.kk.spring_data_jpa_tut.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourses() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }
}