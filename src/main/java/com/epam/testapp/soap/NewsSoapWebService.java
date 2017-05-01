package com.epam.testapp.soap;

import com.epam.testapp.exception.ControllerException;
import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Component
@WebService(endpointInterface = "com.epam.testapp.soap.NewsSoap", serviceName = "News")
public class NewsSoapWebService implements NewsSoap<News> {

    private static final Logger log = LoggerFactory.getLogger("NewsSoapWebService");

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

        return newsService.getById(id);
    }

    @Override
    @WebMethod
    public News saveNews(News news) throws ControllerException {

        log.debug("save = {}", news);
        return newsService.save(news);
    }

    @Override
    @WebMethod
    public void deleteNews(long id) throws ControllerException {

        News news = new News(id);
        newsService.delete(news);
    }

    @Override
    @WebMethod
    public void deleteNewsList(List<Long> idList) throws ControllerException {

        List<News> newsList = new ArrayList<>();
        for (Long id : idList) {
            News news = new News(id);
            newsList.add(news);
        }
        newsService.deleteList(newsList);
    }
}
