package com.epam.testapp.controller;

import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;
import org.codehaus.jackson.map.ObjectMapper;
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

    @Override
    public String getNewsList() throws ControllerException {

        List<News> newsList = newsService.getAll();
        String value;
        try {
            value = mapper.writeValueAsString(newsList);

        } catch (IOException e) {
            throw new ControllerException(e);
        }
        return value;
    }

    @Override
    public String getNews(@PathVariable String id) throws ControllerException {

        News news = newsService.getById(Long.parseLong(id));
        String value;
        try {
            value = mapper.writeValueAsString(news);

        } catch (IOException e) {
            throw new ControllerException(e);
        }
        log.debug("get entity = {}", value);
        return value;

    }

    @Override
    public String saveNews(@RequestBody News jsonBody) throws ControllerException {

        String value;
        try {
            newsService.save(jsonBody);
            value = mapper.writeValueAsString(jsonBody);
        } catch (IOException e) {
            throw new ControllerException(e);
        }
        log.debug("saved entity = {}", value);
        return value;
    }

    @Override
    public String deleteNews(@RequestBody News jsonBody) throws ControllerException {

        String value;
        try {
            newsService.delete(jsonBody);
            value = mapper.writeValueAsString(jsonBody);
        } catch (IOException e) {
            throw new ControllerException(e);
        }
        log.debug("deleted entity = {}", value);
        return value;
    }

    @Override
    public String deleteNewsList(String jsonNewsIds) throws ControllerException {


        return null;
    }
}
