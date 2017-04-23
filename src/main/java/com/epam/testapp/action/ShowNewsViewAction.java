package com.epam.testapp.action;

import com.epam.testapp.model.News;
import com.epam.testapp.model.NewsForm;
import com.epam.testapp.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.testapp.constant.ConstantHolder.ID_ATTRIBUTE;
import static com.epam.testapp.constant.ConstantHolder.SUCCESS;

public class ShowNewsViewAction extends Action {

    @Autowired
    NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        String id = request.getParameter(ID_ATTRIBUTE);

        if (id != null) {
            News news = newsService.getById(Long.parseLong(id));
            newsForm.setNews(news);
        }
        return mapping.findForward(SUCCESS);
    }
}
