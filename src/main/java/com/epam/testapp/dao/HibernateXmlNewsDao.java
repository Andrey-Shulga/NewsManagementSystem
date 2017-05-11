package com.epam.testapp.dao;

import com.epam.testapp.model.News;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.epam.testapp.constant.ConstantHolder.*;

@Repository
@Qualifier("HibernateXmlNewsDao")
public class HibernateXmlNewsDao extends GenericDao<News> implements NewsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<News> findAll() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery(FIND_ALL_NAMED_QUERY);

        return (List<News>) query.list();
    }

    @Override
    public News save(News entity) {

        Session session = sessionFactory.getCurrentSession();
        Query query;
        if (entity.getId() == 0) {
            query = session.getNamedQuery(SAVE_NEWS_NAMED_QUERY);
            setAndExecute(entity, query);
            long lastId = (long) session.createSQLQuery(GET_LAST_INSERTED_ID_QUERY).uniqueResult();
            entity.setId(lastId);
        } else {
            query = session.getNamedQuery(UPDATE_NEWS_NAMED_QUERY);
            query.setParameter(ID, entity.getId());
            setAndExecute(entity, query);
        }

        return entity;
    }

    private void setAndExecute(News entity, Query query) {

        query.setParameter(TITLE, entity.getTitle());
        query.setParameter(DATE, entity.getDate());
        query.setParameter(BRIEF, entity.getBrief());
        query.setParameter(CONTENT, entity.getContent());
        query.executeUpdate();
    }

    @Override
    public News findById(Class<News> entityClass, long id) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery(FIND_BY_ID_NAMED_QUERY);
        query.setParameter(ID, id);

        return (News) query.uniqueResult();
    }

    @Override
    public void delete(News entity) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery(DELETE_BY_ID_NAMED_QUERY);
        query.setParameter(ID, entity.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteList(List<News> entityList) {

        List<Long> idList = new ArrayList<>();
        for (News news : entityList)
            idList.add(news.getId());
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery(DELETE_NEWS_LIST_NAMED_QUERY);
        query.setParameterList(ID_LIST, idList);
        query.executeUpdate();

    }
}
