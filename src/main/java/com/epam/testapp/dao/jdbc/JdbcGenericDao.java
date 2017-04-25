package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.Dao;
import com.epam.testapp.model.BaseEntity;
import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class JdbcGenericDao<T extends BaseEntity> implements Dao<T> {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("JdbcGenericDao");

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

        List<T> newsList;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(News.class);
            criteria.addOrder(Order.desc("date"));
            newsList = criteria.list();

            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return newsList;
    }
}
