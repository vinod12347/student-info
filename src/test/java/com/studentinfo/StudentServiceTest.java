package com.studentinfo;

import com.studentinfo.model.Student;
import com.studentinfo.repository.StudentRepository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.studentinfo.service.StudentService;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
     StudentService StudentService;

    @Test
    public void saveStudentTest(){
        Student student=new Student();
        student.setEmail("vinod@gmail.com");
        student.setId("test123");
        student.setLstName("raj");
        Mockito.when(studentRepository.save(student)).thenReturn(student);
        Student student1 = StudentService.saveStudent(student);
        assertThat(student1).isNotNull();
        assertThat(student1.getEmail()).isNotEmpty();
    }
}
