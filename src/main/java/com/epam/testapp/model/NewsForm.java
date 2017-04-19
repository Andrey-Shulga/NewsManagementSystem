package com.epam.testapp.model;

import java.util.List;

public class NewsForm {

    private News news;
    private List<News> newsList;

    public NewsForm() {
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
