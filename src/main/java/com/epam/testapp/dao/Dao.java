package com.epam.testapp.dao;

import com.epam.testapp.model.BaseEntity;

import java.util.List;

public interface Dao<T extends BaseEntity> {

    T save(T entity);

    List<T> findAll();

    T findById(Class<T> entityClass, long id);

    void delete(T entity);

    void deleteList(List<T> entityList);
}
