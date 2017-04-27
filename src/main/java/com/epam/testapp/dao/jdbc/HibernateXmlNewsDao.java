package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("HibernateXmlNewsDao")
public class HibernateXmlNewsDao extends GenericDao<News> implements NewsDao {

    @Override
    public List<News> findAll() {

        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.getNamedQuery("findAll");
        List<News> newsList = query.list();


        session.getTransaction().commit();
        return newsList;
    }

    @Override
    public News save(News entity) {

        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Query query = session.getNamedQuery("saveNews");

        query.setParameter("title", entity.getTitle());
        query.setParameter("date", entity.getDate());
        query.setParameter("brief", entity.getBrief());
        query.setParameter("content", entity.getContent());
        query.executeUpdate();
        return entity;
    }
}
