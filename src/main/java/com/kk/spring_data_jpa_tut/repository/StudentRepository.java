package com.kk.spring_data_jpa_tut.repository;

import com.kk.spring_data_jpa_tut.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastName(String lastName);

    public List<Student> findByGuardian_guardianName(String guardianName);

    public Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL query
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String emailId);

    //Native Query
    @Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
    public Student getStudentByEmailAddressNative(String emailId);
}
