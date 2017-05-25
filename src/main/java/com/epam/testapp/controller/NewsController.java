package com.epam.testapp.controller;

import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.BaseEntity;

public interface NewsController<T extends BaseEntity> {

    String getNewsList() throws ControllerException;

    String getNews(String id) throws ControllerException;

    String saveNews(T jsonBody) throws ControllerException;

    String deleteNews(T jsonBody) throws ControllerException;

    String deleteNewsList(String jsonNewsIds) throws ControllerException;
}
