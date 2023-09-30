package com.example.assign2.Controller;

import com.example.assign2.GRASPexample.HonorStudent;
import com.example.assign2.GRASPexample.Student;
import com.example.assign2.GRASPexample.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/grasp")
    public String showStudents(Model model) {
        // Creating and adding a student to the service
        Student regularStudent = new Student(1L, "John Doe", 20);
        HonorStudent honorStudent = new HonorStudent(2L, "Alice Smith", 19, 4.0);
        studentService.addStudent(regularStudent);
        studentService.addStudent(honorStudent);

        // Retrieve students from the StudentService
        List<Student> students = studentService.getAllStudents();

        // Add students to the Thymeleaf model
        model.addAttribute("students", students);

        return "students";
    }
}
