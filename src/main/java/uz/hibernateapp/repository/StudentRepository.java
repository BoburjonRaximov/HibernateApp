package uz.hibernateapp.repository;

import uz.hibernateapp.domain.StudentEntity;

import java.util.List;

public interface StudentRepository extends IRepository<StudentEntity> {
    List<StudentEntity> getStudents();
}
