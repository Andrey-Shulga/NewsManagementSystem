package com.epam.testapp.action;

import com.epam.testapp.model.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.testapp.constant.ConstantHolder.EDIT;

public class NewsViewAction extends DispatchAction {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("NewsViewAction");

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        log.debug("news = {}", newsForm.getNews());
        request.setAttribute("id", newsForm.getNews().getId());
        return mapping.findForward(EDIT);
    }
}
