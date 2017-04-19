package com.epam.testapp.dao;

import com.epam.testapp.model.BaseEntity;

import java.util.List;

public interface Dao<T extends BaseEntity> {

    T save(T entity);

    List<T> findAll();

    T findById(long id);

    void update(T entity);

    T findById(Class<T> entityClass, int id);

    void delete(T entity);
}
