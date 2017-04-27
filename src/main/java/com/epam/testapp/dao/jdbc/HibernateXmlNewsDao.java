package com.epam.testapp.dao.jdbc;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("HibernateXmlNewsDao")
public class HibernateXmlNewsDao extends GenericDao<News> implements NewsDao {

    @Override
    public List<News> findAll() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery("News.findAll");

        return (List<News>) query.list();
    }

    @Override
    public News save(News entity) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query;
        if (entity.getId() == 0) {
            query = session.getNamedQuery("News.saveNews");
            setAndExecute(entity, query);
            long lastId = ((BigDecimal) session.createSQLQuery("SELECT MYDB.NEWS_SEQ.currval FROM dual").uniqueResult()).longValue();
            entity.setId(lastId);
        } else {
            query = session.getNamedQuery("News.updateNews");
            query.setParameter("id", entity.getId());
            setAndExecute(entity, query);
        }

        return entity;
    }

    private void setAndExecute(News entity, Query query) {

        query.setParameter("title", entity.getTitle());
        query.setParameter("date", entity.getDate());
        query.setParameter("brief", entity.getBrief());
        query.setParameter("content", entity.getContent());
        query.executeUpdate();
    }

    @Override
    public News findById(Class<News> entityClass, long id) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery("News.findById");
        query.setParameter("id", id);

        return (News) query.uniqueResult();
    }

    @Override
    public void delete(News entity) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery("News.deleteById");
        query.setParameter("id", entity.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteList(List<News> entityList) {

        List<Long> idList = new ArrayList<>();
        for (News news : entityList)
            idList.add(news.getId());
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery("News.deleteList");
        query.setParameterList("ids", idList);
        query.executeUpdate();

    }
}
