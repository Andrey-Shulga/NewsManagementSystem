package com.epam.testapp.dao;

import com.epam.testapp.model.BaseEntity;
import com.epam.testapp.model.News;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class GenericDao<T extends BaseEntity> implements Dao<T> {

    private static final Logger log = LoggerFactory.getLogger("GenericDao");
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T save(T entity) {

        sessionFactory.getCurrentSession().saveOrUpdate(entity);

        return entity;
    }

    @Override
    public T findById(Class<T> entityClass, long id) {

        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public void delete(T entity) {

        sessionFactory.getCurrentSession().delete(entity);

    }

    @Override
    public List<T> findAll() {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(News.class);
        criteria.addOrder(Order.desc("date"));

        return (List<T>) criteria.list();
    }

    @Override
    public void deleteList(List<T> entityList) {

        for (T entity : entityList)
            sessionFactory.getCurrentSession().delete(entity);

    }
}
