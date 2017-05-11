package com.epam.testapp.service;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsService {

    @Autowired
    @Qualifier("HibernateJpaNewsDao")
    private NewsDao newsDao;

    public News save(News news) {

        return newsDao.save(news);
    }

    public List<News> getAll() {

        return newsDao.findAll();
    }

    public void delete (News news){

        newsDao.delete(news);
    }

    public void deleteList (List<News> newsList){

        newsDao.deleteList(newsList);
    }

    public News getById (long id){

        return newsDao.findById(News.class, id);
    }
}
