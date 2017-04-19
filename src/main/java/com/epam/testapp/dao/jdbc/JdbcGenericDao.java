package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.Dao;
import com.epam.testapp.model.BaseEntity;
import com.epam.testapp.util.HibernateUtil;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class JdbcGenericDao<T extends BaseEntity> implements Dao<T> {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("JdbcGenericDao");

    @Override
    public T save(T entity) {

        HibernateUtil.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
        log.debug("Saved entity {}", entity);
        return entity;
    }

    @Override
    public T findById(Class<T> entityClass, long id) {

        T entity = (T) HibernateUtil.getSessionFactory().getCurrentSession().get(entityClass, id);
        log.debug("Found entity {}", entity);
        return entity;
    }

    @Override
    public void delete(T entity) {

        HibernateUtil.getSessionFactory().getCurrentSession().delete(entity);
        log.debug("Deleted entity {}", entity);
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
