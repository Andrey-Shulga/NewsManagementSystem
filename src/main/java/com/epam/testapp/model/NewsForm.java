package com.epam.testapp.model;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class NewsForm extends ValidatorForm {

    private News news = new News();
    private List<News> newsList;

    public NewsForm() {

    }

    public News getNews() {

        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        News news = new News();
    }
}
