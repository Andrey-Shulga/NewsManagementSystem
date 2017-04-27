package com.epam.testapp.service;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("NewsService");
    @Autowired
    @Qualifier("HibernateXmlNewsDao")
    private NewsDao newsDao;

    public News save(News news) {

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        News savedNews = newsDao.save(news);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return savedNews;
    }

    public List<News> getAll() {

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        List<News> newsList = newsDao.findAll();
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return newsList;
    }

    public void delete (News news){

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        newsDao.delete(news);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

    }

    public void deleteList (List<News> newsList){

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        newsDao.deleteList(newsList);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

    }

    public News getById (long id){

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        News news = newsDao.findById(News.class, id);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return news;
    }
}
