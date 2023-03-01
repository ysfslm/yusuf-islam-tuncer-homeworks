package edu.sabanciuniv.hw04.controller;

import edu.sabanciuniv.hw04.model.Student;
import edu.sabanciuniv.hw04.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping // Add new student to database
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addNewStudent(student), CREATED);
    }

    @GetMapping // Get all students from database
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAll(), OK);
    }

    @GetMapping("/{id}") // Get a student with specific ID from database
    public ResponseEntity<Student> getAllStudents(@PathVariable Integer id) {
        return new ResponseEntity<>(studentService.getById(id), OK);
    }

    @PutMapping // Update a student data on database
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student), OK);
    }

    @DeleteMapping // Delete a student data from database
    public ResponseEntity<Void> deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}") // Delete a student with specific ID from database
    public ResponseEntity<Void> deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(OK);
    }


}

