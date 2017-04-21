package com.epam.testapp.action;

import com.epam.testapp.model.News;
import com.epam.testapp.model.NewsForm;
import com.epam.testapp.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static com.epam.testapp.constant.ConstantHolder.SUCCESS;


public class AddNewsAction extends Action {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("AddNewsAction");
    private static final String NEWS_ATTRIBUTE = "news";
    @Autowired
    private NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        //String id =  request.getParameter("id");
        //if (id==null) ((NewsForm) form).getNews().setId(null);
        log.debug("id = {}", newsForm.getNews().getId());
        if (newsForm.getNews().getDate() == null) newsForm.getNews().setDate(new Date());
        News savedNews = newsService.save(newsForm.getNews());
        request.setAttribute(NEWS_ATTRIBUTE, savedNews);

        return mapping.findForward(SUCCESS);
    }
}
