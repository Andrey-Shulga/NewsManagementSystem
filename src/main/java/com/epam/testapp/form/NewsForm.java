package com.epam.testapp.form;

import com.epam.testapp.model.News;
import com.epam.testapp.util.DateConverter;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsForm extends ValidatorForm {

    private News news = new News();
    private List<News> newsList = new ArrayList<>();
    private long[] newsToDelete;

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

    public long[] getNewsToDelete() {
        return newsToDelete;
    }

    public void setNewsToDelete(long[] newsToDelete) {
        this.newsToDelete = newsToDelete;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        String currentDate = DateConverter.getDateToStr(new Date());
        this.news.setStrDate(currentDate);

    }
}
