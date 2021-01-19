package com.geekbrains.controller;

import com.geekbrains.entity.Student;
import com.geekbrains.service.StudentService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/student")
@CommonsLog
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService brandService) {
        this.studentService = brandService;
    }

    @GetMapping
    public String findAll(Model model) {
        log.info("Show all students");
        model.addAttribute("students", studentService.findAll());
        return "all-students";
    }

    @GetMapping("new")
    public String createStudent(Model model) {
        log.info("Start to create new student");
        model.addAttribute("student", new Student());
        return "student";
    }

    @GetMapping("edit")
    public String editStudent(Model model,
                            @RequestParam(value = "id") Optional<Long> id) {
        log.info("Start to edit student!" + id.orElse(-1L));

        model.addAttribute("student", studentService.findById(id.orElse(-1L)));
        return "student";
    }

    @PostMapping
    public String saveStudent(Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            return "student";
        }

        studentService.save(student);
        return "redirect:/student";
    }

    @DeleteMapping
    public String deleteBrand(@RequestParam("id") Long id){
        log.info("Delete student with id:" + id);
        studentService.deleteById(id);
        return "redirect:/student";
    }
}
