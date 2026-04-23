package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(String name, Integer age, double rating) {
        return studentRepository.save(new Student(name, age, rating));
    }

    public List<Student> getStudentsByRating(double minRating) {
        return studentRepository.findByRatingGreaterThanEqualOrderByRatingDesc(minRating);
    }

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
