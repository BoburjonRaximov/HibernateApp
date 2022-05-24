package uz.hibernateapp.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.hibernateapp.domain.StudentEntity;
import uz.hibernateapp.repository.StudentRepository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentRepositoryImpl extends BaseRepository<StudentEntity> implements StudentRepository {

    public StudentRepositoryImpl() {
        super(StudentEntity.class);
    }

    @Override
    public List<StudentEntity> getStudents() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select r from StudentEntity r ");
        queryBuilder.append("order by r.id desc ");
        Query query = em.createQuery(queryBuilder.toString());
        query.setFirstResult(1);
        query.setMaxResults(10);
        return query.getResultList();
    }
}
