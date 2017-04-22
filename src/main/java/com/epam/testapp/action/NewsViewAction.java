package com.epam.testapp.action;

import com.epam.testapp.Form.NewsForm;
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

public class NewsViewAction extends LookupDispatchAction {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("NewsViewAction");
    @Autowired
    private NewsService newsService;

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        String date = newsForm.getNews().getStrDate();
        Date parsedDate = DateConverter.getNewDate(date);
        newsForm.getNews().setDate(parsedDate);

        request.setAttribute(NEWS_ATTRIBUTE, newsForm.getNews());
        return mapping.findForward(EDIT);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        newsService.delete(newsForm.getNews());

        return mapping.findForward(DELETE);
    }

    @Override
    protected Map getKeyMethodMap() {

        Map<String, String> map =  new HashMap();
        map.put("news.view.button.edit", EDIT);
        map.put("news.view.button.delete", DELETE);
        return map;
    }
}
