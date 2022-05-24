package uz.hibernateapp.repository;

import uz.hibernateapp.domain.BaseEntity;

public interface IRepository <T extends BaseEntity>{
    T save(T entity);
    T get(Long id);
    T get(String uuid);
    void delete (Long id);
}
