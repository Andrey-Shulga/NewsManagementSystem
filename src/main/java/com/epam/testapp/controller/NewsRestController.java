package com.epam.testapp.controller;

import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rest/news")
public class NewsRestController implements NewsController {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private NewsService newsService;


    @Override
    public String getNewsList() {

        List<News> newsList = newsService.getAll();
        String value = "";
        try {
            value = mapper.writeValueAsString(newsList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public String getNews(@PathVariable String id) {

        News news = newsService.getById(Long.parseLong(id));
        String value = "";
        try {
            value = mapper.writeValueAsString(news);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;

    }
}
