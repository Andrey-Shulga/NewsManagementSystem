package com.epam.testapp.soap;

import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.BaseEntity;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface NewsSoap<T extends BaseEntity> {

    List<T> getNewsList() throws ControllerException;

    T getNews(long id) throws ControllerException;

    T saveNews(T news) throws ControllerException;

    void deleteNews(long id) throws ControllerException;

    void deleteNewsList(List<Long> idList) throws ControllerException;
}
