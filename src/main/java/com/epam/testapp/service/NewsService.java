package com.epam.testapp.service;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.dao.jdbc.JdbcNewsDao;
import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {



    public News save(News news) {

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        NewsDao newsDao = new JdbcNewsDao();
        News savedNews = newsDao.save(news);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return savedNews;
    }

    public List<News> getAll() {

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        NewsDao newsDao = new JdbcNewsDao();
        List<News> newsList = newsDao.findAll();
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return newsList;
    }
}
