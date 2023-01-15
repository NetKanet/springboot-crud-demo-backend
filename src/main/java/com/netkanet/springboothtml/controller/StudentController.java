package com.netkanet.springboothtml.controller;

import com.netkanet.springboothtml.model.Student;
import com.netkanet.springboothtml.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> Students() {
        return studentService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent (Student student) {
        studentService.register(student);
        return ResponseEntity.ok("register success");
    }

    @DeleteMapping("/student-user/{id}")
    public ResponseEntity<?> deleteStudent (@PathVariable String id) {
        return studentService.deleteStudent(id) ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<?> updateBearUser (@RequestBody Student student) throws Exception {
        return ResponseEntity.ok().body(studentService.updateStudentUser(student));
    }

}
