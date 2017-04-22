package com.epam.testapp.action;

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

import static com.epam.testapp.constant.ConstantHolder.*;

public class ShowAddNewsFormAction extends Action {

    @Autowired
    NewsService newsService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter(ID_ATTRIBUTE);
        News news = new News();
        if (id != null) {
            news = newsService.getById(Long.parseLong(id));
        } else
        {
            Date date = DateConverter.getNewDate(new Date().toString());
            news.setDate(date);
        }
        request.setAttribute(NEWS_ATTRIBUTE, news);
        return mapping.findForward(SUCCESS);
    }
}
