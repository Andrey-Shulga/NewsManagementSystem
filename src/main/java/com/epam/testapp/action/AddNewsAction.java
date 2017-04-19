package com.epam.testapp.action;

import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.LoggerFactory;

import static com.epam.testapp.constant.ConstantHolder.SUCCESS;

public class AddNewsAction extends Action {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("JdbcGenericDao");


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {

        News news = new News();
        NewsService newsService = new NewsService();
        newsService.save(news);

        return mapping.findForward(SUCCESS);
    }
}