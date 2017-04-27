package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.Dao;
import com.epam.testapp.model.BaseEntity;
import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class GenericDao<T extends BaseEntity> implements Dao<T> {

    @Override
    public T save(T entity) {

        HibernateUtil.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public T findById(Class<T> entityClass, long id) {

        T entity = (T) HibernateUtil.getSessionFactory().getCurrentSession().get(entityClass, id);
        return entity;
    }

    @Override
    public void delete(T entity) {

        HibernateUtil.getSessionFactory().getCurrentSession().delete(entity);

    }

    @Override
    public List<T> findAll() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(News.class);
        criteria.addOrder(Order.desc("date"));

        return (List<T>) criteria.list();
    }

    @Override
    public void deleteList(List<T> entityList) {

        for (T entity : entityList)
            HibernateUtil.getSessionFactory().getCurrentSession().delete(entity);

    }
}
