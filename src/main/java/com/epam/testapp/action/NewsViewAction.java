package com.epam.testapp.action;

import com.epam.testapp.model.NewsForm;
import com.epam.testapp.util.DateConverter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static com.epam.testapp.constant.ConstantHolder.EDIT;
import static com.epam.testapp.constant.ConstantHolder.NEWS_ATTRIBUTE;

public class NewsViewAction extends DispatchAction {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("NewsViewAction");

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        String date = newsForm.getNews().getNewDate();
        Date parsedDate = DateConverter.getFormatDate(date);
        newsForm.getNews().setDate(parsedDate);

        log.debug("news = {}", newsForm.getNews());
        request.setAttribute(NEWS_ATTRIBUTE, newsForm.getNews());
        return mapping.findForward(EDIT);
    }
}
