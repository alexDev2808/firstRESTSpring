package com.jath.firstCRUD.controller;

import com.jath.firstCRUD.entity.Student;
import com.jath.firstCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getStudents();
    }

    @PostMapping
    public Student saveUpdate(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return student;
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getById(@PathVariable("studentId") Long studentId) {
        return studentService.getStudentById(studentId);
    }
}
