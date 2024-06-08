package com.studentinfo.controller;

import com.studentinfo.model.Student;
import com.studentinfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));
    }

    @GetMapping("/student/getstudents")
    public ResponseEntity<List<Student>> getStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }
}
