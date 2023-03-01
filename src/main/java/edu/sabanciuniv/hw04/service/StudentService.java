package edu.sabanciuniv.hw04.service;

import edu.sabanciuniv.hw04.model.Student;
import edu.sabanciuniv.hw04.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    public Student getById(Integer id) {
        return studentRepository.
                findById((id)).
                orElseThrow(() -> new RuntimeException("Student not found."));
    }
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }


    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
