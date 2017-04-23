package com.epam.testapp.action;

import com.epam.testapp.model.News;
import com.epam.testapp.model.NewsForm;
import com.epam.testapp.service.NewsService;
import com.epam.testapp.util.DateConverter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.epam.testapp.constant.ConstantHolder.*;


public class AddNewsAction extends LookupDispatchAction {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("AddNewsAction");

    @Autowired
    private NewsService newsService;

    public ActionForward addNews(ActionMapping mapping, ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        String date = newsForm.getNews().getStrDate();
        Date parsedDate= DateConverter.getStrToDate(date);
        newsForm.getNews().setDate(parsedDate);
        News savedNews = newsService.save(newsForm.getNews());
        newsForm.setNews(savedNews);
        request.setAttribute(NEWS_ATTRIBUTE, savedNews);

        return mapping.findForward(SUCCESS);
    }


    @Override
    protected Map getKeyMethodMap() {

        Map<String, String> map = new HashMap();
        map.put("add.news.button.submit", ADD_NEWS);
        map.put("add.news.button.cancel", CANCEL);
        return map;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (isCancelled(request))
            return mapping.findForward(CANCEL);
        else
            return super.execute(mapping, form, request, response);
    }
}
