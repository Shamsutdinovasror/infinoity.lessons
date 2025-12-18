package org.aakkmm.students_web.controller;

import org.aakkmm.students_web.model.StudentModel;
import org.aakkmm.students_web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }
/*
    @PostMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }*/

    @PostMapping("/student/add")
    public String addStudent(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             @RequestParam int age,
                             @RequestParam String phoneNumber) {
        studentService.addStudent(firstName, lastName, email, age, phoneNumber);
        return "redirect:/";
    }

    /*@GetMapping("/student/edit/{id}")
    public String detailsStudent(@PathVariable Long id, Model model){
        StudentModel student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/student/edit/{id}")
    public String editStudent(@RequestParam Long id,
                              @RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String email,
                              @RequestParam int age,
                              @RequestParam (required = false) String phoneNumber){
        studentService.editStudent(id, firstName, lastName, email, age, phoneNumber);
        return "redirect:/student?edited=true";
    }
*/
}