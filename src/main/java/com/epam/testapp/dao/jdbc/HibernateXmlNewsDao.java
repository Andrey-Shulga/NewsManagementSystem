package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.hibernate.Query;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Qualifier("HibernateXmlNewsDao")
public class HibernateXmlNewsDao extends GenericDao<News> implements NewsDao {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("HibernateXmlNewsDao");

    @Override
    public List<News> findAll() {

        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.getNamedQuery("News.findAll");
        List<News> newsList = query.list();


        session.getTransaction().commit();
        return newsList;
    }

    @Override
    public News save(News entity) {

        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query;
        if (entity.getId() == 0)
            query = session.getNamedQuery("News.saveNews");
        else {
            query = session.getNamedQuery("News.updateNews");
            query.setParameter("id", entity.getId());
        }
        query.setParameter("title", entity.getTitle());
        query.setParameter("date", entity.getDate());
        query.setParameter("brief", entity.getBrief());
        query.setParameter("content", entity.getContent());
        query.executeUpdate();

        Long lastId = ((BigDecimal) session.createSQLQuery("SELECT MYDB.NEWS_SEQ.currval FROM dual").uniqueResult()).longValue();
        entity.setId(lastId);
        log.debug("news = {}", entity);

        return entity;
    }

    @Override
    public News findById(Class<News> entityClass, long id) {

        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery("News.findById");
        query.setParameter("id", id);

        return (News) query.uniqueResult();
    }
}
