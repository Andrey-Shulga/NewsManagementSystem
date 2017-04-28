package com.epam.testapp.controller;

import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rest/news")
public class NewsRestController implements NewsController {

    private static final Logger log = LoggerFactory.getLogger("NewsRestController");
    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private NewsService newsService;

    public NewsRestController() {
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    }

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

    @Override
    public String saveNews(@RequestBody News jsonBody) {

        log.debug("news before = {}", jsonBody);
        String value = "";
        try {
            newsService.save(jsonBody);
            value = mapper.writeValueAsString(jsonBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("news after = {}", value);
        return value;
    }
}
