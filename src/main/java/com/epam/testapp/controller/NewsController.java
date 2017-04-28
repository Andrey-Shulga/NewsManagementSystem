package com.epam.testapp.controller;

import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.News;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface NewsController {

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getNewsList() throws ControllerException;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getNews(@PathVariable String id) throws ControllerException;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveNews(@RequestBody News jsonBody) throws ControllerException;

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteNews(@RequestBody News jsonBody) throws ControllerException;

    @RequestMapping(value = "/delete/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteNewsList(@PathVariable String jsonNewsIds) throws ControllerException;
}
