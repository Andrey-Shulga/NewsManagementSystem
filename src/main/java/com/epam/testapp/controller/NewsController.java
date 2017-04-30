package com.epam.testapp.controller;

import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.News;

public interface NewsController {

    String getNewsList() throws ControllerException;

    String getNews(String id) throws ControllerException;

    String saveNews(News jsonBody) throws ControllerException;

    String deleteNews(News jsonBody) throws ControllerException;

    String deleteNewsList(String jsonNewsIds) throws ControllerException;
}
