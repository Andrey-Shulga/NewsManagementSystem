package com.epam.testapp.soap;

import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(endpointInterface = "com.epam.testapp.soap.NewsSoap", serviceName = "News")
public class NewsSoapWebService implements NewsSoap<News> {

    @Autowired
    private NewsService newsService;

    @Override
    @WebMethod
    public List<News> getNewsList() throws ControllerException {

        return newsService.getAll();
    }

    @Override
    @WebMethod
    public News getNews(long id) throws ControllerException {
        return null;
    }

    @Override
    @WebMethod
    public News saveNews(News news) throws ControllerException {
        return null;
    }

    @Override
    @WebMethod
    public void deleteNews(News news) throws ControllerException {

    }

    @Override
    @WebMethod
    public void deleteNewsList(List<News> newsList) throws ControllerException {

    }
}
