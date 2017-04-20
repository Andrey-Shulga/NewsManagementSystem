package com.epam.testapp.service;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import com.epam.testapp.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public News save(News news) {

        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        News savedNews = newsDao.save(news);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return savedNews;
    }

    public List<News> getAll() {


        List<News> newsList = newsDao.findAll();

        return newsList;
    }
}
