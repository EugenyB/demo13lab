package com.example.demo.controller;

import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {

    private final StudentService studentService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name, @RequestParam Integer age, @RequestParam Double rating) {
        studentService.addStudent(name, age, rating);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addStudentForm() {
        return "add_student";
    }

    @GetMapping("/rating")
    public String rating(Model model) {
        model.addAttribute("students", studentService.getStudentsByRating(0));
        return "rating_filter";
    }

    @PostMapping("/rating")
    public String rating(@RequestParam Double rating, Model model) {
        model.addAttribute("students", studentService.getStudentsByRating(rating));
        return "rating_filter";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
