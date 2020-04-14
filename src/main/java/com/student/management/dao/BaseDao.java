package com.student.management.dao;

import com.student.management.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDao<T extends BaseEntity> implements IDao<T>{

    @PersistenceContext
    protected EntityManager em;

    private Class<T> clazz;

    public BaseDao(Class<T> clazz) {
        this.clazz=clazz;
    }

    @Override
    public T findById(Integer id) {
        if(id==null) throw new IllegalArgumentException("findById is called when ID is null");
        return em.find(clazz, id);
    }

    @Override
    public Integer save(T entity) {
        em.persist(entity);
        return entity.getId();
    }


    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public void merge(T entity){
        em.merge(entity);
    }

}
