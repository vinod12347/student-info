package com.studentinfo.service;

import com.studentinfo.model.Student;
import com.studentinfo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student saveStudent(Student student){
        Student savedStudent = studentRepository.save(student);
        return  savedStudent;
    }

    public List<Student> getStudents(){
        List<Student> students = studentRepository.findAll();

     return    students.stream().filter(student->{
            Student student1=null;
            String dateOfBirth = student.getDateOfBirth();
            try{
            LocalDate localDate = LocalDate.parse(dateOfBirth,  DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            if(localDate.getMonth().equals(LocalDate.now().getMonth())){
                return true;
            }}
            catch(Exception ex){
             System.out.println(ex.getMessage());
            }
            return false;
        }).collect(Collectors.toList());
    }
}
