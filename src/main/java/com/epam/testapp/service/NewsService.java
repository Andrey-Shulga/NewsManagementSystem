package com.epam.testapp.service;

import com.epam.testapp.dao.NewsDao;
import com.epam.testapp.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public News save(News news) {

        return newsDao.save(news);
    }

    public List<News> getAll() {

        return newsDao.findAll();
    }
}
