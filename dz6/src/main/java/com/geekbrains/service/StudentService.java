package com.geekbrains.service;

import com.geekbrains.entity.Student;
import com.geekbrains.repository.StudentRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@CommonsLog
@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    public List<Student> findAll() {
        return repository.findAll();
    }


    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }


    public Optional<Student> findByName(String name) {
        return repository.findByName(name);
    }


    public void save(Student student) {
        repository.save(student);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
