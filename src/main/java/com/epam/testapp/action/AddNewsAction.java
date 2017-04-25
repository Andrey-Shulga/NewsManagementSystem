package com.epam.testapp.action;

import com.epam.testapp.form.NewsForm;
import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;
import com.epam.testapp.util.DateConverter;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static com.epam.testapp.constant.ConstantHolder.NEWS_ATTRIBUTE;
import static com.epam.testapp.constant.ConstantHolder.SUCCESS;


public class AddNewsAction extends Action {

    @Autowired
    private NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        String date = newsForm.getNews().getStrDate();
        Date parsedDate= DateConverter.getStrToDate(date);
        newsForm.getNews().setDate(parsedDate);
        News savedNews = newsService.save(newsForm.getNews());
        newsForm.setNews(savedNews);
        request.setAttribute(NEWS_ATTRIBUTE, savedNews);

        return mapping.findForward(SUCCESS);
    }
}
