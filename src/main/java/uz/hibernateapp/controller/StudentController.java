package uz.hibernateapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.hibernateapp.domain.StudentEntity;
import uz.hibernateapp.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/student/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("list")
    public List<StudentEntity> getStudents(){
        return studentService.getStudents();
    }
}
