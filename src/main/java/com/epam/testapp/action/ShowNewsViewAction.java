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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.testapp.constant.ConstantHolder.ID_ATTRIBUTE;
import static com.epam.testapp.constant.ConstantHolder.SUCCESS;

public class ShowNewsViewAction extends Action {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("ShowNewsViewAction");
    @Autowired
    NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        String id = request.getParameter(ID_ATTRIBUTE);
        log.debug("news view id = {}", id);
        News news= new News();
        if (id != null) {
            news = newsService.getById(Long.parseLong(id));
            newsForm.setNews(news);
        }
        request.setAttribute("news", news);
        return mapping.findForward(SUCCESS);
    }
}
