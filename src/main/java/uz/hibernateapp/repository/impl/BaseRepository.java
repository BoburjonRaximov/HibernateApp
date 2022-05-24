package uz.hibernateapp.repository.impl;

import uz.hibernateapp.domain.BaseEntity;
import uz.hibernateapp.repository.IRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BaseRepository<T extends BaseEntity> implements IRepository<T> {
    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager em;

    public BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
        if (entity.getId() != null) {
            em.merge(entity);
        } else {
            em.persist(entity);
        }
        return entity;
    }

    @Override
    public T get(Long id) {
        try {
            return em.find(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T get(String uuid) {
        try {
            List<T> itemList = em.createQuery("select obj from " + entityClass.getName() + " obj where obj.uuid=:uuid")
                    .setParameter("uuid", uuid)
                    .setMaxResults(1)
                    .getResultList();
            if (itemList.isEmpty()) {
                return null;
            }
            return itemList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        em.remove(em.find(entityClass, id));
    }
}
