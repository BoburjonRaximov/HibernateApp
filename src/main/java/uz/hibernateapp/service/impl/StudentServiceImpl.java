package uz.hibernateapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.hibernateapp.domain.StudentEntity;
import uz.hibernateapp.repository.StudentRepository;
import uz.hibernateapp.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StudentEntity> getStudents() {
        return studentRepository.getStudents();
    }
}
