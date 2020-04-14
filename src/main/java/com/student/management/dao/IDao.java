package com.student.management.dao;

import com.student.management.model.BaseEntity;

public interface IDao<T extends BaseEntity> {

    T findById(Integer id);

    Integer save(T entity);

    void delete(T entity);

    void merge(T entity);

}
