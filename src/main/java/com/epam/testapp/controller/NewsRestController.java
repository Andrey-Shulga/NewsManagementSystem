package com.epam.testapp.controller;

import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;

@RestController
@RequestMapping("/rest/news")
public class NewsRestController implements NewsController {

    private static final Logger log = LoggerFactory.getLogger("NewsRestController");
    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private NewsService newsService;

    public NewsRestController() {

        mapper.setSerializationInclusion(NON_NULL);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getNews(@PathVariable String id) throws ControllerException {

        News news = newsService.getById(Long.parseLong(id));
        String value;
        try {
            value = mapper.writeValueAsString(news);

        } catch (IOException e) {
            throw new ControllerException(e);
        }
        log.debug("get entity by id = {}", value);
        return value;

    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    @RequestMapping(value = "/delete/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String deleteNewsList(@RequestBody String jsonNewsIds) throws ControllerException {

        String value;
        try {
            List<News> newsList = Arrays.asList(mapper.readValue(jsonNewsIds, News[].class));
            newsService.deleteList(newsList);
            value = mapper.writeValueAsString(newsList);
        } catch (IOException e) {
            throw new ControllerException(e);
        }
        return value;
    }
}
