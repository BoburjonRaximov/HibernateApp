package uz.hibernateapp.service;

import uz.hibernateapp.domain.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> getStudents();
}
