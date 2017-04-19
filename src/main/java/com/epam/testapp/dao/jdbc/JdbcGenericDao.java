package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.Dao;
import com.epam.testapp.model.BaseEntity;
import com.epam.testapp.util.HibernateUtil;
import org.slf4j.LoggerFactory;

public abstract class JdbcGenericDao<T extends BaseEntity> implements Dao<T> {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("JdbcGenericDao");

    @Override
    public T save(T entity) {

        HibernateUtil.getSessionFactory().getCurrentSession().save(entity);
        log.debug("Saved entity {}", entity);
        return entity;
    }

    @Override
    public void update(T entity) {

        HibernateUtil.getSessionFactory().getCurrentSession().update(entity);
        log.debug("Updated entity {}", entity);
    }

    @Override
    public T findById(Class<T> entityClass, int id) {

        T entity = (T) HibernateUtil.getSessionFactory().getCurrentSession().get(entityClass, id);
        log.debug("Found entity {}", entity);
        return entity;
    }

    @Override
    public void delete(T entity) {

        HibernateUtil.getSessionFactory().getCurrentSession().delete(entity);
        log.debug("Deleted entity {}", entity);
    }
}
